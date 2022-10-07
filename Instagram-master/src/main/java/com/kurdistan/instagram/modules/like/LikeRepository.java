package com.kurdistan.instagram.modules.like;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends PagingAndSortingRepository<Like,Long> {

    Page<Like> findAll(Pageable pageable);
    Page<Like> findAllByPost_Id(Long postId, Pageable pageable);

    Page<Like> findAllByUserApp_Id(Long userAppId, Pageable pageable);

}
