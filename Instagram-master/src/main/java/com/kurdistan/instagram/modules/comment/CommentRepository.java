package com.kurdistan.instagram.modules.comment;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment,Long> {

    Page<Comment> findAll(Pageable pageable);

    Page<Comment> findAllByUserApp_Id(Long userAppId,Pageable pageable);

    Page<Comment> findAllByPost_Id(Long postId,Pageable pageable);

}
