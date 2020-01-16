/**
 * 
 */
package com.nestorrojas07.democrud.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nestorrojas07.democrud.controllers.vo.CustomerVO;
import com.nestorrojas07.democrud.models.Customer;
import com.nestorrojas07.democrud.services.CustomerService;

/**
 * Clase Controladora que va a representar los servicios Rest
 * @author nrojas
 *
 */
@RestController
@RequestMapping("/api/customer")    //mapea el nombre del api
public class CustomerController {
	
	private final CustomerService customerService;

	/**
	 * @param customerService
	 */
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@PostMapping("/")
	public ResponseEntity<Customer> createCustomer(@RequestBody CustomerVO rqs){
		Customer customer = new Customer();
		customer.setDni(rqs.getDni());
		customer.setEmail(rqs.getEmail());
		customer.setAddress(rqs.getAddress());
		customer.setLastName(rqs.getLastName());
		customer.setName(rqs.getName());
		customer.setPhoneNumber(rqs.getPhoneNumber());
		
		return new ResponseEntity<Customer>(customerService.create(customer), HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{dni}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("dni")  String dni, @RequestBody CustomerVO rqs){
		Customer customer = customerService.findByDni(dni);
		if(customer == null ) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		
		customer.setEmail(rqs.getEmail());
		customer.setAddress(rqs.getAddress());
		customer.setLastName(rqs.getLastName());
		customer.setName(rqs.getName());
		customer.setPhoneNumber(rqs.getPhoneNumber());
		
		return new ResponseEntity<Customer>(customerService.update(customer), HttpStatus.OK);
	}
	
	@DeleteMapping("/{dni}")
	public void removeCustomer(@PathVariable("dni")  String dni) {
		Customer customer = customerService.findByDni(dni);
		if(customer == null ) {
			return;
		}
		customerService.delete(customer);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Customer>> listAll() {		
		return ResponseEntity.ok(customerService.findAll());
	}

}
