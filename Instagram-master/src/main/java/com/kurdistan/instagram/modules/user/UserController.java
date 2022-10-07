package com.kurdistan.instagram.modules.user;

import com.kurdistan.instagram.common.PagingDate;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/userApp/")
public class UserController {
     private final UserService service;
     private final UserMapper mapper;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody UserDTO userDTO) {
        UserApp userApp= mapper.toUserApp(userDTO);
        service.save(userApp);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<UserDTO> update(@RequestBody  UserDTO userDTO) {
        UserApp userApp = mapper.toUserApp(userDTO);
        UserDTO updateUser = mapper.toUserDTO(service.update(userApp));
        return ResponseEntity.ok(updateUser);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/v1/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id){
        UserApp userApp=service.findById(id);
        UserDTO userDTO=mapper.toUserDTO(userApp);
        return ResponseEntity.ok(userDTO);
    }
    @GetMapping("/paging/{page}/{count}")
    public ResponseEntity<PagingDate<UserDTO>> pagination(@PathVariable Integer page, @PathVariable Integer count) {
        Page<UserApp> userAppPage = service.findAll(page, count);
        int totalPage = userAppPage.getTotalPages();
        List<UserDTO> allUser = mapper.toListUserDTO(userAppPage.getContent());
        PagingDate<UserDTO> pagingDate = new PagingDate<>(totalPage, page, allUser);
        return ResponseEntity.ok(pagingDate);
    }
}
