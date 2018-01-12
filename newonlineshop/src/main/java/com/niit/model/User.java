package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Component
public class User {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private String username;
	
	private String password;
	@NotEmpty(message="mail id is mandatory")
	private String usermailid;
	
	private int contactno;
	private String role;
	public User(){
		role="ROLE_USER";
		}
public String getUsername(){
		
		return username ;
		
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getUsermailid() {
		return usermailid;
	}
	public void setUsermailid(String usermailid) {
		this.usermailid = usermailid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public int getContactno() {
		return contactno;
	}
	public void setContactno(int contactno) {
		this.contactno = contactno;
	}
	
}
