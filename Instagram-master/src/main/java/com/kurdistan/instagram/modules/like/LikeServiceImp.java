package com.kurdistan.instagram.modules.like;

import com.kurdistan.instagram.modules.post.Post;
import com.kurdistan.instagram.modules.post.PostService;
import com.kurdistan.instagram.modules.user.UserApp;
import com.kurdistan.instagram.modules.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LikeServiceImp implements LikeService{

    private final LikeRepository repository;
    private final UserService userservice;
    private final PostService postService;

    @Override
    public Like save(Like like) {
        Long userId=like.getUserApp().getId();
        Long postId=like.getPost().getId();
        UserApp userApp = userservice.findById(userId);
        Post post=postService.findById(postId);
        like.setUserApp(userApp);
        like.setPost(post);
        return repository.save(like);
    }

    @Override
    public Like update(Like like) {
        Like updateLike=findById(like.getId());
        updateLike.setLike(like.getLike());
        Long userId= like.getUserApp().getId();
        Long postId=like.getPost().getId();
        UserApp userApp = userservice.findById(userId);
        Post post=postService.findById(postId);
        updateLike.setUserApp(userApp);
        updateLike.setPost(post);
        return repository.save(updateLike);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public Like findById(Long id) {
        Optional<Like> optionalLike = repository.findById(id);
        if (optionalLike.isEmpty())
            throw new RuntimeException("Not found");
        return optionalLike.get();    }

    @Override
    public Page<Like> findAllLike(Integer page, Integer count) {
        return repository.findAll(PageRequest.of(page,count, Sort.by("id").ascending()));
    }

    @Override
    public Page<Like> findByPost(Integer page, Integer count, Long postId) {
        return repository.findAllByPost_Id(postId, PageRequest.of(page,count,Sort.by("id").ascending()));
    }

    @Override
    public Page<Like> findByUserApp(Integer page, Integer count, Long userAppId) {
        return repository.findAllByUserApp_Id(userAppId,PageRequest.of(page,count, Sort.by("id").ascending()));
    }
}
