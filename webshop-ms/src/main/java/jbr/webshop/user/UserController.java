package jbr.webshop.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jbr.webshop.common.exception.ServiceException;
import jbr.webshop.common.model.ApiResponseEnvelope;
import jbr.webshop.user.dto.LoginDto;
import jbr.webshop.user.dto.UserDto;
import jbr.webshop.user.model.LoginModel;
import jbr.webshop.user.model.UserResponse;
import jbr.webshop.user.model.UserResponseModel;
import jbr.webshop.user.service.UserService;
import jbr.webshop.user.util.UserDtoMapper;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "${spring.data.rest.base-path}/user/validate", method = RequestMethod.POST)
  public ResponseEntity<ApiResponseEnvelope> validate(@RequestBody LoginDto loginDto) {
    LoginModel loginModel = UserDtoMapper.getLoginModel(loginDto);
    try {
      UserResponseModel userResponseModel = userService.validate(loginModel);
      return new ResponseEntity<>(new ApiResponseEnvelope(HttpStatus.OK.value(), new UserResponse(userResponseModel)),
          HttpStatus.OK);
    } catch (ServiceException e) {
      log.error("Error during user validate: " + e);
      return new ResponseEntity<>(new ApiResponseEnvelope(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()),
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping(value = "${spring.data.rest.base-path}/user/add", method = RequestMethod.POST)
  public ResponseEntity<ApiResponseEnvelope> validate(@RequestBody UserDto userDto) {
    try {
      UserResponseModel userResponseModel = userService.addUser(userDto);
      return new ResponseEntity<>(new ApiResponseEnvelope(HttpStatus.OK.value(), new UserResponse(userResponseModel)),
          HttpStatus.OK);
    } catch (ServiceException e) {
      log.error("Error during user add: " + e);
      return new ResponseEntity<>(new ApiResponseEnvelope(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()),
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
