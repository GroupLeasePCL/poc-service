/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/8/18 1:55 PM
 */

package th.co.grouplease.pocservice.core;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import th.co.grouplease.pocservice.api.CreateEmploymentApplicationCommand;
import th.co.grouplease.pocservice.api.EmploymentApplicationCreatedEvent;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class EmploymentApplication {
  @AggregateIdentifier
  private String id;

  private EmploymentApplication(){
  }

  @CommandHandler
  public EmploymentApplication(CreateEmploymentApplicationCommand command){
    apply(new EmploymentApplicationCreatedEvent(command.getId()));
  }

  @EventSourcingHandler
  public void on(EmploymentApplicationCreatedEvent event){
    this.id = event.getId();
  }
}

