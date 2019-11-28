package com.bootrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootrest.model.Customer;
import com.bootrest.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CustomerController {

  @Autowired
  CustomerService customerService;

  @PostMapping("addCustomer")
  public void addProduct(@RequestBody Customer customer) {
    Customer newCustomer = customerService.addCustomer(customer);
    log.info("Added customer: " + newCustomer.getCustomerName());
  }

}
