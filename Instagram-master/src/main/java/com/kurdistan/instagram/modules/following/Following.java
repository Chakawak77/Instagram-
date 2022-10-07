package com.kurdistan.instagram.modules.following;

import com.kurdistan.instagram.common.BaseEntity;
import com.kurdistan.instagram.modules.user.UserApp;
import lombok.Data;
import org.hibernate.envers.Audited;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Audited
@Table(name = "tbl_following")
public class Following extends BaseEntity {

    @NotNull
    @Column(name = "user_name")
    private String userName;

    @NotNull
    @Column(name = "profile_Image")
    private String profileImage;

    @NotNull
    @Column(name = "following")
    private String notFollow;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private UserApp userApp;


}
