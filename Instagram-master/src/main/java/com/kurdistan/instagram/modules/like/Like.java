package com.kurdistan.instagram.modules.like;

import com.kurdistan.instagram.common.BaseEntity;
import com.kurdistan.instagram.modules.post.Post;
import com.kurdistan.instagram.modules.user.UserApp;
import lombok.Data;
import org.hibernate.envers.Audited;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Audited
@Table(name = "tbl_like")
public class Like extends BaseEntity {

    @NotNull
    private Boolean like;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserApp userApp;
}
