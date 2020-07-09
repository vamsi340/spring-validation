package com.example.demo.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.dto.PersonDto;

public class PersonMapper implements RowMapper<PersonDto> {

	@Override
	public PersonDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		PersonDto person = new PersonDto();
		person.setActive(rs.getBoolean("active"));
		person.setCity(rs.getString("city"));
		person.setCountry(rs.getString("country"));
		person.setCreateDate(rs.getDate("create_date"));
		person.setCreatedBy(rs.getString("created_by"));
		person.setDoorNumber(rs.getString("door_number"));
		person.setMandal(rs.getString("mandal"));
		person.setModifiedBy(rs.getString("modified_by"));
		person.setModifiedDate(rs.getDate("modified_date"));
		person.setPersonAge(rs.getInt("person_age"));
		person.setPersonEmail(rs.getString("person_email"));
		person.setPersonId(rs.getInt("person_id"));
		person.setPersonName(rs.getString("person_name"));
		person.setPhoneNumber(rs.getString("phone_number"));
		person.setPinCode(rs.getString("pin_code"));
		person.setPostOffice(rs.getString("post_office"));
		person.setState(rs.getString("person_state"));
		
		return person;
	}

}
