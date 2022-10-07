package com.kurdistan.instagram.modules.following;

import com.kurdistan.instagram.common.PagingDate;
import com.kurdistan.instagram.modules.follower.Follower;
import com.kurdistan.instagram.modules.follower.FollowerDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/followings/")
public class FollowingController {

    private final FollowingService service;
    private final FollowingMapper mapper;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody FollowingDTO followingDTO) {
       Following following=mapper.toFollowing(followingDTO);
        service.save(following);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping
    public ResponseEntity<FollowingDTO> update(@RequestBody FollowingDTO followingDTO) {
        Following following= mapper.toFollowing(followingDTO);
       FollowingDTO updateFollowing= mapper.toFollowingDTO(service.update(following));
        return ResponseEntity.ok(updateFollowing);
    }
    @GetMapping("/v1/{id}")
    public ResponseEntity<FollowingDTO> getById(@PathVariable Long id){
       Following following=service.findById(id);
       FollowingDTO followingDTO=mapper.toFollowingDTO(following);
        return ResponseEntity.ok(followingDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/paging/{page}/{count}")
    public ResponseEntity<PagingDate<FollowingDTO>> getAll(@PathVariable Integer page, @PathVariable Integer count) {
        Page<Following> followingPage = service.findAllFollowing(page, count);
        int totalPage = followingPage.getTotalPages();
        List<FollowingDTO> allFollowing = mapper.toListFollowingDTO(followingPage.getContent());
        PagingDate<FollowingDTO> pagingDate = new PagingDate<>(totalPage, page, allFollowing);
        return ResponseEntity.ok(pagingDate);
    }
    @GetMapping("/paging/{page}/{count}/{userId}")
    public ResponseEntity<PagingDate<FollowingDTO>> getByUser(@PathVariable Long userId,@PathVariable Integer page, @PathVariable Integer count) {
        Page<Following> followingPage = service.findAllByUserApp_Id(userId,page,count);
        int totalPage = followingPage.getTotalPages();
        List<FollowingDTO> allFollowing = mapper.toListFollowingDTO(followingPage.getContent());
        PagingDate<FollowingDTO> pagingDate = new PagingDate<>(totalPage, page, allFollowing);
        return ResponseEntity.ok(pagingDate);
    }
}
