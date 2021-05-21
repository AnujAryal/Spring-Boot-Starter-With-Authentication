package com.project.one.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.one.model.Role;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, String> {

}