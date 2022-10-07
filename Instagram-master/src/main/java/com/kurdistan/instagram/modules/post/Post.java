package com.kurdistan.instagram.modules.post;

import com.kurdistan.instagram.common.BaseEntity;
import com.kurdistan.instagram.modules.comment.Comment;
import com.kurdistan.instagram.modules.like.Like;
import com.kurdistan.instagram.modules.user.UserApp;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Audited
@Table(name = "tbl_post")
public class Post extends BaseEntity {

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "image_post")
    private String imagePost;

    @NotNull
    private String description;


    @NotNull
    @Column(name = "location")
    private Point<G2D> location;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private UserApp  userApp;

    @OneToMany(mappedBy = "post",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "post",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Like> likes;

}
