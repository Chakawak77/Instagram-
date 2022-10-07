package com.kurdistan.instagram.modules.follower;

import com.kurdistan.instagram.common.PagingDate;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/followers")
public class FollowerController {

    private final FollowerService service;
    private final FollowerMapper mapper;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody FollowerDTO followerDTO) {
        Follower follower=mapper.toFollower(followerDTO);
        service.save(follower);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<FollowerDTO> update(@RequestBody FollowerDTO followerDTO) {
        Follower follower= mapper.toFollower(followerDTO);
        FollowerDTO updateFollower= mapper.toFollowerDTO(service.update(follower));
        return ResponseEntity.ok(updateFollower);
    }
    @GetMapping("/v1/{id}")
    public ResponseEntity<FollowerDTO> getById(@PathVariable Long id){
        Follower follower=service.findById(id);
        FollowerDTO followerDTO=mapper.toFollowerDTO(follower);
        return ResponseEntity.ok(followerDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/paging/{page}/{count}")
    public ResponseEntity<PagingDate<FollowerDTO>> getAll(@PathVariable Integer page, @PathVariable Integer count) {
        Page<Follower> followerPage = service.findAllFollower(page, count);
        int totalPage = followerPage.getTotalPages();
        List<FollowerDTO> allFollower = mapper.toListFollowerDTO(followerPage.getContent());
        PagingDate<FollowerDTO> pagingDate = new PagingDate<>(totalPage, page, allFollower);
        return ResponseEntity.ok(pagingDate);
    }
    @GetMapping("/paging/{page}/{count}/{userId}")
    public ResponseEntity<PagingDate<FollowerDTO>> getByUser(@PathVariable Long userId,@PathVariable Integer page, @PathVariable Integer count) {
        Page<Follower> followerPage = service.findAllByUserApp_Id(userId,page,count);
        int totalPage = followerPage.getTotalPages();
        List<FollowerDTO> allFollower = mapper.toListFollowerDTO(followerPage.getContent());
        PagingDate<FollowerDTO> pagingDate = new PagingDate<>(totalPage, page, allFollower);
        return ResponseEntity.ok(pagingDate);
    }

}
