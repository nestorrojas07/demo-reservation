package com.nestorrojas07.democrud.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * @author nrojas
 *
 */
@Data
@Entity
@Table(name = "reservations")
public class Reservation {
	@Id
	@Column(name = "id")
	private Long id;
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String uuid;
	
	private Date from_at;
	private Date to_at;
	
	private Date created_at;
	//relations ship
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	
	

}
