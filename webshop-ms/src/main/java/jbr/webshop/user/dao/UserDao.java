package jbr.webshop.user.dao;

import jbr.webshop.common.exception.DaoException;
import jbr.webshop.user.model.LoginEntity;
import jbr.webshop.user.model.UserEntity;
import jbr.webshop.user.model.UserResponseModel;

public interface UserDao {

  UserResponseModel validate(LoginEntity loginModel) throws DaoException;

  UserEntity saveUser(UserEntity userModel) throws DaoException;
}
