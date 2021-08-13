package jbr.webshop.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
  @Id
  @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
  @Column(updatable = false)
  private Long userid;

  private String usertype;

  private String firstname;

  private String lastname;

  private String email;

  private String address;

  private Long phone;
}
