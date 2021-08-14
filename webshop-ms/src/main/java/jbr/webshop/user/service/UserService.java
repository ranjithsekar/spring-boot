package jbr.webshop.user.service;

import jbr.webshop.common.exception.ServiceException;
import jbr.webshop.user.dto.UserDto;
import jbr.webshop.user.model.LoginModel;
import jbr.webshop.user.model.UserResponseModel;

public interface UserService {

  UserResponseModel validate(LoginModel loginModel) throws ServiceException;
  
  UserResponseModel addUser(UserDto userDto) throws ServiceException;
}
