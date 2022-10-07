package com.kurdistan.instagram.modules.user;

import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserApp toUserApp(UserDTO userDTO);
    UserDTO toUserDTO(UserApp userApp);

    List<UserApp> toListUserApp(List<UserDTO> userDTOS);
    List<UserDTO> toListUserDTO(List<UserApp> userApps);


}