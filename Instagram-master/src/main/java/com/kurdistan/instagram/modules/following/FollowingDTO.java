package com.kurdistan.instagram.modules.following;

import com.kurdistan.instagram.common.BaseDTO;
import com.kurdistan.instagram.modules.user.UserApp;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FollowingDTO extends BaseDTO {

        @ApiModelProperty(required = true,hidden = false)
        private String userName;

        @ApiModelProperty(required = true,hidden = false)
        private String profileImage;

        @ApiModelProperty(required = true,hidden = false)
        private String notFollower;

        @ApiModelProperty(required = true,hidden = false)
        private UserApp userApp;

}
