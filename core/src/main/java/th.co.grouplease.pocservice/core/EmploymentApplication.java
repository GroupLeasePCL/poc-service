/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/8/18 1:55 PM
 */

package th.co.grouplease.pocservice.core;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import th.co.grouplease.pocservice.api.*;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class EmploymentApplication {
  @AggregateIdentifier
  private String id;

  private EmploymentApplication(){
  }

  @CommandHandler
  public EmploymentApplication(CreateEmploymentApplicationCommand command){
    apply(new EmploymentApplicationCreatedEvent(
        command.getId(),
        command.getFirstName(),
        command.getLastName(),
        command.getBirthDate(),
        command.getEmail(),
        command.getContactNumber(),
        command.getAppliedPosition(),
        command.getAddress(),
        command.getMobileNumber(),
        command.getExpectedSalary(),
        command.getReferencePhoneNumber(),
        command.getDegree(),
        command.getUniversity(),
        command.getMajor(),
        command.getGpa(),
        command.getCurrentCompanyName(),
        command.getStartDate(),
        command.getEndDate(),
        command.getRole(),
        command.getResponsibility()));
  }

  @CommandHandler
  public void updatePersonalInformation(UpdatePersonalInformationCommand command){
    apply(new PersonalInformationUpdatedEvent(command.getApplicationId(),
        command.getFirstName(),
        command.getLastName(),
        command.getBirthDate(),
        command.getAddress(),
        command.getEmail(),
        command.getContactNumber(),
        command.getMobileNumber(),
        command.getAppliedPosition(),
        command.getExpectedSalary(),
        command.getReferencePhoneNumber()));
  }

  @CommandHandler
  public void updateEducation(UpdateEducationCommand command){
    apply(new EducationUpdatedEvent(command.getApplicationId(),
        command.getDegree(),
        command.getUniversity(),
        command.getMajor(),
        command.getGpa()));
  }

  @CommandHandler
  public void updateWorkingExperience(UpdateWorkingExperienceCommand command){
    apply(new WorkingExperienceUpdatedEvent(command.getApplicationId(),
        command.getCurrentCompanyName(),
        command.getStartDate(),
        command.getEndDate(),
        command.getRole(),
        command.getResponsibility()));
  }

  @EventSourcingHandler
  public void on(EmploymentApplicationCreatedEvent event){
    this.id = event.getId();
  }
}

