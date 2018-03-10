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
import java.time.LocalDate;
import java.util.UUID;

@Component
@Profile("data")
public class DataInitializer implements CommandLineRunner {

  @Inject
  CommandGateway commandGateway;

  @Override
  public void run(String... args) {
    initializeData(5);
  }

  private void initializeData(int size){
    for(int i = 0 ; i < size ; i++) {
      String id = UUID.randomUUID().toString();
      commandGateway.send(new CreateEmploymentApplicationCommand.Builder(id)
          .name("Peeranut", "Ngaorungsri")
          .birthDate(LocalDate.now())
          .email("nutteen@gmail.com")
          .contactNumber("0887907089")
          .appliedPosition("IT Manager")
          .build());
    }
  }
}
