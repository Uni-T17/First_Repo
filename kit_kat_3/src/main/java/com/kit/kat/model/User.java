package com.kit.kat.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users") 
public class User {
	
	
	@Id
	private String name;
	private int age;
	private String email;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof User)) return false;
	    User user = (User) o;
	    return age == user.age && 
	           Objects.equals(email, user.email) && 
	           Objects.equals(name, user.name);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(age, email, name);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
