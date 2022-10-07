package com.kurdistan.instagram.modules.follower;

import com.kurdistan.instagram.common.BaseDTO;
import com.kurdistan.instagram.modules.user.UserApp;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FollowerDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String userName;

    @ApiModelProperty(required = true,hidden = false)
    private String profileImage;

    @ApiModelProperty(required = true,hidden = false)
    private String isFollower;

    @ApiModelProperty(required = true,hidden = false)
    private UserApp userApp;

}
