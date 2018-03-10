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
import th.co.grouplease.pocservice.query.EmploymentApplicationEntry;
import th.co.grouplease.pocservice.query.EmploymentApplicationRepository;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequestMapping(path = "/employment-applications")
public class EmploymentApplicationController {

  private final EmploymentApplicationRepository repository;
  private final CommandGateway commandGateway;

  @Inject
  public EmploymentApplicationController(EmploymentApplicationRepository repository, CommandGateway commandGateway) {
    this.repository = repository;
    this.commandGateway = commandGateway;
  }

  @GetMapping("/{id}")
  public Mono<EmploymentApplicationEntry> findById(@PathVariable String id){
    return repository.findById(id).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
  }

  @GetMapping
  public Flux<EmploymentApplicationEntry> findAll(@NotNull @RequestParam("page") int page, @NotNull @RequestParam int pageSize){
    return repository.findAllBy(PageRequest.of(page, pageSize));
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
}
