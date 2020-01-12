/**
 * 
 */
package com.nestorrojas07.democrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nestorrojas07.democrud.models.Customer;

/**
 * @author nrojas
 *
 */
public interface CustomerRepository  extends JpaRepository<Customer, Integer>{

}
