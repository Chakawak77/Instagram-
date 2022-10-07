package com.kurdistan.instagram.modules.follower;

import org.springframework.data.domain.Page;

public interface FollowerService {

    Follower save(Follower follower);
    Follower update(Follower follower);
    void delete(Long id);
    Follower findById(Long id);

    Page<Follower> findAllFollower(Integer page, Integer count);
    Page<Follower> findAllByUserApp_Id(Long userAppId, Integer page, Integer count);
}
