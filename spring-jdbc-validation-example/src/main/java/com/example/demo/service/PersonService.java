package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PersonDto;
import com.example.demo.repository.PersonRepository;

/**
 * 
 * @author vamsir
 *
 */
@Service
public class PersonService {

	@Autowired
	public PersonRepository personRepository;

	/**
	 * This method for save person details.
	 * 
	 * @param personDetails
	 * @return
	 */
	public void create(@Valid PersonDto personDetails) {
		 personRepository.save(personDetails);
	}

	/**
	 * This method for get person details based on id.
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PersonDto getBasedOnPersonId(int id) {
		return personRepository.findById(id);
	}

	/**
	 * This method for get all person details.
	 * 
	 * @return
	 */
	public List<PersonDto> getAllPersonDetails() {
		return personRepository.findAll();
	}

	/**
	 * This method for delete person detatils based on Id
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void delete(int id) throws Exception {
			personRepository.deleteById(id);
	}

}
