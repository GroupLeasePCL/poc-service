/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/10/18 7:11 PM
 */

package th.co.grouplease.pocservice.api;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class UpdateEducationCommand {
  @TargetAggregateIdentifier
  private String applicationId;
  private String degree;
  private String university;
  private String major;
  private Float gpa;

  public static class Builder {
    private String applicationId;
    private String degree;
    private String university;
    private String major;
    private Float gpa;

    public Builder(String applicationId){
      this.applicationId = applicationId;
    }

    public Builder degree(String degree){
      this.degree = degree;
      return this;
    }

    public Builder university(String university){
      this.university = university;
      return this;
    }

    public Builder major(String major){
      this.major = major;
      return this;
    }

    public Builder gpa(Float gpa){
      this.gpa = gpa;
      return this;
    }

    public UpdateEducationCommand build(){
      return new UpdateEducationCommand(this);
    }
  }

  private UpdateEducationCommand(Builder builder){
    this.applicationId = builder.applicationId;
    this.degree = builder.degree;
    this.university = builder.university;
    this.major = builder.major;
    this.gpa = builder.gpa;
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
