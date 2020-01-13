/**
 * 
 */
package com.nestorrojas07.democrud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nestorrojas07.democrud.models.Customer;

/**
 * @author nrojas
 *
 */
@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Integer>{
	
	/**
	 * Search By name
	 * @param name name of customer
	 * @return
	 */
	public List<Customer> findByName(String name);
	
	/**
	 * Search by lastName
	 * @param lastName LastName of customer
	 * @return
	 */
	public List<Customer> findByLastName(String lastName);
	
	/**
	 * Find by dni
	 * @param dni
	 * @return
	 */
	public Customer findByDni(String dni);
	
	/**
	 * Search by email use a Named Query
	 * @param email
	 * @return
	 */
	public Customer findByEmailAlias(String email);
}
