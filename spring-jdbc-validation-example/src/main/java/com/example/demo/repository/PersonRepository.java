package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.demo.dto.PersonDto;

public interface PersonRepository{

	public PersonDto findById(int id);

	public List<PersonDto> findAll();

	public void save(@Valid PersonDto personDetails);

	public void deleteById(int id);
	
}
