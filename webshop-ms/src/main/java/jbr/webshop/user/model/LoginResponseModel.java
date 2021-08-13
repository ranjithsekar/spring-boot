package jbr.webshop.user.model;

import jbr.webshop.common.model.ApiResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseModel implements ApiResponseEntity {
  private static final long serialVersionUID = 1L;

  private String firstname;
  private String lastname;
}
