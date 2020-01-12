/**
 * 
 */
package com.nestorrojas07.democrud.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
}
