/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/10/18 7:11 PM
 */

package th.co.grouplease.pocservice.api;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import javax.money.MonetaryAmount;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class UpdatePersonalInformationCommand {
  @TargetAggregateIdentifier
  private String applicationId;
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

  public static class Builder {
    private String applicationId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String address;
    private String email;
    private String contactNumber;
    private String mobileNumber;
    private String appliedPosition;
    private MonetaryAmount expectedSalary;
    private String referencePhoneNumber;

    public Builder(String applicationId){
      this.applicationId = applicationId;
    }

    public Builder firstName(String firstName){
      this.firstName = firstName;
      return this;
    }

    public Builder lastName(String lastName){
      this.lastName = lastName;
      return this;
    }

    public Builder birthDate(LocalDate birthDate){
      this.birthDate = birthDate;
      return this;
    }

    public Builder address(String address){
      this.address = address;
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

    public Builder mobileNumber(String mobileNumber){
      this.mobileNumber = mobileNumber;
      return this;
    }

    public Builder appliedPosition(String appliedPosition){
      this.appliedPosition = appliedPosition;
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

    public UpdatePersonalInformationCommand build(){
      return new UpdatePersonalInformationCommand(this);
    }
  }

  private UpdatePersonalInformationCommand(Builder builder){
    this.applicationId = builder.applicationId;
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.birthDate = builder.birthDate;
    this.address = builder.address;
    this.email = builder.email;
    this.contactNumber = builder.contactNumber;
    this.mobileNumber = builder.mobileNumber;
    this.appliedPosition = builder.appliedPosition;
    this.expectedSalary = builder.expectedSalary;
    this.referencePhoneNumber = builder.referencePhoneNumber;
  }

  public String getApplicationId() {
    return applicationId;
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
}
