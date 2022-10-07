package com.kurdistan.instagram.modules.like;

import com.kurdistan.instagram.common.PagingDate;
import com.kurdistan.instagram.modules.following.Following;
import com.kurdistan.instagram.modules.following.FollowingDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/likes/")
public class LikeController {

    private final LikeService service;
    private final LikeMapper mapper;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody LikeDTO likeDTO) {
        Like like=mapper.toLike(likeDTO);
        service.save(like);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping
    public ResponseEntity<LikeDTO> update(@RequestBody LikeDTO likeDTO) {
        Like like= mapper.toLike(likeDTO);
        LikeDTO updateLike= mapper.toLikeDTO(service.update(like));
        return ResponseEntity.ok(updateLike);
    }
    @GetMapping("/v1/{id}")
    public ResponseEntity<LikeDTO> getById(@PathVariable Long id){
        Like like=service.findById(id);
        LikeDTO likeDTO=mapper.toLikeDTO(like);
        return ResponseEntity.ok(likeDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/paging/{page}/{count}")
    public ResponseEntity<PagingDate<LikeDTO>> getAll(@PathVariable Integer page, @PathVariable Integer count) {
        Page<Like> likePage = service.findAllLike(page, count);
        int totalPage = likePage.getTotalPages();
        List<LikeDTO> allLike= mapper.toListLikeDTO(likePage.getContent());
        PagingDate<LikeDTO> pagingDate = new PagingDate<>(totalPage, page, allLike);
        return ResponseEntity.ok(pagingDate);
    }
    @GetMapping("/paging/{page}/{count}/{userId}")
    public ResponseEntity<PagingDate<LikeDTO>> getByUser(@PathVariable Long userId,@PathVariable Integer page, @PathVariable Integer count) {
        Page<Like> likePage = service.findByUserApp(page,count,userId);
        int totalPage = likePage.getTotalPages();
        List<LikeDTO> allLike= mapper.toListLikeDTO(likePage.getContent());
        PagingDate<LikeDTO> pagingDate = new PagingDate<>(totalPage, page, allLike);
        return ResponseEntity.ok(pagingDate);
    }
    @GetMapping("/paging/{page}/{count}/{postId}")
    public ResponseEntity<PagingDate<LikeDTO>> getByPost(@PathVariable Long postId,@PathVariable Integer page, @PathVariable Integer count) {
        Page<Like> likePage = service.findByPost(page,count,postId);
        int totalPage = likePage.getTotalPages();
        List<LikeDTO> allLike= mapper.toListLikeDTO(likePage.getContent());
        PagingDate<LikeDTO> pagingDate = new PagingDate<>(totalPage, page, allLike);
        return ResponseEntity.ok(pagingDate);
    }
}
