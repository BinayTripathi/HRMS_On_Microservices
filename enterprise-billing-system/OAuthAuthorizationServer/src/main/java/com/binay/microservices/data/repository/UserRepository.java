package com.binay.microservices.data.repository;

import org.springframework.data.repository.CrudRepository;
import com.binay.microservices.data.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	User findByName(String name);
}
