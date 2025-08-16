
package com.javatechie.jpa.controller;

import com.javatechie.jpa.dto.OrderRequest;
import com.javatechie.jpa.dto.OrderResponse;
import com.javatechie.jpa.entity.Customer;
import com.javatechie.jpa.repository.CustomerRepository;
import com.javatechie.jpa.repository.ProductRepository;
import com.javatechie.jpa.repository.SpringDataJpaMappingApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private final SpringDataJpaMappingApplication springDataJpaMappingApplication;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    OrderController(SpringDataJpaMappingApplication springDataJpaMappingApplication) {
        this.springDataJpaMappingApplication = springDataJpaMappingApplication;
    }

    @PostMapping("/placeOrder")
    //public Customer placeOrder(@RequestBody OrderRequest request){
      // return customerRepository.save(request.getCustomer());
    //}

    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders(){
        return customerRepository.findAll();
    }

    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation(){
        return customerRepository.getJoinInformation();
    }
}
