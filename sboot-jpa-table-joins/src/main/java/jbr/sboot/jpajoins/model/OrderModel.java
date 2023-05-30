package jbr.sboot.jpajoins.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "order")
public class OrderModel {

	@Id
	Long orderid;
	Long userid;
	Long productid;
	String status;
}
