package com.project.one.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.one.model.Person;

@Repository
@Transactional
public interface PersonRepository extends JpaRepository<Person, Integer> {
	Person findByUsername(String username);
}
