package com.kurdistan.instagram.modules.following;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowingRepository extends PagingAndSortingRepository<Following,Long> {

    Page<Following> findAll(Pageable pageable);

    Page<Following> findAllByUserApp_Id(Long userAppId, Pageable pageable);

}
