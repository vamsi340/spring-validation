package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.PersonDetails;

public interface PersonRepository extends JpaRepository<PersonDetails, Integer> {

	@Query(value = "SELECT * FROM person_details WHERE person_id = ? AND active = true", nativeQuery = true)
	public Optional<PersonDetails> findById(int id);

	@Query(value = "SELECT * FROM person_details WHERE active = true order by person_id DESC", nativeQuery = true)
	public List<PersonDetails> findAll();
	
}
