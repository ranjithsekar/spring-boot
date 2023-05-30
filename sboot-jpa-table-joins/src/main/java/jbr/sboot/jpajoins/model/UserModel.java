package jbr.sboot.jpajoins.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "users")
public class UserModel {

	@Id
	Long useid;
	String username;
	String password;
	String firstname;
	String lastname;
	String address;
	@Column(name = "created_at")
	Date createdAt;

}
