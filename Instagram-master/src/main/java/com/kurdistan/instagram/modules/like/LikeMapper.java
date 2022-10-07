package com.kurdistan.instagram.modules.like;

import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface LikeMapper {
    Like toLike(LikeDTO likeDTO);
    LikeDTO toLikeDTO(Like like);

    List<Like> toListLike(List<LikeDTO> likeDTOS);
    List<LikeDTO> toListLikeDTO(List<Like> likes);
}
