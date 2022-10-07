package com.kurdistan.instagram.modules.following;

import com.kurdistan.instagram.modules.follower.FollowerDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FollowingMapper {

    Following toFollowing(FollowingDTO followingDTO);
    FollowingDTO toFollowingDTO(Following following);

    List<Following> toListFollowing(List<FollowingDTO> followingDTOS);
    List<FollowingDTO> toListFollowingDTO(List<Following> followings);
}
