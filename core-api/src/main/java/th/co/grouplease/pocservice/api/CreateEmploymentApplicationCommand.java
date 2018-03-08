/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/8/18 2:47 PM
 */

package th.co.grouplease.pocservice.api;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class CreateEmploymentApplicationCommand {
  @TargetAggregateIdentifier
  private String id;

  public CreateEmploymentApplicationCommand(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
