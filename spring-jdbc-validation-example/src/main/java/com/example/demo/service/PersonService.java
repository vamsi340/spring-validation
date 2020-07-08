package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PersonDetails;
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
	public PersonDetails create(@Valid PersonDetails personDetails) {
		return personRepository.save(personDetails);
	}

	/**
	 * This method for update Person Details
	 * 
	 * @param personDetails
	 * @return
	 * @throws Exception
	 */
	public PersonDetails update(@Valid PersonDetails personDetails) throws Exception {
		Optional<PersonDetails> personObj = personRepository.findById(personDetails.getPersonId());
		PersonDetails person = new PersonDetails();
		try {
			if (personObj.isPresent()) {
				person = personObj.get();
				person.setActive(true);
				person.setCity(personDetails.getCity());
				person.setCountry(personDetails.getCountry());
				person.setDoorNumber(personDetails.getDoorNumber());
				person.setMandal(personDetails.getMandal());
				person.setModifiedBy(personDetails.getModifiedBy());
				person.setModifiedDate(new Date());
				person.setPersonAge(personDetails.getPersonAge());
				person.setPersonEmail(personDetails.getPersonEmail());
				person.setPersonName(personDetails.getPersonName());
				person.setPhoneNumber(personDetails.getPhoneNumber());
				person.setPinCode(personDetails.getPinCode());
				person.setPostOffice(personDetails.getPostOffice());
				person.setState(personDetails.getState());
				person = personRepository.save(person);
			}
		} catch (Exception e) {
			throw new Exception("Person Id not found in Data base");
		}
		return person;
	}

	/**
	 * This method for get person details based on id.
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Optional<PersonDetails> getBasedOnPersonId(int id) throws Exception {
		Optional<PersonDetails> personObj = personRepository.findById(id);
		if (personObj.isPresent()) {
			return personObj;
		} else {
			throw new Exception("Person Id not found in Data base");
		}
	}

	/**
	 * This method for get all person details.
	 * 
	 * @return
	 */
	public List<PersonDetails> getAllPersonDetails() {
		return personRepository.findAll();
	}

	/**
	 * This method for delete person detatils based on Id
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void delete(int id) throws Exception {
		Optional<PersonDetails> personObj = personRepository.findById(id);
		if (personObj.isPresent()) {
			personRepository.deleteById(id);
		} else {
			throw new Exception("Person Id not found in Data base");
		}
	}

}
