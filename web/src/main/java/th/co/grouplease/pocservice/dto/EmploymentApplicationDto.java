/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/10/18 4:01 PM
 */

package th.co.grouplease.pocservice.dto;

import javax.money.MonetaryAmount;
import java.time.LocalDate;

public class EmploymentApplicationDto {
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

  public String getAppliedPosition() {
    return appliedPosition;
  }

  public void setAppliedPosition(String appliedPosition) {
    this.appliedPosition = appliedPosition;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
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

  public String getCurrentCompanyName() {
    return currentCompanyName;
  }

  public void setCurrentCompanyName(String currentCompanyName) {
    this.currentCompanyName = currentCompanyName;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getResponsibility() {
    return responsibility;
  }

  public void setResponsibility(String responsibility) {
    this.responsibility = responsibility;
  }
}
