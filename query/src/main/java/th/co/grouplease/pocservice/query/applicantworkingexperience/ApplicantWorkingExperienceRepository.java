/*
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) 3/10/18 6:17 PM
 */

package th.co.grouplease.pocservice.query.applicantworkingexperience;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ApplicantWorkingExperienceRepository extends ReactiveMongoRepository<ApplicantWorkingExperienceEntry, String> {
}
