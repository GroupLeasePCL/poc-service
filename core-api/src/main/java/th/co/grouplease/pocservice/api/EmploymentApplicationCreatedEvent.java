/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/8/18 2:48 PM
 */

package th.co.grouplease.pocservice.api;

public class EmploymentApplicationCreatedEvent {
  private String id;

  public EmploymentApplicationCreatedEvent(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
