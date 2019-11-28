package com.bootrest.service;

import com.bootrest.model.Customer;

public interface CustomerService {

  Customer addCustomer(Customer customer);

  boolean deleteCustomer(String customerId);

  Customer updateCustomer(Customer customer);
}
