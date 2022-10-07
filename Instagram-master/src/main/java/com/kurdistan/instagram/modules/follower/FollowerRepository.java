package com.kurdistan.instagram.modules.follower;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowerRepository extends PagingAndSortingRepository<Follower,Long> {

    Page<Follower> findAll(Pageable pageable);

    Page<Follower> findAllByUserApp_Id(Long userAppId, Pageable pageable);

}
