/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/10/18 7:12 PM
 */

package th.co.grouplease.pocservice.api;

import javax.money.MonetaryAmount;
import java.time.LocalDate;

public class PersonalInformationUpdatedEvent {
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

  public PersonalInformationUpdatedEvent(String applicationId, String firstName, String lastName, LocalDate birthDate, String address, String email, String contactNumber, String mobileNumber, String appliedPosition, MonetaryAmount expectedSalary, String referencePhoneNumber) {
    this.applicationId = applicationId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.address = address;
    this.email = email;
    this.contactNumber = contactNumber;
    this.mobileNumber = mobileNumber;
    this.appliedPosition = appliedPosition;
    this.expectedSalary = expectedSalary;
    this.referencePhoneNumber = referencePhoneNumber;
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
