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
import th.co.grouplease.pocservice.query.EmploymentApplicationEntry;
import th.co.grouplease.pocservice.query.EmploymentApplicationRepository;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

@RestController
public class EmploymentApplicationController {

  private final EmploymentApplicationRepository repository;
  private final CommandGateway commandGateway;

  @Inject
  public EmploymentApplicationController(EmploymentApplicationRepository repository, CommandGateway commandGateway) {
    this.repository = repository;
    this.commandGateway = commandGateway;
  }

  @GetMapping("/applications/{id}")
  public Mono<EmploymentApplicationEntry> findById(@PathVariable String id){
    return repository.findById(id).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
  }

  @GetMapping("/applications")
  public Flux<EmploymentApplicationEntry> findAll(@NotNull @RequestParam("page") int page, @NotNull @RequestParam int pageSize){
    return repository.findAllBy(PageRequest.of(page, pageSize));
  }

  @PostMapping("/applications")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Void> create(@RequestBody CreateEmploymentApplicationCommand command){
    commandGateway.send(command);
    return Mono.empty();
  }
}
