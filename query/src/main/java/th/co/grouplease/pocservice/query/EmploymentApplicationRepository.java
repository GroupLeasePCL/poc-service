/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/9/18 1:22 PM
 */

package th.co.grouplease.pocservice.query;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

public interface EmploymentApplicationRepository extends ReactiveSortingRepository<EmploymentApplicationEntry, String> {
  Flux<EmploymentApplicationEntry> findAllBy(Pageable pageable);
}
