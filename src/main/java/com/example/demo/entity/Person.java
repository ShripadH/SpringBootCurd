package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "Person")
public class Person {

	public Person() {
		super();
	}
	
	@Id
	@GeneratedValue
	private int Id;
	private String Name;
	private String Address;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Person(String name, String address) {
		super();
		Name = name;
		Address = address;
	}

}
