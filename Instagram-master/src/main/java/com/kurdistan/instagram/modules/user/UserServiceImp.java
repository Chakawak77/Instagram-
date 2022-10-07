package com.kurdistan.instagram.modules.user;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository repository;

    @Override
    public UserApp save(UserApp userApp) {
        return repository.save(userApp);
    }

    @Override
    public UserApp update(UserApp userApp) {
        UserApp updateUserApp=findById(userApp.getId());
        updateUserApp.setBio(updateUserApp.getBio());
        updateUserApp.setPassword(updateUserApp.getPassword());
        updateUserApp.setName(updateUserApp.getName());
        updateUserApp.setUserName(updateUserApp.getName());
        updateUserApp.setPhone(updateUserApp.getPhone());
        updateUserApp.setEmail(updateUserApp.getEmail());
        updateUserApp.setProfileImage(updateUserApp.getEmail());
        updateUserApp.setEmail(updateUserApp.getProfileImage());
        updateUserApp.setFollowerCount(updateUserApp.getFollowerCount());
        updateUserApp.setFollowingCount(updateUserApp.getFollowingCount());
        return repository.save(updateUserApp);
    }

    @Override
    public void delete(Long id) {
    findById(id);
    repository.deleteById(id);
    }

    @Override
    public Page<UserApp> findAll(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size));
    }

    @Override
    public UserApp findById(Long id) {
        Optional<UserApp> optionalUserApp=repository.findById(id);
        if (optionalUserApp.isEmpty())
            throw new RuntimeException("Not found");
        return optionalUserApp.get();
    }


}
