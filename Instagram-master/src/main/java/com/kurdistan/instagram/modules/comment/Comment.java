package com.kurdistan.instagram.modules.comment;

import com.kurdistan.instagram.common.BaseEntity;
import com.kurdistan.instagram.modules.user.UserApp;
import com.kurdistan.instagram.modules.post.Post;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Audited
@Table(name = "tbl_comment")
public class Comment extends BaseEntity {

    @NotNull
    @Column(name = "content")
    private String content;

   /* @NotNull
    @Column(name = "date")
    private Date date;
*/

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserApp userApp;
}
