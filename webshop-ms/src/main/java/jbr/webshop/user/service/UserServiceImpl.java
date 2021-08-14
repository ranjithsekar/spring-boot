package jbr.webshop.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jbr.webshop.common.exception.ServiceException;
import jbr.webshop.user.dao.UserDao;
import jbr.webshop.user.dto.UserDto;
import jbr.webshop.user.model.LoginModel;
import jbr.webshop.user.model.UserModel;
import jbr.webshop.user.model.UserResponseModel;
import jbr.webshop.user.util.UserResponseModelImpl;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  @Override
  public UserResponseModel validate(LoginModel loginModel) throws ServiceException {
    try {
      return userDao.validate(loginModel);
    } catch (Exception e) {
      throw new ServiceException(e.getMessage(), e);
    }
  }

  @Override
  public UserResponseModel addUser(UserDto userDto) throws ServiceException {
    try {
      UserModel result = userDao.addUser(userDto);
      return new UserResponseModelImpl(result.getFirstname(), result.getLastname(), result.getEmail(),
          result.getAddress(), result.getPhone());
    } catch (Exception e) {
      throw new ServiceException(e.getMessage(), e);
    }
  }

}
