package jbr.webshop.user.model;

import jbr.webshop.common.model.ApiResponseEntity;
import lombok.Data;

@Data
public class LoginResponse implements ApiResponseEntity {
  private static final long serialVersionUID = 1L;

  private LoginResponseModel responseBody;

  public LoginResponse() {
  }

  public LoginResponse(LoginResponseModel response) {
    this.responseBody = response;
  }

}
