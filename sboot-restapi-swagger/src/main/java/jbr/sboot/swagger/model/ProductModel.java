package jbr.sboot.swagger.model;

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
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "product")
public class ProductModel {

  @Id
  @SequenceGenerator(name = "product_id_seq", sequenceName = "product_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq")
  @Column(updatable = false)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "category")
  private String category;

  @Column(name = "price")
  private String price;
}
