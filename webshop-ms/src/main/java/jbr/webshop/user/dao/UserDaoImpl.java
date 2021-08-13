package jbr.webshop.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jbr.webshop.common.exception.DaoException;
import jbr.webshop.user.model.LoginEntity;
import jbr.webshop.user.model.UserEntity;
import jbr.webshop.user.model.UserResponseModel;
import jbr.webshop.user.repo.UserRepository;

@Component
public class UserDaoImpl implements UserDao {

  @Autowired
  private UserRepository userRepo;

  @Override
  public UserResponseModel validate(LoginEntity loginModel) throws DaoException {
    try {
      UserResponseModel resp = userRepo.validateUser(loginModel.getUsername(), loginModel.getPassword()); 
      return resp;
    } catch (Exception e) {
      throw new DaoException(e.getMessage(), e);
    }
  }

  @Override
  public UserEntity saveUser(UserEntity userModel) throws DaoException {

    try {
      return null;
    } catch (Exception e) {
      throw new DaoException(e.getMessage(), e);
    }
  }

}
