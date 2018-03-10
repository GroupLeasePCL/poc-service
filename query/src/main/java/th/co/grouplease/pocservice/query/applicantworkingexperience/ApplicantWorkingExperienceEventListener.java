/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/10/18 6:18 PM
 */

package th.co.grouplease.pocservice.query.applicantworkingexperience;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import th.co.grouplease.pocservice.api.EmploymentApplicationCreatedEvent;

import javax.inject.Inject;

@Component
@ProcessingGroup("asyncSubscriber")
public class ApplicantWorkingExperienceEventListener {

  private final ApplicantWorkingExperienceRepository repository;

  @Inject
  public ApplicantWorkingExperienceEventListener(ApplicantWorkingExperienceRepository repository) {
    this.repository = repository;
  }

  @EventHandler
  public void on(EmploymentApplicationCreatedEvent event){

  }
}
