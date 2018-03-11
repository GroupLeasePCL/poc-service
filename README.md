# poc-service
### Introduction
This repository features a small microservice implementation that aims for non-blocking behaviour using Spring WebFlux.
It has a single rest controller that exposes the APIs.

Behind RESTful interface, we utilize CQRS architectural pattern which is powered by Axon framework, following DDD principle.

The structure of the project is inspired by AxonBank repository (https://github.com/AxonFramework/AxonBank). 
There're mainly 4 modules: 
1. core : Aggregate following DDD principle
2. core-api  : Command and Event
3. query : Read models
4. web : RestController, Dto, and Configurations

In the infrastructure side of Axon, we're using Mongodb version of the eventstore.
Though it's possible to use others NoSQL database, Mongodb is supported out of the box.

In the query side, we're also using Mongodb rather than JPA as we aim for non-blocking when dealing with read models.

ThreadPoolTaskExecutor is configured to enable asynchronous event processing in all of EventHandler with Sequence per aggregate strategy.
As a result, a call to send a command through CommandGateway won't be blocked by event processing.

It should be noted that Cors is configured to enable for all path which is not recommended for the security reason.

### REST API
There is only one resource with "/employment-applications" as a root path. There're 9 APIs as following:
1. GET /employment-applications/{id} <br /> 
Returns a single EmploymentApplicationEntry. 
2. GET /employment-applications/ <br /> 
Returns zero or more EmploymentApplicationEntry. This API requires page and pageSize where filtering can be done with firstName, lastName, and email query parameters.
3. POST /employment-applications/ with EmploymentApplicationDto as a payload <br /> 
Creates an employment application.
4. GET /employment-applications/{id}/personal-info/ <br /> 
Returns a single ApplicantPersonalInformationEntry
5. PUT /employment-applications/{id}/personal-info/ with ApplicantPersonalInformationDto as a payload <br /> 
Updates personal information
6. GET /employment-applications/{id}/education/ <br /> Returns a single ApplicantEducationEntry
7. PUT /employment-applications/{id}/education/ with ApplicantEducationDto as a payload <br />
Updates education information
8. GET /employment-applications/{id}/working-experience/ <br /> 
Returns a single ApplicantWorkingExperienceEntry
9. PUT /employment-applications/{id}/working-experience/ <br /> 
Updates working experience