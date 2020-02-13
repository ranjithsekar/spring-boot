package rs.sb.graphql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Product {
  
  @Id
  private String id;
  private String name;
  private String type;
  private String price;
}
