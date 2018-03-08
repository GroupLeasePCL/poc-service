/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/8/18 2:51 PM
 */

package th.co.grouplease.pocservice.query;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EmploymentApplicationRepository extends ReactiveMongoRepository<EmploymentApplicationEntry, String> {
}
