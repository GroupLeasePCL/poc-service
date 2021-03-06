/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/10/18 5:30 PM
 */

package th.co.grouplease.pocservice.query.application;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface EmploymentApplicationRepository extends ReactiveMongoRepository<EmploymentApplicationEntry, String> {
  Flux<EmploymentApplicationEntry> findAllBy(Pageable pageable);
}
