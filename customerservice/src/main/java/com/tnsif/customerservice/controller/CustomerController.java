package com.tnsif.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tnsif.customerservice.entity.Customer;
import com.tnsif.customerservice.service.CustomerService;

import jakarta.persistence.NoResultException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class CustomerController {
	
	@Autowired // to create the beans
	private CustomerService c;
	@GetMapping("/customerservice")
	public List<Customer> list(){
		return c.listAll();
	}
	
	@PostMapping("/customerservice")// this the url going to connect between frontend and backend
	public void add(@RequestBody Customer c1) {
		//the customer is going to hold the data with the help of Resquest body annotation
		c.save(c1);// calling the save method from customer service 
	}
	
	@GetMapping("/customerservice/{id}") // the id also passed here(eg:101)
	public ResponseEntity<Customer> get(@PathVariable Integer id){
		// this path variable is going to add the id to the url.(fetches the id into url)
		
		try {// try block to handle the exception... if my id is not valid
			Customer c2 = c.get(id);
			return new ResponseEntity<Customer>(c2,HttpStatus.OK); 
			//ResponseEntity is a interface... if the 
		}catch(NoResultException e) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/customerservice/{id}")
	public void delete(@PathVariable Integer id) {
		c.delete(id);// calling delete method
	}
	
	// put mapping si going to update
	@PutMapping("/customerservice/{id}")
	public ResponseEntity<Customer> update(@PathVariable Integer id,@RequestBody Customer update_c){
		try {                                                 //to hold the new updated value
			Customer exist_c = c.get(id);// to fetch particular data
			
			exist_c.setC_name(update_c.getC_name());
			//updaing the exist.c by giving value through the getC
			exist_c.setAddress(update_c.getAddress());
			c.update(exist_c);
			return new ResponseEntity<Customer>(exist_c,HttpStatus.OK);
		}catch(NoResultException e) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
	}
	
}