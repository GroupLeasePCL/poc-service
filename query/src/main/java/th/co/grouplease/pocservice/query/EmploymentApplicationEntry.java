/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/8/18 2:51 PM
 */
package th.co.grouplease.pocservice.query;


import org.springframework.data.annotation.Id;

public class EmploymentApplicationEntry {
  @Id
  private String id;
  private String firstName;
  private String lastName;
  private String email;
  private String address;

  public EmploymentApplicationEntry(){
  }

  public EmploymentApplicationEntry(String id, String firstName, String lastName, String email, String address) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.address = address;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
