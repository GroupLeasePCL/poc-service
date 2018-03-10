/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/9/18 8:55 AM
 */

package th.co.grouplease.pocservice.controller;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import th.co.grouplease.pocservice.api.CreateEmploymentApplicationCommand;
import th.co.grouplease.pocservice.dto.EmploymentApplicationDto;
import th.co.grouplease.pocservice.query.applicanteducation.ApplicantEducationEntry;
import th.co.grouplease.pocservice.query.applicanteducation.ApplicantEducationRepository;
import th.co.grouplease.pocservice.query.applicantpersonalinfo.ApplicantPersonalInformationEntry;
import th.co.grouplease.pocservice.query.applicantpersonalinfo.ApplicantPersonalInformationRepository;
import th.co.grouplease.pocservice.query.applicantworkingexperience.ApplicantWorkingExperienceEntry;
import th.co.grouplease.pocservice.query.applicantworkingexperience.ApplicantWorkingExperienceRepository;
import th.co.grouplease.pocservice.query.application.EmploymentApplicationEntry;
import th.co.grouplease.pocservice.query.application.EmploymentApplicationRepository;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequestMapping(path = "/employment-applications")
public class EmploymentApplicationController {
  private final CommandGateway commandGateway;
  private final EmploymentApplicationRepository employmentApplicationRepository;
  private final ApplicantPersonalInformationRepository applicantPersonalInformationRepository;
  private final ApplicantEducationRepository applicantEducationRepository;
  private final ApplicantWorkingExperienceRepository applicantWorkingExperienceRepository;

  @Inject
  public EmploymentApplicationController(EmploymentApplicationRepository employmentApplicationRepository,
                                         ApplicantPersonalInformationRepository applicantPersonalInformationRepository,
                                         ApplicantEducationRepository applicantEducationRepository,
                                         ApplicantWorkingExperienceRepository applicantWorkingExperienceRepository,
                                         CommandGateway commandGateway) {
    this.employmentApplicationRepository = employmentApplicationRepository;
    this.applicantPersonalInformationRepository = applicantPersonalInformationRepository;
    this.applicantEducationRepository = applicantEducationRepository;
    this.applicantWorkingExperienceRepository = applicantWorkingExperienceRepository;
    this.commandGateway = commandGateway;
  }

  @GetMapping("/{id}")
  public Mono<EmploymentApplicationEntry> findById(@PathVariable String id){
    return employmentApplicationRepository.findById(id).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
  }

  @GetMapping
  public Flux<EmploymentApplicationEntry> findAll(@NotNull @RequestParam("page") int page, @NotNull @RequestParam int pageSize){
    return employmentApplicationRepository.findAllBy(PageRequest.of(page, pageSize));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Void> create(@RequestBody EmploymentApplicationDto employmentApplicationDto){
    CreateEmploymentApplicationCommand command = new CreateEmploymentApplicationCommand.Builder(UUID.randomUUID().toString())
        .name(employmentApplicationDto.getFirstName(), employmentApplicationDto.getLastName())
        .birthDate(employmentApplicationDto.getBirthDate())
        .email(employmentApplicationDto.getEmail())
        .contactNumber(employmentApplicationDto.getContactNumber())
        .appliedPosition(employmentApplicationDto.getAppliedPosition())
        .address(employmentApplicationDto.getAddress())
        .mobileNumber(employmentApplicationDto.getMobileNumber())
        .expectedSalary(employmentApplicationDto.getExpectedSalary())
        .referencePhoneNumber(employmentApplicationDto.getReferencePhoneNumber())
        .degree(employmentApplicationDto.getDegree())
        .university(employmentApplicationDto.getUniversity())
        .major(employmentApplicationDto.getMajor())
        .gpa(employmentApplicationDto.getGpa())
        .currentCompanyName(employmentApplicationDto.getCurrentCompanyName())
        .startDate(employmentApplicationDto.getStartDate())
        .endDate(employmentApplicationDto.getEndDate())
        .role(employmentApplicationDto.getRole())
        .responsibility(employmentApplicationDto.getResponsibility())
        .build();

    return Mono.fromFuture(commandGateway.send(command)).then();
  }

  @GetMapping("/{id}/personal-info")
  public Mono<ApplicantPersonalInformationEntry> findPersonalInformationById(@PathVariable String id){
    return applicantPersonalInformationRepository.findById(id).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
  }

  @GetMapping("/{id}/education")
  public Mono<ApplicantEducationEntry> findEducationById(@PathVariable String id){
    return applicantEducationRepository.findById(id).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
  }

  @GetMapping("/{id}/working-experience")
  public Mono<ApplicantWorkingExperienceEntry> findWorkingExperienceById(@PathVariable String id){
    return applicantWorkingExperienceRepository.findById(id).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
  }
}
