package com.bootrest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bootrest.exception.CustomerNotFoundException;
import com.bootrest.model.Customer;
import com.bootrest.model.dto.CustomerVO;
import com.bootrest.repository.CustomerDao;
import com.bootrest.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerDao customerDao;

  @Value("${customer.not.found}")
  private String customerNotFound;

  @Override
  public void createCustomer(CustomerVO customerVO) {
    log.info("Adding new customer: " + customerVO.toString());
    Customer customer = new Customer();
    customer.setCustomerId(customerVO.getCustomerId());
    customer.setCustomerName(customerVO.getCustomerName());
    customer.setFavoriteCategories(customerVO.getFavoriteCategories());
    customer.setEmail(customerVO.getEmail());
    customer.setAddress(customerVO.getAddress());
    customer.setMobile(customerVO.getMobile());
    customer.setActive(true);

    Customer newCustomer = customerDao.save(customer);
    log.info("New customer added: " + newCustomer.toString());
  }

  @Override
  public void updateCustomer(CustomerVO customerVO) {
    Customer customer = customerDao.findByCustomerId(customerVO.getCustomerId())
        .orElseThrow(() -> new CustomerNotFoundException(customerNotFound));

    customer.setCustomerId(customerVO.getCustomerId());
    customer.setCustomerName(customerVO.getCustomerName());
    customer.setFavoriteCategories(customerVO.getFavoriteCategories());
    customer.setEmail(customerVO.getEmail());
    customer.setAddress(customerVO.getAddress());
    customer.setMobile(customerVO.getMobile());

    customerDao.save(customer);
  }

  @Override
  public void deleteCustomer(String customerId) {
    log.info("Deleting customer with id: " + customerId);
    Customer customer = customerDao.findByCustomerId(customerId)
        .orElseThrow(() -> new CustomerNotFoundException(customerNotFound));
    customer.setActive(false);

    customerDao.save(customer);
  }

}
