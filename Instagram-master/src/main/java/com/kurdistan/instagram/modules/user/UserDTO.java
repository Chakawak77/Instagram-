package com.kurdistan.instagram.modules.user;

import com.kurdistan.instagram.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private String name;

    @ApiModelProperty(required = true, hidden = false)
    private String userName;

    @ApiModelProperty(required = true, hidden = false)
    private String email;

    @ApiModelProperty(required = true, hidden = false)
    private String password;

    @ApiModelProperty(required = true, hidden = false)
    private String phone;

    @ApiModelProperty(required = false,hidden = false)
    private String profileImage;

    @ApiModelProperty(required = false,hidden = false)
    private String bio;

    @ApiModelProperty(required = true,hidden = false)
    private Long postCount;

    @ApiModelProperty(required = true,hidden = false)
    private Long followerCount;

    @ApiModelProperty(required = true,hidden = false)
    private Long followingCount;
}
