package com.kurdistan.instagram.modules.post;


import com.kurdistan.instagram.common.BaseDTO;
import com.kurdistan.instagram.modules.user.UserApp;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PostDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private String title;

    @ApiModelProperty(required = true, hidden = false)
    private String imagePost;

    @ApiModelProperty(required = true, hidden = false)
    private String description;

    @ApiModelProperty(required = true, hidden = false)
    private UserApp userApp;

    @ApiModelProperty(required = true, hidden = false)
    private LocationDTO location;
}
