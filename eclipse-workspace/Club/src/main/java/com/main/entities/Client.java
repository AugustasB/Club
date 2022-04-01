package com.main.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	@NotEmpty(message = "Name is required")
	@Size(min = 3, max = 20, message = "Name has to be between 3 and 20 symbols")
	private String name;
	
	@Column
	@NotEmpty(message = "Surname is required")
	@Size(min = 3, max = 25, message = "Surname has to be between 3 and 20 symbols")
	private String surname;
	
	@Column
	@NotEmpty(message = "email is required")
	@Email(message = "must be a proper email")
	private String email;
	
	@Column
	@Size(max = 15)
	private String phone;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String role;
	
	@OneToMany (mappedBy = "client")
	private List<Registration> registrations;

	public Client() {
		super();
	}

	public Client(String name, String surname, String email, String phone) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
	}
	
	public Client(
			@NotEmpty(message = "Name is required") @Size(min = 3, max = 20, message = "Name has to be between 3 and 20 symbols") String name,
			@NotEmpty(message = "Surname is required") @Size(min = 3, max = 25, message = "Surname has to be between 3 and 20 symbols") String surname,
			@NotEmpty(message = "email is required") @Email(message = "must be a proper email") String email,
			@Size(max = 15) String phone, String username, String password, String role) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
