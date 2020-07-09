package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
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
	
	private final String INSERT_QUERY = "INSERT INTO person(person_id, person_name, person_age, phone_number, person_email, person_state, country) "
			+ "values(:id, :name, :age, :phoneNumber, :email, :state, :country)";
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public void create(@Valid PersonDto personDetails) {

		//jdbcTemplate
		jdbcTemplate.update(SQL_INSERT_PERSON, personDetails.getPersonId(), personDetails.getPersonName(),
				personDetails.getPersonAge(), personDetails.getPhoneNumber(), personDetails.getPersonEmail(),
				personDetails.getState(), personDetails.getCountry());
		
		//NamedParameterJdbcTemplate
		Map<String, Object> parameter = new HashMap<>();
		parameter.put("id", personDetails.getPersonId());
		parameter.put("name", personDetails.getPersonName());
		parameter.put("age", personDetails.getPersonAge());
		parameter.put("phoneNumber", personDetails.getPhoneNumber());
		parameter.put("email", personDetails.getPersonEmail());
		parameter.put("state", personDetails.getState());
		parameter.put("country", personDetails.getCountry());
		SqlParameterSource namedParameter = new MapSqlParameterSource(parameter);
		int result =namedParameterJdbcTemplate.update(INSERT_QUERY, namedParameter);
		if(result>0) {
			System.out.println("Person Details inserted in Data Base....");
		}
	}

	@Override
	public void update(@Valid PersonDto personDetails) {

		jdbcTemplate.update(SQL_UPDATE_PERSON, personDetails.getPersonName(), personDetails.getPersonAge(),
				personDetails.getPhoneNumber(), personDetails.getPersonEmail(), personDetails.getState(),
				personDetails.getCountry(), personDetails.getPersonId());
	}

	@Override
	public PersonDto getById(int id) {
		//JdbcTemplate
		PersonDto person = jdbcTemplate.queryForObject(SQL_FIND_PERSON, new Object[] {id}, new PersonMapper());
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
