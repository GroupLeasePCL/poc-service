/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/9/18 8:55 AM
 */

package th.co.grouplease.pocservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmploymentApplicationController {

  @GetMapping("/hello")
  public String handle(){
    return "Hello WebFlux";
  }
}
