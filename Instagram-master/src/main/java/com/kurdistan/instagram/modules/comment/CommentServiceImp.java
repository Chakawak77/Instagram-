package com.kurdistan.instagram.modules.comment;

import com.kurdistan.instagram.modules.user.UserApp;
import com.kurdistan.instagram.modules.user.UserService;
import com.kurdistan.instagram.modules.post.Post;
import com.kurdistan.instagram.modules.post.PostService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentServiceImp implements CommentService {


    private final CommentRepository repository;
    private final UserService userService;
    private final PostService postService;

    @Override
    public Comment save(Comment comment) {
     Long userId=comment.getUserApp().getId();
     Long postId=comment.getPost().getId();
        UserApp userApp=userService.findById(userId);
        Post post=postService.findById(postId);
        comment.setUserApp(userApp);
        comment.setPost(post);
        return repository.save(comment);
    }

    @Override
    public Comment update(Comment comment) {

        Comment updateComment=findById(comment.getId());
        updateComment.setContent(comment.getContent());
        Long userId=comment.getUserApp().getId();
        Long postId=comment.getPost().getId();
        Post post=postService.findById(postId);
        UserApp userApp=userService.findById(userId);
        updateComment.setPost(post);
        updateComment.setUserApp(userApp);
        return repository.save(updateComment);
    }

    @Override
    public void delete(Long id) {
     findById(id);
     repository.deleteById(id);
    }

    @Override
    public Comment findById(Long id) {
        Optional<Comment> optionalComment=repository.findById(id);
        if (optionalComment.isEmpty())
            throw new RuntimeException("Not found");
        return optionalComment.get();
    }


    @Override
    public Page<Comment> findAll(Integer page,Integer size) {
        return repository.findAll(PageRequest.of(page,size));
    }

    @Override
    public Page<Comment> findAllByUserApp(Long userAppId, Integer page,Integer size) {
        return repository.findAllByUserApp_Id(userAppId,PageRequest.of(page,size));
    }

    @Override
    public Page<Comment> findAllByPost(Long postId, Integer page,Integer size) {
        return repository.findAllByPost_Id(postId,PageRequest.of(page,size));
    }
}