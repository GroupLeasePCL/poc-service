/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/8/18 2:51 PM
 */

package th.co.grouplease.pocservice.query;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import th.co.grouplease.pocservice.api.EmploymentApplicationCreatedEvent;

import javax.inject.Inject;

@Component
public class EmploymentApplicationEventListener {
  private final EmploymentApplicationRepository repository;

  @Inject
  public EmploymentApplicationEventListener(EmploymentApplicationRepository repository) {
    this.repository = repository;
  }

  @EventHandler
  public void on(EmploymentApplicationCreatedEvent event){
    EmploymentApplicationEntry entry = new EmploymentApplicationEntry();
    entry.setId(event.getId());
    repository.save(entry);
  }
}
