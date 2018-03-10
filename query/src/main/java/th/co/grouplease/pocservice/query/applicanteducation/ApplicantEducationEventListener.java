/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/10/18 6:18 PM
 */

package th.co.grouplease.pocservice.query.applicanteducation;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import th.co.grouplease.pocservice.api.EmploymentApplicationCreatedEvent;

import javax.inject.Inject;

@Component
@ProcessingGroup("asyncSubscriber")
public class ApplicantEducationEventListener {
  private final ApplicantEducationRepository repository;

  @Inject
  public ApplicantEducationEventListener(ApplicantEducationRepository repository) {
    this.repository = repository;
  }

  @EventHandler
  public void on(EmploymentApplicationCreatedEvent event){
    ApplicantEducationEntry entry = new ApplicantEducationEntry();
    entry.setApplicationId(event.getId());
    entry.setDegree(event.getDegree());
    entry.setUniversity(event.getUniversity());
    entry.setMajor(event.getMajor());
    entry.setGpa(event.getGpa());
    repository.save(entry).subscribe();
  }
}
