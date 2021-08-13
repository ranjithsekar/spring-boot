package jbr.webshop.user.service;

import jbr.webshop.common.exception.ServiceException;
import jbr.webshop.user.model.LoginEntity;
import jbr.webshop.user.model.UserEntity;
import jbr.webshop.user.model.UserResponseModel;

public interface UserService {

  UserResponseModel validate(LoginEntity loginModel) throws ServiceException;
  
  UserEntity saveUser(UserEntity userModel) throws ServiceException;
}
