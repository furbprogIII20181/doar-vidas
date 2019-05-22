package com.furb.br.doarvidas.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.furb.br.doarvidas.model.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {

	Optional<Person> findById(Integer id);
	
}
