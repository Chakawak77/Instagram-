package com.kurdistan.instagram.modules.follower;

import com.kurdistan.instagram.common.BaseEntity;
import com.kurdistan.instagram.modules.user.UserApp;
import lombok.Data;
import org.hibernate.envers.Audited;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Audited
@Table(name = "tbl_follower")
public class Follower extends BaseEntity {

    @NotNull
    @Column(name = "user_name")
    private String userName;

    @NotNull
    @Column(name = "profile_Image")
    private String profileImage;

    @NotNull
    @Column(name = "follower")
    private String isFollower;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private UserApp userApp;

}
