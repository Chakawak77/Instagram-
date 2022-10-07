package com.kurdistan.instagram.modules.following;

import com.kurdistan.instagram.modules.follower.Follower;
import org.springframework.data.domain.Page;

public interface FollowingService {

    Following save(Following following);
    Following update(Following following);
    void delete(Long id);
    Following findById(Long id);

    Page<Following> findAllFollowing(Integer page, Integer count);
    Page<Following> findAllByUserApp_Id(Long userAppId, Integer page, Integer count);
}
