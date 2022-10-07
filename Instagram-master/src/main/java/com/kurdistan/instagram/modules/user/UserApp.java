package com.kurdistan.instagram.modules.user;


import com.kurdistan.instagram.common.BaseEntity;
import com.kurdistan.instagram.modules.comment.Comment;
import com.kurdistan.instagram.modules.follower.Follower;
import com.kurdistan.instagram.modules.following.Following;
import com.kurdistan.instagram.modules.like.Like;
import com.kurdistan.instagram.modules.post.Post;
import lombok.Data;
import org.hibernate.envers.Audited;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@Entity
@Audited
@Table(name = "tbl_user")
public class UserApp extends BaseEntity {

    @NotNull
    @Column(name = "first_name")
    private String name;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "user_name")
    private String userName;

    @NotNull
    private String password;

    @NotNull
    @Column(name = "phone")
    private String phone;

    @NotNull
    @Column(name = "profile_image")
    private String profileImage;

    @NotNull
    private String bio;

    @NotNull
    @Column(name = "follower_count")
    private Long followerCount;

    @NotNull
    @Column(name = "following_count")
    private Long followingCount;


    @OneToMany(mappedBy = "userApp",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<Post> postList;

    @OneToMany(mappedBy = "userApp",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<Like> likes;

    @OneToMany(mappedBy = "userApp",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<Comment> comments;

    @OneToMany(mappedBy = "userApp",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<Follower> followers;

    @OneToMany(mappedBy = "userApp",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<Following> followings;


}