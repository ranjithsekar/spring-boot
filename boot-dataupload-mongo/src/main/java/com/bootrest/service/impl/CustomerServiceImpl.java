package com.bootrest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootrest.model.Customer;
import com.bootrest.repository.CustomerRepository;
import com.bootrest.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  CustomerRepository customerRepository;

  @Override
  public Customer addCustomer(Customer customer) {
    log.info("addCustomer: " + customer.toString());
    return customerRepository.insert(customer);
  }

  @Override
  public boolean deleteCustomer(String customerId) {
    return false;
  }

  @Override
  public Customer updateCustomer(Customer customer) {
    return null;
  }

}
