package com.kurdistan.instagram.modules.post;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PostServiceImp implements PostService {

    private final PostRepository repository;

    @Override
    public Post save(Post post) {
        return repository.save(post);
    }

    @Override
    public Post update(Post post) {
        Post updatePost = findById(post.getId());
        updatePost.setLocation(post.getLocation());
        updatePost.setImagePost(post.getImagePost());
        updatePost.setDescription(post.getDescription());
        return repository.save(updatePost);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public Post findById(Long id) {
        Optional<Post> postOptional = repository.findById(id);
        if (postOptional.isEmpty())
            throw new RuntimeException("Not found");
        return postOptional.get();
    }

    @Override
    public Page<Post> findAllPost(Integer page, Integer count) {
        return repository.findAll(PageRequest.of(page, count));
    }

    @Override
    public Page<Post> findAllByUserApp_Id(Long userAppId, Integer page, Integer count) {
        return repository.findAllByUserApp_Id(userAppId, PageRequest.of(page, count, Sort.by("id").ascending()));
    }
}
