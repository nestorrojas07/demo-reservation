/**
 * 
 */
package com.nestorrojas07.democrud.services;


import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.nestorrojas07.democrud.models.Customer;
import com.nestorrojas07.democrud.repositories.CustomerRepository;

/**
 * Clase para definir los servicios de Customer
 * @author nrojas
 *
 */
@Service
public class CustomerService {
	
	private final CustomerRepository customerRepository;

	/**
	 * @param customerRepository
	 */
	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	/**
	 * Method for save customer
	 * @param custmer
	 * @return
	 */
	@Transactional
	public Customer create(Customer custmer) {
		return this.customerRepository.save(custmer);
	}
	
	/**
	 * Update Customer
	 * @param custmer
	 * @return
	 */
	@Transactional
	public Customer update(Customer custmer) {
		return this.customerRepository.save(custmer);
	}
	
	/**
	 * Delete Customer
	 * @param customer
	 */
	@Transactional
	public void delete(Customer customer) {
		this.customerRepository.delete(customer);
	}
	
	/**
	 *  Find customer by DNI
	 * @param dni
	 * @return
	 */
	public Customer findByDni(String dni) {
		return this.findByDni(dni);
	}
	
	

}
