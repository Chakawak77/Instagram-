package com.kurdistan.instagram.modules.comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {

    Comment save(Comment comment);

    Comment update(Comment comment);

    void delete(Long id);

    Comment findById(Long id);

    Page<Comment>  findAll(Integer page,Integer size);

    Page<Comment> findAllByUserApp(Long userAppId,Integer page,Integer size);

    Page<Comment> findAllByPost(Long postId,Integer page,Integer size);



}
