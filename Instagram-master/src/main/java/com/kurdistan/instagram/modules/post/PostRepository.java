package com.kurdistan.instagram.modules.post;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post,Long> {

    Page<Post> findAll(Pageable pageable);

    Page<Post> findAllByUserApp_Id(Long userAppId,Pageable pageable);

}
