package com.example.demo.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.PersonDto;
import com.example.demo.rowmapper.PersonMapper;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

	private final String INSERT_SQL = "INSERT INTO person_details "
			+ " VALUES (:person_id, :person_name, :person_age, :phone_number, :person_email, :person_state, :country, :pin_code, :post_office, :door_number, :mandal, :city, :create_date, :modified_date, :created_by, :modified_by, :active)";
	
	private final String FETCH_SQL = "SELECT * FROM person_details WHERE active = true order by person_id DESC";

	private final String FETCH_SQL_BY_ID = "SELECT * FROM person_details WHERE person_id = :id AND active = true";
	
	private final String DELETE_SQL_BY_ID = "DELETE FROM person_details WHERE person_id= :id AND active = true";
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public PersonDto findById(int id) {
		Map<String, Integer> parameters = new HashMap<>();
		parameters.put("id", id);
		PersonDto  person =  namedParameterJdbcTemplate.queryForObject(FETCH_SQL_BY_ID, parameters, new PersonMapper());
		return person;
	}
	
	@Override
	public List<PersonDto> findAll() {
		List<PersonDto> person = namedParameterJdbcTemplate.query(FETCH_SQL, new PersonMapper());
		return person;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void save(@Valid PersonDto personDetails) {
		
		Map<String, Object> parameters = new HashMap<String, Object>();
	    parameters.put("active", personDetails.getActive());
	    parameters.put("city", personDetails.getCity());
	    parameters.put("country", personDetails.getCountry());
	    parameters.put("create_date", personDetails.getCreateDate());
	    parameters.put("door_number", personDetails.getDoorNumber());
	    parameters.put("mandal", personDetails.getMandal());
	    parameters.put("created_by", personDetails.getCreatedBy());
	    parameters.put("modified_by", personDetails.getModifiedBy());
	    parameters.put("modified_date", personDetails.getModifiedDate());
	    parameters.put("person_age", personDetails.getPersonAge());
	    parameters.put("person_email", personDetails.getPersonEmail());
	    parameters.put("person_id", personDetails.getPersonId());
	    parameters.put("person_name", personDetails.getPersonName());
	    parameters.put("phone_number", personDetails.getPhoneNumber());
	    parameters.put("pin_code", personDetails.getPinCode());
	    parameters.put("post_office", personDetails.getPostOffice());
	    parameters.put("person_state", personDetails.getState());

		namedParameterJdbcTemplate.execute(INSERT_SQL, parameters, new PreparedStatementCallback() {
			@Override
			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				return ps.executeUpdate();
			}
		});
	}

	@Override
	public void deleteById(int id) {
		Map<String, Integer> parameters = new HashMap<>();
		parameters.put("id", id);
		namedParameterJdbcTemplate.update(DELETE_SQL_BY_ID, parameters);

	}

}
