/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/10/18 7:12 PM
 */

package th.co.grouplease.pocservice.api;

public class EducationUpdatedEvent {
  private String applicationId;
  private String degree;
  private String university;
  private String major;
  private Float gpa;

  public EducationUpdatedEvent(String applicationId, String degree, String university, String major, Float gpa) {
    this.applicationId = applicationId;
    this.degree = degree;
    this.university = university;
    this.major = major;
    this.gpa = gpa;
  }

  public String getApplicationId() {
    return applicationId;
  }

  public String getDegree() {
    return degree;
  }

  public String getUniversity() {
    return university;
  }

  public String getMajor() {
    return major;
  }

  public Float getGpa() {
    return gpa;
  }
}
