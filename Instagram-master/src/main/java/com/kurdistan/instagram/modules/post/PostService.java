package com.kurdistan.instagram.modules.post;

import org.springframework.data.domain.Page;

public interface PostService {

    Post save(Post post);
    Post update(Post post);
    void delete(Long id);
    Post findById(Long id);
    Page<Post>  findAllPost(Integer page, Integer count);
    Page<Post> findAllByUserApp_Id(Long userAppId, Integer page, Integer count);
}

