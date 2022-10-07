package com.kurdistan.instagram.modules.comment;


import com.kurdistan.instagram.common.BaseDTO;
import com.kurdistan.instagram.modules.user.UserApp;
import com.kurdistan.instagram.modules.post.Post;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CommentDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private String content;

   /* @ApiModelProperty(required = true,hidden = false)
    private Date date;
    */
    @ApiModelProperty(required = true,hidden = false)
    private Post post;

    @ApiModelProperty(required = true,hidden = false)
    private UserApp userApp;

}
