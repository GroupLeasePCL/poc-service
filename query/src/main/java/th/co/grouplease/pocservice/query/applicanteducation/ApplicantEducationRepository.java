/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/10/18 6:12 PM
 */

package th.co.grouplease.pocservice.query.applicanteducation;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;

public interface ApplicantEducationRepository extends ReactiveSortingRepository<ApplicantEducationEntry, String>{
}
