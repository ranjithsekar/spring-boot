package jbr.webshop.user.dao;

import jbr.webshop.common.exception.DaoException;
import jbr.webshop.user.dto.UserDto;
import jbr.webshop.user.model.LoginModel;
import jbr.webshop.user.model.UserModel;
import jbr.webshop.user.model.UserResponseModel;

public interface UserDao {

  UserResponseModel validate(LoginModel loginModel) throws DaoException;

  UserModel addUser(UserDto userDto) throws DaoException;
}
