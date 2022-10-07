package com.kurdistan.instagram.modules.comment;

import com.kurdistan.instagram.common.PagingDate;
import com.kurdistan.instagram.modules.user.UserApp;
import com.kurdistan.instagram.modules.user.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/comments/")
public class CommentController {

    private final CommentService service;
    private final CommentMapper mapper;

    @PostMapping("/v1/save/")
    public ResponseEntity<CommentDTO> save(@RequestBody CommentDTO commentDTO){
        Comment comment=mapper.toComment(commentDTO);
        service.save(comment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping
    public ResponseEntity<CommentDTO> update(@RequestBody  CommentDTO commentDTO) {
        Comment comment= mapper.toComment(commentDTO);
        CommentDTO updateComment= mapper.toCommentDTO(service.update(comment));
        return ResponseEntity.ok(updateComment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/v1/{id}")
    public ResponseEntity<CommentDTO> findById(@PathVariable Long id){
      Comment comment=service.findById(id);
      CommentDTO commentDTO=mapper.toCommentDTO(comment);
        return ResponseEntity.ok(commentDTO);
    }
    @GetMapping("/paging/{page}/{size}/{postId}/")
    public ResponseEntity<PagingDate<CommentDTO>> getByPost(@PathVariable Integer page, @PathVariable Integer size,@PathVariable Long postId) {
        Page<Comment> commentPage = service.findAllByPost(postId,page,size);
        int totalPage = commentPage.getTotalPages();
        List<Comment> allPost = commentPage.getContent();
        List<CommentDTO> allPostDTO = mapper.toListCommentDTO(allPost);
        PagingDate<CommentDTO> pagingDate = new PagingDate<>(totalPage, page, allPostDTO);
        return ResponseEntity.ok(pagingDate);
    }

    @GetMapping("/paging/{page}/{size}/{userId}/")
    public ResponseEntity<PagingDate<CommentDTO>> getByUserApp(@PathVariable Integer page, @PathVariable Integer size,@PathVariable Long userId) {
        Page<Comment> commentPage = service.findAllByUserApp(userId,page,size);
        int totalPage=commentPage.getTotalPages();
        List<Comment> allPost=commentPage.getContent();
        List<CommentDTO> allPostDTO = mapper.toListCommentDTO(allPost);
        PagingDate<CommentDTO> pagingDate = new PagingDate<>(totalPage, page, allPostDTO);
        return ResponseEntity.ok(pagingDate);
    }

}
