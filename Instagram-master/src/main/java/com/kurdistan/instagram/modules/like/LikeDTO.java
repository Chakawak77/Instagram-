package com.kurdistan.instagram.modules.like;

import com.kurdistan.instagram.common.BaseDTO;
import com.kurdistan.instagram.modules.post.Post;
import com.kurdistan.instagram.modules.user.UserApp;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LikeDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private Boolean like;

    @ApiModelProperty(required = true, hidden = false)
    private Post post;

    @ApiModelProperty(required = true, hidden = false)
    private UserApp userApp;
}
