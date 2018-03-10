/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/10/18 5:29 PM
 */

package th.co.grouplease.pocservice.query.applicanteducation;

import org.springframework.data.annotation.Id;

public class ApplicantEducationEntry {
  @Id
  private String applicationId;
  private String degree;
  private String university;
  private String major;
  private Float gpa;

  public String getApplicationId() {
    return applicationId;
  }

  public void setApplicationId(String applicationId) {
    this.applicationId = applicationId;
  }

  public String getDegree() {
    return degree;
  }

  public void setDegree(String degree) {
    this.degree = degree;
  }

  public String getUniversity() {
    return university;
  }

  public void setUniversity(String university) {
    this.university = university;
  }

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  public Float getGpa() {
    return gpa;
  }

  public void setGpa(Float gpa) {
    this.gpa = gpa;
  }
}
