package com.example.demo.dao;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.dto.PersonDto;

/**
 * 
 * @author vamsir
 *
 */
public interface PersonDao {
	//Save Person Detatils
	void create(@Valid PersonDto personDetails);
	//Update Person Details
	void update(@Valid PersonDto personDetails);
	//Get Person Details Based on Id
	PersonDto getById(int id);
	//Get all person Details
	List<PersonDto> getAll();
	//Delete Person Details Based on Id
	void delete(int id);

}
