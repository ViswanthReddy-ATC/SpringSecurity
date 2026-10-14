
package com.viswa.springsecdemo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity

@Table(name = "customer")

@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "email")
	private String email;

	@Column(name = "pwd")
	private String password;

	@Column(name = "role")
	private String role;
}
