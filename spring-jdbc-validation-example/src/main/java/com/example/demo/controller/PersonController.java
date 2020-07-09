package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PersonDto;
import com.example.demo.service.PersonService;
/**
 * 
 * @author vamsir
 *
 */
@RestController
@RequestMapping("/api/person")
public class PersonController {
	
	@Autowired
	public PersonService personService;

	/**
	 * This API for Create Person Details.
	 * 
	 * @param personDetails
	 * @return
	 */
	@PostMapping("/create")
	public ResponseEntity<PersonDto> createPersonDetails(@Valid @RequestBody PersonDto personDetails) {
		 personService.create(personDetails);
		return new ResponseEntity<PersonDto>(HttpStatus.CREATED);
	}

	/**
	 * This API for get Based on Person ID
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<PersonDto> getBasedOnPersonId(@PathVariable(name = "id", required = true) int id) throws Exception {
		PersonDto person = personService.getBasedOnPersonId(id);
		return new ResponseEntity<PersonDto>(person,HttpStatus.OK);
	}

	/**
	 * This API for get All Person Details.
	 * 
	 * @return
	 */
	@GetMapping("/getall")
	public ResponseEntity<List<PersonDto>> getAllPesonDetails() {
		List<PersonDto> person = personService.getAllPersonDetails();
		return new ResponseEntity<List<PersonDto>>(person, HttpStatus.OK);
	}

	/**
	 * This API for deleted Person Details
	 * 
	 * @return
	 * @return
	 * @throws Exception 
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePersonDetails(@PathVariable(name = "id", required = true) int id) throws Exception {
		personService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
