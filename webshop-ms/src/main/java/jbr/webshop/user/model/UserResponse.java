package jbr.webshop.user.model;

import jbr.webshop.common.model.ApiResponseEntity;
import lombok.Data;

@Data
public class UserResponse implements ApiResponseEntity {
  private static final long serialVersionUID = 1L;

  private UserResponseModel user;

  public UserResponse() {
  }

  public UserResponse(UserResponseModel user) {
    this.user = user;
  }

}
