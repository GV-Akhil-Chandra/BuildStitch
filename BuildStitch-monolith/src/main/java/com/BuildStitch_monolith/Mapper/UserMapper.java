package com.BuildStitch_monolith.Mapper;

import com.BuildStitch_monolith.DTO.Auth.LoginResponseDTO;
import com.BuildStitch_monolith.Entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
     LoginResponseDTO toLoginResponseDTO(User user);
}
