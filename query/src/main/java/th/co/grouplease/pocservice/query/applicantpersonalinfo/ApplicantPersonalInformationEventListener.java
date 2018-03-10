/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/10/18 6:18 PM
 */

package th.co.grouplease.pocservice.query.applicantpersonalinfo;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import th.co.grouplease.pocservice.api.EmploymentApplicationCreatedEvent;

import javax.inject.Inject;

@Component
@ProcessingGroup("asyncSubscriber")
public class ApplicantPersonalInformationEventListener {

  private final ApplicantPersonalInformationRepository repository;

  @Inject
  public ApplicantPersonalInformationEventListener(ApplicantPersonalInformationRepository repository) {
    this.repository = repository;
  }

  @EventHandler
  public void on(EmploymentApplicationCreatedEvent event){
    ApplicantPersonalInformationEntry entry = new ApplicantPersonalInformationEntry();
    entry.setApplicationId(event.getId());
    entry.setFirstName(event.getFirstName());
    entry.setLastName(event.getLastName());
    entry.setBirthDate(event.getBirthDate());
    entry.setAddress(event.getAddress());
    entry.setEmail(event.getEmail());
    entry.setContactNumber(event.getContactNumber());
    entry.setMobileNumber(event.getMobileNumber());
    entry.setAppliedPosition(event.getAppliedPosition());
    entry.setExpectedSalary(event.getExpectedSalary());
    entry.setReferencePhoneNumber(event.getReferencePhoneNumber());
    repository.save(entry).subscribe();
  }
}
