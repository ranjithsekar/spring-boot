package jbr.webshop.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
  private String username;
  private String password;
  private String usertype;
  private String firstname;
  private String lastname;
  private String email;
  private String address;
  private Long phone;
}
