/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/8/18 1:37 PM
 */

package th.co.grouplease.pocservice.config;

import com.mongodb.MongoClient;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.common.transaction.TransactionManager;
import org.axonframework.config.EventHandlingConfiguration;
import org.axonframework.eventhandling.*;
import org.axonframework.eventhandling.async.AsynchronousEventProcessingStrategy;
import org.axonframework.eventhandling.async.SequentialPerAggregatePolicy;
import org.axonframework.messaging.interceptors.BeanValidationInterceptor;
import org.axonframework.messaging.interceptors.TransactionManagingInterceptor;
import org.axonframework.mongo.eventhandling.saga.repository.MongoSagaStore;
import org.axonframework.mongo.eventsourcing.eventstore.MongoEventStorageEngine;
import org.axonframework.mongo.eventsourcing.eventstore.StorageStrategy;
import org.axonframework.mongo.eventsourcing.eventstore.documentpercommit.DocumentPerCommitStorageStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.inject.Inject;

@Configuration
public class ApplicationConfig {

  @Value("${spring.data.mongodb.database}")
  private String mongoDatabase;

  @Inject
  public void configure(SimpleCommandBus simpleCommandBus) {
    simpleCommandBus.registerDispatchInterceptor(new BeanValidationInterceptor<>());
  }

  @Bean
  public MongoClient mongo(@Value("${spring.data.mongodb.host}") String mongoHost, @Value("${spring.data.mongodb.port}") int mongoPort) {
    return new MongoClient(mongoHost, mongoPort);
  }

  @Bean
  public MongoTemplate mongoSpringTemplate(MongoClient client){
    return new MongoTemplate(client, mongoDatabase);
  }

  @Bean
  public StorageStrategy storageStrategy() {
    return new DocumentPerCommitStorageStrategy();
  }

  @Bean
  public org.axonframework.mongo.MongoTemplate axonMongoTemplate(MongoClient client){
    return new org.axonframework.mongo.DefaultMongoTemplate(client, mongoDatabase);
  }

  @Bean
  public MongoEventStorageEngine eventStorageEngine(org.axonframework.mongo.MongoTemplate axonTemplate) {
    return new MongoEventStorageEngine(axonTemplate);
  }

  @Bean
  public MongoSagaStore sagaRepository(org.axonframework.mongo.MongoTemplate axonTemplate) {
    return new MongoSagaStore(axonTemplate);
  }

  @Bean
  public ThreadPoolTaskExecutor taskExecutor(){
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(4);
    executor.setMaxPoolSize(4);
    executor.setQueueCapacity(500);
    executor.initialize();
    return executor;
  }

  @Inject
  public void configureEventHandlers(EventHandlingConfiguration ehConfig, ThreadPoolTaskExecutor executor, TransactionManager axonTxManager) {
    ehConfig.registerEventProcessor("asyncSubscriber", (configuration, name, eventHandlers) -> {
      final SubscribingEventProcessor processor = new SubscribingEventProcessor(name,
          new SimpleEventHandlerInvoker(eventHandlers,
              configuration.parameterResolverFactory(),
              configuration.getComponent(ListenerInvocationErrorHandler.class, LoggingErrorHandler::new)),
          configuration.eventBus(),
          new AsynchronousEventProcessingStrategy(executor, new SequentialPerAggregatePolicy()),
          PropagatingErrorHandler.INSTANCE,
          configuration.messageMonitor(SubscribingEventProcessor.class, name));
      processor.registerInterceptor(new TransactionManagingInterceptor<>(axonTxManager));
      return processor;
    });
  }
}
