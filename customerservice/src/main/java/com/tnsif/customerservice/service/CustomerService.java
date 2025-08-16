package com.tnsif.customerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnsif.customerservice.entity.Customer;
import com.tnsif.customerservice.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	private CustomerRepository repo;
	
	//to get all the records from table
	public List<Customer> listAll(){
		return repo.findAll();
		
	}
	
	//save the record
	public void save(Customer c) {
		repo.save(c);
	}
	
	
	//to call a specific record 
	public Customer get(Integer cid) { 
		return repo.findById(cid).get(); 
	}
	
	//delete particular record with id
	public void delete(Integer cid) {
		repo.deleteById(cid);
	}
	
	//for update
	public void update(Customer c) {
		repo.save(c);
	}

}