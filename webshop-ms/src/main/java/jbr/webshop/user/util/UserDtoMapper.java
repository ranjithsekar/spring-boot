package jbr.webshop.user.util;

import jbr.webshop.user.dto.LoginDto;
import jbr.webshop.user.dto.UserDto;
import jbr.webshop.user.model.LoginModel;
import jbr.webshop.user.model.UserModel;

public class UserDtoMapper {

  public static UserModel getUserModel(UserDto dto) {
    return new UserModel(null, dto.getUsertype(), dto.getFirstname(), dto.getLastname(), dto.getEmail(),
        dto.getAddress(), Long.valueOf(dto.getPhone()), null);
  }

  public static LoginModel getLoginModel(LoginDto dto) {
    return new LoginModel(null, dto.getUsername(), dto.getPassword(), null);
  }

  public static LoginModel getLoginModel(UserDto dto) {
    return new LoginModel(null, dto.getUsername(), dto.getPassword(), null);
  }
}
