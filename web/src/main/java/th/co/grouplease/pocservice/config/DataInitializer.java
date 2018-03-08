/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/8/18 3:00 PM
 */

package th.co.grouplease.pocservice.config;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import th.co.grouplease.pocservice.api.CreateEmploymentApplicationCommand;

import javax.inject.Inject;
import java.util.UUID;

@Component
public class DataInitializer implements CommandLineRunner {

  @Inject
  CommandGateway commandGateway;


  @Override
  public void run(String... args) {
    for(int i = 0 ; i < 10 ; i++){
      commandGateway.send(new CreateEmploymentApplicationCommand(UUID.randomUUID().toString()));
    }
  }
}
