package jbr.webshop.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jbr.webshop.common.exception.ServiceException;
import jbr.webshop.user.dao.UserDao;
import jbr.webshop.user.model.LoginEntity;
import jbr.webshop.user.model.UserEntity;
import jbr.webshop.user.model.UserResponseModel;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  @Override
  public UserResponseModel validate(LoginEntity loginModel) throws ServiceException {
    try {
      return userDao.validate(loginModel);
    } catch (Exception e) {
      throw new ServiceException(e.getMessage(), e);
    }
  }

  @Override
  public UserEntity saveUser(UserEntity userModel) throws ServiceException {
    try {
      return null;
    } catch (Exception e) {
      throw new ServiceException(e.getMessage(), e);
    }
  }

}
