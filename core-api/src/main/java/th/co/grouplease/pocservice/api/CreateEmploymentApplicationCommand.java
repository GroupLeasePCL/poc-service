/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/8/18 2:47 PM
 */

package th.co.grouplease.pocservice.api;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import javax.money.MonetaryAmount;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A command object to create employment application
 */
public class CreateEmploymentApplicationCommand {
  @TargetAggregateIdentifier
  private String id;
  @NotEmpty
  private String firstName;
  @NotEmpty
  private String lastName;
  @NotNull
  private LocalDate birthDate;

  private String address;
  @NotEmpty
  private String email;
  @NotEmpty
  private String contactNumber;
  private String mobileNumber;

  @NotEmpty
  private String appliedPosition;
  private MonetaryAmount expectedSalary;
  private String referencePhoneNumber;

  private String degree;
  private String university;
  private String major;
  private Float gpa;

  private String currentCompanyName;
  private LocalDate startDate;
  private LocalDate endDate;
  private String role;
  private String responsibility;

  public static class Builder {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String contactNumber;
    private String appliedPosition;
    private String address;
    private String mobileNumber;
    private MonetaryAmount expectedSalary;
    private String referencePhoneNumber;
    private String degree;
    private String university;
    private String major;
    private Float gpa;
    private String currentCompanyName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String role;
    private String responsibility;

    public Builder(String id){
      this.id = id;
    }

    public Builder name(String firstName, String lastName){
      this.firstName = firstName;
      this.lastName = lastName;
      return this;
    }

    public Builder birthDate(LocalDate birthDate){
      this.birthDate = birthDate;
      return this;
    }

    public Builder email(String email){
      this.email = email;
      return this;
    }

    public Builder contactNumber(String contactNumber){
      this.contactNumber = contactNumber;
      return this;
    }

    public Builder appliedPosition(String appliedPosition){
      this.appliedPosition = appliedPosition;
      return this;
    }

    public Builder address(String address){
      this.address = address;
      return this;
    }

    public Builder mobileNumber(String mobileNumber){
      this.mobileNumber = mobileNumber;
      return this;
    }

    public Builder expectedSalary(MonetaryAmount expectedSalary){
      this.expectedSalary = expectedSalary;
      return this;
    }

    public Builder referencePhoneNumber(String referencePhoneNumber){
      this.referencePhoneNumber = referencePhoneNumber;
      return this;
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

    public CreateEmploymentApplicationCommand build(){
      return new CreateEmploymentApplicationCommand(this);
    }
  }

  private CreateEmploymentApplicationCommand(Builder builder){
    this.id = builder.id;
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.birthDate = builder.birthDate;
    this.email = builder.email;
    this.contactNumber = builder.contactNumber;
    this.appliedPosition = builder.appliedPosition;
    this.address = builder.address;
    this.mobileNumber = builder.mobileNumber;
    this.expectedSalary = builder.expectedSalary;
    this.referencePhoneNumber = builder.referencePhoneNumber;
    this.degree = builder.degree;
    this.university = builder.university;
    this.major = builder.major;
    this.gpa = builder.gpa;
    this.currentCompanyName = builder.currentCompanyName;
    this.startDate = builder.startDate;
    this.endDate = builder.endDate;
    this.role = builder.role;
    this.responsibility = builder.responsibility;
  }

  public String getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public String getAddress() {
    return address;
  }

  public String getEmail() {
    return email;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public String getAppliedPosition() {
    return appliedPosition;
  }

  public MonetaryAmount getExpectedSalary() {
    return expectedSalary;
  }

  public String getReferencePhoneNumber() {
    return referencePhoneNumber;
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
