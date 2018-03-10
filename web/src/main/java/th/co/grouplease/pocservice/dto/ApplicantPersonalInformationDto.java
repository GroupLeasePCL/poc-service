/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/10/18 10:03 PM
 */

package th.co.grouplease.pocservice.dto;

import javax.money.MonetaryAmount;
import java.time.LocalDate;

public class ApplicantPersonalInformationDto {
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

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getAppliedPosition() {
    return appliedPosition;
  }

  public void setAppliedPosition(String appliedPosition) {
    this.appliedPosition = appliedPosition;
  }

  public MonetaryAmount getExpectedSalary() {
    return expectedSalary;
  }

  public void setExpectedSalary(MonetaryAmount expectedSalary) {
    this.expectedSalary = expectedSalary;
  }

  public String getReferencePhoneNumber() {
    return referencePhoneNumber;
  }

  public void setReferencePhoneNumber(String referencePhoneNumber) {
    this.referencePhoneNumber = referencePhoneNumber;
  }
}
