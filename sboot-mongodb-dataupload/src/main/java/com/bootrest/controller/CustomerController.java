package com.bootrest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bootrest.model.dto.CustomerVO;
import com.bootrest.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Customer Management APIs.
 * 
 * @author Ranjith Sekar
 * @since 2019-Nov-29
 */
@Api(value = "Customer API", tags = { "Customer Management" })
@Validated
@RestController
@RequestMapping("/api/angadi/v1/customers")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @ApiOperation(value = "Create a new customer.")
  @PostMapping(path = "/createCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<String> createCustomer(@Valid @RequestBody CustomerVO customerVO) {
    customerService.createCustomer(customerVO);

    return new ResponseEntity<String>("CREATE SUCCESS", HttpStatus.CREATED);
  }

  @ApiOperation(value = "Update an existing customer.")
  @PostMapping(path = "/updateCustomer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<String> updateCustomerById(@PathVariable("id") String id,
      @Valid @RequestBody CustomerVO customerVO) {
    customerVO.setCustomerId(id);
    customerService.updateCustomer(customerVO);

    return new ResponseEntity<String>("UPDATE SUCCESS", HttpStatus.OK);
  }

  @ApiOperation(value = "Delete an existing customer.")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping(value = "/deleteCustomer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> deleteCustomer(@PathVariable("id") String id) {
    customerService.deleteCustomer(id);

    return new ResponseEntity<String>("DELETE SUCCESS", HttpStatus.OK);
  }
}