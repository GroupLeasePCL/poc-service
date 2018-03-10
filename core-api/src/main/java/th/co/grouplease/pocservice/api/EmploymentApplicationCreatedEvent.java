/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/8/18 2:48 PM
 */

package th.co.grouplease.pocservice.api;

import javax.money.MonetaryAmount;
import java.time.LocalDate;

public class EmploymentApplicationCreatedEvent {
  // Required
  private String id;
  private String firstName;
  private String lastName;
  private LocalDate birthDate;
  private String email;
  private String contactNumber;
  private String appliedPosition;

  // Optional
  private String address;
  private String mobileNumber;
  private MonetaryAmount expectedSalary;
  private String referencePhoneNumber;
  private String degree;
  private String university;
  private String major;
  private float gpa;
  private String currentCompanyName;
  private LocalDate startDate;
  private LocalDate endDate;
  private String role;
  private String responsibility;

  public EmploymentApplicationCreatedEvent(String id, String firstName, String lastName, LocalDate birthDate, String email, String contactNumber, String appliedPosition, String address, String mobileNumber, MonetaryAmount expectedSalary, String referencePhoneNumber, String degree, String university, String major, float gpa, String currentCompanyName, LocalDate startDate, LocalDate endDate, String role, String responsibility) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.email = email;
    this.contactNumber = contactNumber;
    this.appliedPosition = appliedPosition;
    this.address = address;
    this.mobileNumber = mobileNumber;
    this.expectedSalary = expectedSalary;
    this.referencePhoneNumber = referencePhoneNumber;
    this.degree = degree;
    this.university = university;
    this.major = major;
    this.gpa = gpa;
    this.currentCompanyName = currentCompanyName;
    this.startDate = startDate;
    this.endDate = endDate;
    this.role = role;
    this.responsibility = responsibility;
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

  public String getEmail() {
    return email;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public String getAppliedPosition() {
    return appliedPosition;
  }

  public String getAddress() {
    return address;
  }

  public String getMobileNumber() {
    return mobileNumber;
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

  public float getGpa() {
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
