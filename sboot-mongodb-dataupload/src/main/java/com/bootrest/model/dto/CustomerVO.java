package com.bootrest.model.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CustomerVO implements Serializable {
  private static final long serialVersionUID = 1L;
  private String customerId;

  @Size(min = 3, max = 20, message = "{customer.customerName.size}")
  @NotEmpty(message = "{customer.name.empty}")
  private String customerName;

  @Email(message = "{customer.email.valid}")
  @NotEmpty(message = "{customer.email.empty}")
  private String email;

  @NotEmpty(message = "{customer.address.empty}")
  private String address;

  @NotEmpty(message = "{customer.mobile.empty}")
  private String mobile;

  @NotEmpty(message = "{customer.favCategory.empty}")
  private List<String> favoriteCategories;

}
