/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/10/18 5:30 PM
 */

package th.co.grouplease.pocservice.query.application;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import th.co.grouplease.pocservice.api.EmploymentApplicationCreatedEvent;

import javax.inject.Inject;

@Component
@ProcessingGroup("asyncSubscriber")
public class EmploymentApplicationEventListener {

  private final EmploymentApplicationRepository repository;

  @Inject
  public EmploymentApplicationEventListener(EmploymentApplicationRepository repository) {
    this.repository = repository;
  }

  @EventHandler
  public void on(EmploymentApplicationCreatedEvent event){
    EmploymentApplicationEntry entry = new EmploymentApplicationEntry();
    entry.setApplicationId(event.getId());
    entry.setFirstName(event.getFirstName());
    entry.setLastName(event.getLastName());
    entry.setEmail(event.getEmail());
    entry.setAddress(event.getAddress());
    repository.save(entry).subscribe();
  }
}
