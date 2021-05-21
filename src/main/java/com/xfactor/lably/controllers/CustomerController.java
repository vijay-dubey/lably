package com.xfactor.lably.controllers;


import java.util.List;
import java.util.Optional;

import com.xfactor.lably.entity.Customer;
import com.xfactor.lably.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
   
    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        Customer persistedCustomer = customerRepository.save(customer);
        return persistedCustomer;
    }


    @GetMapping("/getCustomers")
    public List<Customer> getCustomers() {
        List<Customer> persistedCustomers =  customerRepository.findAll();
        return persistedCustomers;
    }


    @GetMapping("getCustomerById")
    public Customer findCustomerById(@RequestParam Long id) {
        Optional<Customer> customer =  customerRepository.findById(id);
        if(customer.isPresent()) {
            return customer.get();
        }
        return null;
    }

}
