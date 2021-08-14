package jbr.webshop.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jbr.webshop.common.exception.DaoException;
import jbr.webshop.user.dto.UserDto;
import jbr.webshop.user.model.LoginModel;
import jbr.webshop.user.model.UserModel;
import jbr.webshop.user.model.UserResponseModel;
import jbr.webshop.user.repo.LoginRepository;
import jbr.webshop.user.repo.UserRepository;
import jbr.webshop.user.util.UserDtoMapper;

@Component
public class UserDaoImpl implements UserDao {

  @Autowired
  private UserRepository userRepo;

  @Autowired
  private LoginRepository loginRepo;

  @Override
  public UserResponseModel validate(LoginModel loginModel) throws DaoException {
    try {
      return userRepo.validateUser(loginModel.getUsername(), loginModel.getPassword());
    } catch (Exception e) {
      throw new DaoException(e.getMessage(), e);
    }
  }

  @Override
  public UserModel addUser(UserDto userDto) throws DaoException {

    UserModel userModel = UserDtoMapper.getUserModel(userDto);
    LoginModel loginModel = UserDtoMapper.getLoginModel(userDto);

    try {
      UserModel outputUser = userRepo.save(userModel);
      loginModel.setUserid(outputUser.getUserid());
      loginRepo.save(loginModel);

      return outputUser;
    } catch (Exception e) {
      throw new DaoException(e.getMessage(), e);
    }
  }

}
