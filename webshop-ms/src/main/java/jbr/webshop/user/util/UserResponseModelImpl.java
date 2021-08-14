package jbr.webshop.user.util;

import jbr.webshop.user.model.UserResponseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseModelImpl implements UserResponseModel {

  String firstName;
  String lastname;
  String email;
  String address;
  Long phone;

  @Override
  public String getFirstname() {
    return this.firstName;
  }

  @Override
  public String getLastname() {
    return this.lastname;
  }

  @Override
  public String getEmail() {
    return this.email;
  }

  @Override
  public String getAddress() {
    return this.address;
  }

  @Override
  public Long getPhone() {
    return this.phone;
  }

}
