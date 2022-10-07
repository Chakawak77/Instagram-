package com.kurdistan.instagram.modules.following;

import com.kurdistan.instagram.modules.follower.Follower;
import com.kurdistan.instagram.modules.follower.FollowerRepository;
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
public class FollowingServiceImp implements FollowingService{

    private final FollowingRepository repository;
    private final UserService userService;


    @Override
    public Following save(Following following) {
        Long userId = following.getUserApp().getId();
        UserApp userApp = userService.findById(userId);
        following.setUserApp(userApp);
        return repository.save(following);
    }

    @Override
    public Following update(Following following) {
        Following updateFollowing =findById(following.getId());
        updateFollowing.setProfileImage(following.getProfileImage());
        updateFollowing.setNotFollow(following.getNotFollow());
        updateFollowing.setUserName(following.getUserName());
        return repository.save(updateFollowing);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public Following findById(Long id) {
        Optional<Following> optionalFollowing = repository.findById(id);
        if (optionalFollowing.isEmpty())
            throw new RuntimeException("Not found");
        return optionalFollowing.get();
    }

    @Override
    public Page<Following> findAllFollowing(Integer page, Integer count) {
        return repository.findAll(PageRequest.of(page,count, Sort.by("id").ascending()));
    }

    @Override
    public Page<Following> findAllByUserApp_Id(Long userAppId, Integer page, Integer count) {
        return repository.findAllByUserApp_Id(userAppId,PageRequest.of(page,count));
    }
}
