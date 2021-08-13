package jbr.webshop.user.util;

import jbr.webshop.user.dto.LoginDto;
import jbr.webshop.user.dto.UserDto;
import jbr.webshop.user.model.LoginEntity;
import jbr.webshop.user.model.UserEntity;

public class UserDtoMapper {

  public static UserEntity getUserModel(UserDto dto) {
    return new UserEntity(null, dto.getUsertype(), dto.getFirstname(), dto.getLastname(), dto.getEmail(),
        dto.getAddress(), dto.getPhone());
  }

  public static LoginEntity getLoginModel(LoginDto dto) {
    return new LoginEntity(null, dto.getUsername(), dto.getPassword(), null);
  }

}
