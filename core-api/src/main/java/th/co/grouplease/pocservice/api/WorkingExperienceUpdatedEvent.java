/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/10/18 7:12 PM
 */

package th.co.grouplease.pocservice.api;

import java.time.LocalDate;

public class WorkingExperienceUpdatedEvent {
  private String applicationId;
  private String currentCompanyName;
  private LocalDate startDate;
  private LocalDate endDate;
  private String role;
  private String responsibility;

  public WorkingExperienceUpdatedEvent(String applicationId, String currentCompanyName, LocalDate startDate, LocalDate endDate, String role, String responsibility) {
    this.applicationId = applicationId;
    this.currentCompanyName = currentCompanyName;
    this.startDate = startDate;
    this.endDate = endDate;
    this.role = role;
    this.responsibility = responsibility;
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
