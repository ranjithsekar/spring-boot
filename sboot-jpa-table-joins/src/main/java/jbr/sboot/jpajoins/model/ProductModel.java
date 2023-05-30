package jbr.sboot.jpajoins.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "product")
public class ProductModel {

	@Id
	Long id;
	String name;
	String category;
	Integer price;

	@Column(name = "created_at")
	Date createdAt;

	@Column(name = "updated_at")
	Date updatedAt;
}
