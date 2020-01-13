/**
 * 
 */
package com.nestorrojas07.democrud.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * @author nrojas
 *
 */
@Data
@Entity
@Table(name = "customers")
@NamedQuery(
		name = "Customer.findByEmail",
		query = "select c from Customer c where c.email= ?1"
		)
public class Customer {
	@Id
	@Column(name = "id")
	private Long id;
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String uuid;
	private String dni;
	private String name;
	private String lastName;
	private String email;
	private String address;
	private String phoneNumber;
	
	//relationShip
	@OneToMany(mappedBy = "customer")
	private Set<Reservation> reservations;
	
}
