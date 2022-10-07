package com.kurdistan.instagram.modules.user;

import org.springframework.data.domain.Page;

public interface UserService {
    UserApp save(UserApp userApp);

    UserApp update(UserApp userApp);

    void delete(Long id);

    Page<UserApp> findAll(Integer page,Integer size);

    UserApp findById(Long id);
}
