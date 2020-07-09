package com.example.demo.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.dto.PersonDto;

/**
 * 
 * @author vamsir
 *
 */
public class PersonMapper implements RowMapper<PersonDto> {

	@Override
	public PersonDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		PersonDto person = new PersonDto();
		person.setPersonId(rs.getInt("person_id"));
		person.setPersonName(rs.getString("person_name"));
		person.setPersonAge(rs.getInt("person_age"));
		person.setPhoneNumber(rs.getString("phone_number"));
		person.setPersonEmail(rs.getString("person_email"));
		person.setCountry(rs.getString("country"));
		person.setState(rs.getString("person_state"));
		return person;
	}

}
