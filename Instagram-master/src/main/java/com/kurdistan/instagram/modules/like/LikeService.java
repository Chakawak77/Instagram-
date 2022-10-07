package com.kurdistan.instagram.modules.like;

import org.springframework.data.domain.Page;

public interface LikeService {

    Like save(Like like);
    Like update(Like like);
    void delete(Long id);
    Like findById(Long id);

    Page<Like> findAllLike(Integer page, Integer count);
    Page<Like> findByPost(Integer page, Integer count,Long postId);
    Page<Like> findByUserApp(Integer page, Integer count,Long userAppId);
}
