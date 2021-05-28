package com.bootrest.service;

import com.bootrest.model.dto.CustomerVO;

public interface CustomerService {

  void createCustomer(CustomerVO customer);

  void updateCustomer(CustomerVO customer);

  void deleteCustomer(String customerId);
}
