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

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void create(@Valid PersonDto personDetails) {
		
		String query = "INSERT INTO person VALUES('" + personDetails.getPersonId() + "','" + personDetails.getPersonName()
				+ "','" + personDetails.getPersonAge() + "','" + personDetails.getPhoneNumber() + "','"
				+ personDetails.getPersonEmail() + "','" + personDetails.getState() + "','" + personDetails.getCountry()
				+ "')";
		
		jdbcTemplate.update(query);
	}

	@Override
	public void update(@Valid PersonDto personDetails) {

		String query = "UPDATE person SET person_name='" + personDetails.getPersonName() + "',person_age='"
				+ personDetails.getPersonAge() + "' ,phone_number = '" + personDetails.getPhoneNumber()
				+ "', person_email = '" + personDetails.getPersonEmail() + "',person_state = '"
				+ personDetails.getState() + "', country = '" + personDetails.getCountry() + "'  WHERE person_id='"
				+ personDetails.getPersonId() + "' ";
		jdbcTemplate.update(query);
	}

	@Override
	public PersonDto getById(int id) {
		String sql = "SELECT * FROM person WHERE person_id='" + id + "'";
		PersonDto person = jdbcTemplate.queryForObject(sql,new PersonMapper());
		return person;
	}

	@Override
	public List<PersonDto> getAll() {
		String Sql = "SELECT * FROM person order by person_id DESC";
		List<PersonDto> person = jdbcTemplate.query(Sql, new PersonMapper());
		return person;
	}

	@Override
	public void delete(int id) {
		 String query="DELETE FROM person WHERE person_id='"+id+"' ";  
		   jdbcTemplate.update(query);  

	}

}
