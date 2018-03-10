/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/10/18 6:18 PM
 */

package th.co.grouplease.pocservice.query.applicantworkingexperience;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import th.co.grouplease.pocservice.api.EmploymentApplicationCreatedEvent;
import th.co.grouplease.pocservice.api.WorkingExperienceUpdatedEvent;

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
    ApplicantWorkingExperienceEntry entry = new ApplicantWorkingExperienceEntry();
    entry.setApplicationId(event.getId());
    entry.setCompany(event.getCurrentCompanyName());
    entry.setStartDate(event.getStartDate());
    entry.setEndDate(event.getEndDate());
    entry.setRole(event.getRole());
    entry.setResponsibility(event.getResponsibility());
    repository.save(entry).subscribe();
  }

  @EventHandler
  public void on(WorkingExperienceUpdatedEvent event){
    repository.findById(event.getApplicationId())
        .flatMap(entry->{
          entry.setCompany(event.getCurrentCompanyName());
          entry.setStartDate(event.getStartDate());
          entry.setEndDate(event.getEndDate());
          entry.setRole(event.getRole());
          entry.setResponsibility(event.getResponsibility());
          return Mono.just(entry);
        }).subscribe(entry->repository.save(entry).subscribe());
  }
}
