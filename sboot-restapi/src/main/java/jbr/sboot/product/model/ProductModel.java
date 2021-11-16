package jbr.sboot.product.model;

import java.time.LocalDateTime;

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

/**
 * Product Model.
 * 
 * @author Ranjith Sekar
 * @since 2018, Jun 20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class ProductModel {

  @Id
  @SequenceGenerator(name = "prod_id_seq", sequenceName = "prod_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_id_seq")
  @Column(updatable = false)
  private Long id;

  @Column
  private String name;

  @Column
  private String category;

  @Column
  private Integer price;

  @Column(name = "created_at", insertable = true, updatable = false)
  private LocalDateTime createdAt;

  @Column(name = "updated_at", insertable = true, updatable = true)
  private LocalDateTime updatedAt;
}
