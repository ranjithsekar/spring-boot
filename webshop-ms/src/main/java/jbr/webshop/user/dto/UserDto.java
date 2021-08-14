package jbr.webshop.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
  private String usertype;
  private String username;
  private String password;  
  private String firstname;
  private String lastname;
  private String email;
  private String address;
  private String phone;
}
