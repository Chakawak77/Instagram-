package com.kurdistan.instagram.modules.follower;



import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface FollowerMapper {

    Follower toFollower(FollowerDTO followerDTO);
    FollowerDTO toFollowerDTO(Follower follower);

    List<Follower> toListFollower(List<FollowerDTO> followerDTOS);
    List<FollowerDTO> toListFollowerDTO(List<Follower> followers);
}
