package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.exception.ResourceNotFound;
import com.example.demo.repository.PersonRepository;

@RestController
@RequestMapping("/api/person")
public class PersonController {

	@Autowired
	private PersonRepository p;	
	public PersonController() {
		// TODO Auto-generated constructor stub
	}
	@GetMapping
	public List<Person> GetAllPerson()
	{
		return this.p.findAll();
	}
	
	@GetMapping("/{id}")
	public Person GetPersonbyId(@PathVariable(value ="id") int id)
	{
		return this.p.findById(id).orElseThrow(()-> new ResourceNotFound("user Not found with id " + id));
	}
	
	@PostMapping
	public Person CreatePerson(@RequestBody Person p)
	{
		return this.p.save(p);
	}
	
	@PutMapping("/{id}")
	public Person UpdatePerson(@RequestBody Person p, @PathVariable(value = "id") int id)
	{
		Person p1 = this.p.findById(id).orElseThrow(()-> new ResourceNotFound("user Not found with id " + id));	
		
		p1.setAddress(p.getAddress());
		p1.setName(p.getName());
		
		this.p.save(p);
		return p1;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Person> DeletePerson(@PathVariable(value = "id") int id)
	{
		Person p1 = this.p.findById(id).orElseThrow(()-> new ResourceNotFound("user Not found with id " + id));	
		this.p.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
