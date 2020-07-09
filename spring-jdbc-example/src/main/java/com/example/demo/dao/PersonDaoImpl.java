package com.example.demo.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.PersonDto;
import com.example.demo.rowmapper.PersonMapper;

/**
 * 
 * @author vamsir
 *
 */
@Repository
public class PersonDaoImpl implements PersonDao {

	private final String SQL_FIND_PERSON = "SELECT * FROM person WHERE person_id = ?";
	private final String SQL_GET_ALL = "SELECT * FROM person order by person_id DESC";
	private final String SQL_DELETE_PERSON = "DELETE FROM person WHERE person_id= ?";
	private final String SQL_UPDATE_PERSON = "UPDATE person SET person_name = ? , person_age = ?, phone_number = ?, person_email = ?, person_state = ? , country = ? WHERE person_id = ?";
	private final String SQL_INSERT_PERSON = "INSERT INTO person(person_id, person_name, person_age, phone_number, person_email, person_state, country) values(?,?,?,?,?,?,?)";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void create(@Valid PersonDto personDetails) {

		jdbcTemplate.update(SQL_INSERT_PERSON, personDetails.getPersonId(), personDetails.getPersonName(),
				personDetails.getPersonAge(), personDetails.getPhoneNumber(), personDetails.getPersonEmail(),
				personDetails.getState(), personDetails.getCountry());

	}

	@Override
	public void update(@Valid PersonDto personDetails) {

		jdbcTemplate.update(SQL_UPDATE_PERSON, personDetails.getPersonName(), personDetails.getPersonAge(),
				personDetails.getPhoneNumber(), personDetails.getPersonEmail(), personDetails.getState(),
				personDetails.getCountry(), personDetails.getPersonId());
	}

	@Override
	public PersonDto getById(int id) {
		PersonDto person = jdbcTemplate.queryForObject(SQL_FIND_PERSON, new Object[] { id }, new PersonMapper());
		return person;
	}

	@Override
	public List<PersonDto> getAll() {
		List<PersonDto> person = jdbcTemplate.query(SQL_GET_ALL, new PersonMapper());
		return person;
	}

	@Override
	public void delete(int id) {
		jdbcTemplate.update(SQL_DELETE_PERSON, new Object[] { id });

	}

}
