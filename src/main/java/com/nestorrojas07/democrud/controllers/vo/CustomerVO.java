/**
 * 
 */
package com.nestorrojas07.democrud.controllers.vo;

import lombok.Data;

/**
 * @author nrojas
 *
 */
@Data
public class CustomerVO {
	private Long id;
	private String uuid;
	private String dni;
	private String name;
	private String lastName;
	private String email;
	private String address;
	private String phoneNumber;
}
