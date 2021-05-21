package com.project.one;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.one.model.Person;
import com.project.one.model.Role;
import com.project.one.repository.PersonRepository;
import com.project.one.repository.RoleRepository;


@SpringBootApplication
public class OneApplication {
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(OneApplication.class, args);
	}
	
	@EventListener
	private void runSeeder(ContextRefreshedEvent event) {
		PersonRepository personRepository = context.getBean(PersonRepository.class);
		RoleRepository roleRepository = context.getBean(RoleRepository.class);

		
		Role admin = new Role(1, "Admin");
		roleRepository.save(admin);

		Person p1 = new Person(1, "Admin", encoder.encode("admin"), Map.of("Admin", admin));
		personRepository.save(p1);
	}
}
