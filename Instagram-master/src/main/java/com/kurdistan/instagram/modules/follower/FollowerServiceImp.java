package com.kurdistan.instagram.modules.follower;


import com.kurdistan.instagram.modules.post.Post;
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
public class FollowerServiceImp implements FollowerService{

    private final FollowerRepository repository;
    private final UserService userService;

    @Override
    public Follower save(Follower follower) {
        Long userId=follower.getUserApp().getId();
        UserApp userApp=userService.findById(userId);
        follower.setUserApp(userApp);
        return repository.save(follower);
    }

    @Override
    public Follower update(Follower follower) {
        Follower updateFollower =findById(follower.getId());
        updateFollower.setProfileImage(follower.getProfileImage());
        updateFollower.setIsFollower(follower.getIsFollower());
        updateFollower.setUserName(follower.getUserName());
        return repository.save(updateFollower);
    }
    @Override
    public void delete(Long id) {
    findById(id);
    repository.deleteById(id);
    }
    @Override
    public Follower findById(Long id) {
        Optional<Follower> optionalFollower = repository.findById(id);
        if (optionalFollower.isEmpty())
            throw new RuntimeException("Not found");
        return optionalFollower.get();
}

    @Override
    public Page<Follower> findAllFollower(Integer page, Integer count) {
        return repository.findAll(PageRequest.of(page,count,Sort.by("id").ascending()));
    }

    @Override
    public Page<Follower> findAllByUserApp_Id(Long userAppId, Integer page, Integer count) {
        return repository.findAllByUserApp_Id(userAppId,PageRequest.of(page,count));
    }
}
