/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/9/18 8:55 AM
 */

package th.co.grouplease.pocservice.controller;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import th.co.grouplease.pocservice.api.CreateEmploymentApplicationCommand;
import th.co.grouplease.pocservice.api.UpdateEducationCommand;
import th.co.grouplease.pocservice.api.UpdatePersonalInformationCommand;
import th.co.grouplease.pocservice.api.UpdateWorkingExperienceCommand;
import th.co.grouplease.pocservice.dto.ApplicantEducationDto;
import th.co.grouplease.pocservice.dto.ApplicantPersonalInformationDto;
import th.co.grouplease.pocservice.dto.ApplicantWorkingExperienceDto;
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
  private static final ExampleMatcher employmentApplicationMatcher = ExampleMatcher.matching()
      .withMatcher("firstName", match -> match.contains().ignoreCase())
      .withMatcher("lastName", match ->match.contains().ignoreCase())
      .withMatcher("email", match->match.contains().ignoreCase());

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
  public Flux<EmploymentApplicationEntry> findAll(@NotNull @RequestParam("page") Integer page, @NotNull @RequestParam Integer pageSize,
                                                  @Nullable @RequestParam String firstName, @Nullable @RequestParam String lastName, @Nullable @RequestParam String email){
    EmploymentApplicationEntry probe = new EmploymentApplicationEntry();
    probe.setFirstName(firstName);
    probe.setLastName(lastName);
    probe.setEmail(email);

    if(StringUtils.isEmpty(firstName) && StringUtils.isEmpty(lastName) && StringUtils.isEmpty(email)) {
      return employmentApplicationRepository.findAllBy(PageRequest.of(page, pageSize));
    } else {
      // TODO: This is not good for performance as we asked to fetch from the beginning of the collection and skip
      // TODO: The better one is to have the support from Repository to build the query with Pageable
      return employmentApplicationRepository.findAll(Example.of(probe, employmentApplicationMatcher)).skip(page * pageSize).limitRequest(pageSize);
    }
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

  @PutMapping("/{id}/personal-info")
  public Mono<Void> updatePersonalInformation(@PathVariable String id, @RequestBody ApplicantPersonalInformationDto applicantPersonalInformationDto){
    UpdatePersonalInformationCommand command = new UpdatePersonalInformationCommand.Builder(id)
        .firstName(applicantPersonalInformationDto.getFirstName())
        .lastName(applicantPersonalInformationDto.getLastName())
        .birthDate(applicantPersonalInformationDto.getBirthDate())
        .address(applicantPersonalInformationDto.getAddress())
        .email(applicantPersonalInformationDto.getEmail())
        .contactNumber(applicantPersonalInformationDto.getContactNumber())
        .mobileNumber(applicantPersonalInformationDto.getMobileNumber())
        .appliedPosition(applicantPersonalInformationDto.getAppliedPosition())
        .expectedSalary(applicantPersonalInformationDto.getExpectedSalary())
        .referencePhoneNumber(applicantPersonalInformationDto.getReferencePhoneNumber())
        .build();
    return Mono.fromFuture(commandGateway.send(command)).then();
  }

  @GetMapping("/{id}/education")
  public Mono<ApplicantEducationEntry> findEducationById(@PathVariable String id){
    return applicantEducationRepository.findById(id).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
  }

  @PutMapping("/{id}/education")
  public Mono<Void> updateEducation(@PathVariable String id, @RequestBody ApplicantEducationDto applicantEducationDto){
    UpdateEducationCommand command = new UpdateEducationCommand.Builder(id)
        .degree(applicantEducationDto.getDegree())
        .university(applicantEducationDto.getUniversity())
        .major(applicantEducationDto.getMajor())
        .gpa(applicantEducationDto.getGpa())
        .build();
    return Mono.fromFuture(commandGateway.send(command)).then();
  }

  @GetMapping("/{id}/working-experience")
  public Mono<ApplicantWorkingExperienceEntry> findWorkingExperienceById(@PathVariable String id){
    return applicantWorkingExperienceRepository.findById(id).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
  }

  @PutMapping("{id}/working-experience")
  public Mono<Void> updateWorkingExperience(@PathVariable String id, @RequestBody ApplicantWorkingExperienceDto applicantWorkingExperienceDto){
    UpdateWorkingExperienceCommand command = new UpdateWorkingExperienceCommand.Builder(id)
        .currentCompanyName(applicantWorkingExperienceDto.getCompany())
        .startDate(applicantWorkingExperienceDto.getStartDate())
        .endDate(applicantWorkingExperienceDto.getEndDate())
        .role(applicantWorkingExperienceDto.getRole())
        .responsibility(applicantWorkingExperienceDto.getResponsibility())
        .build();
    return Mono.fromFuture(commandGateway.send(command)).then();
  }
}
