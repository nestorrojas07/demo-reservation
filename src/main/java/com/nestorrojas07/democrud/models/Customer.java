/**
 * 
 */
package com.nestorrojas07.democrud.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author nrojas
 *
 */
@Data
@Getter
@Setter
@Entity
@Table(name = "customers")
@NamedQuery(
		name = "Customer.findByEmailAlias",
		query = "select c from Customer c where c.email= ?1"
		)
public class Customer {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String uuid;
	@Column()
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
