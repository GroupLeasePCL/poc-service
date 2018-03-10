/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/10/18 7:11 PM
 */

package th.co.grouplease.pocservice.api;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.time.LocalDate;

public class UpdateWorkingExperienceCommand {
  @TargetAggregateIdentifier
  private String applicationId;
  private String currentCompanyName;
  private LocalDate startDate;
  private LocalDate endDate;
  private String role;
  private String responsibility;

  public static class Builder {
    private String applicationId;
    private String currentCompanyName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String role;
    private String responsibility;

    public Builder(String applicationId){
      this.applicationId = applicationId;
    }

    public Builder currentCompanyName(String currentCompanyName){
      this.currentCompanyName = currentCompanyName;
      return this;
    }

    public Builder startDate(LocalDate startDate){
      this.startDate = startDate;
      return this;
    }

    public Builder endDate(LocalDate endDate){
      this.endDate = endDate;
      return this;
    }

    public Builder role(String role){
      this.role = role;
      return this;
    }

    public Builder responsibility(String responsibility){
      this.responsibility = responsibility;
      return this;
    }

    public UpdateWorkingExperienceCommand build(){
      return new UpdateWorkingExperienceCommand(this);
    }

  }

  private UpdateWorkingExperienceCommand(Builder builder){
    this.applicationId = builder.applicationId;
    this.currentCompanyName = builder.currentCompanyName;
    this.startDate = builder.startDate;
    this.endDate = builder.endDate;
    this.role = builder.role;
    this.responsibility = builder.responsibility;
  }

  public String getApplicationId() {
    return applicationId;
  }

  public String getCurrentCompanyName() {
    return currentCompanyName;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public String getRole() {
    return role;
  }

  public String getResponsibility() {
    return responsibility;
  }
}
