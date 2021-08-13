package jbr.webshop.util;

import jbr.webshop.user.model.UserResponseModel;

public class UserResponseModelImpl implements UserResponseModel {

  @Override
  public String getFirstname() {
    return "Ranjith";
  }

  @Override
  public String getLastname() {
    return "Sekar";
  }

  @Override
  public String getEmail() {
    return "ranjith@gmail.com";
  }

  @Override
  public String getAddress() {
    return "chennai";
  }

  @Override
  public Long getPhone() {
    return 1234L;
  }

}
