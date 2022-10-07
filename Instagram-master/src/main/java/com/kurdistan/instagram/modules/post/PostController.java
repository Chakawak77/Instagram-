package com.kurdistan.instagram.modules.post;


import com.kurdistan.instagram.common.PagingDate;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/posts/")
public class PostController {

    private final PostService service;
    private final PostMapper mapper;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody PostDTO postDTO) {
        Post post = mapper.toPost(postDTO);
        service.save(post);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<PostDTO> update(@RequestBody PostDTO postDTO) {
        Post post = mapper.toPost(postDTO);
        PostDTO updatePost = mapper.toPostDTO(service.update(post));
        return ResponseEntity.ok(updatePost);
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<PostDTO> getById(@PathVariable Long id){
        Post post=service.findById(id);
        PostDTO postDTO=mapper.toPostDTO(post);
        return ResponseEntity.ok(postDTO);
    }

    @GetMapping("/paging/{page}/{count}")
    public ResponseEntity<PagingDate<PostDTO>> pagination(@PathVariable Integer page, @PathVariable Integer count) {
        Page<Post> postPage = service.findAllPost(page, count);
        int totalPage = postPage.getTotalPages();
        List<PostDTO> allUser = mapper.toListPostDTO(postPage.getContent());
        PagingDate<PostDTO> pagingDate = new PagingDate<>(totalPage, page, allUser);
        return ResponseEntity.ok(pagingDate);
    }
}