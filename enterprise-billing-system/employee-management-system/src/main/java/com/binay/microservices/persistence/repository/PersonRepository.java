package com.binay.microservices.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.binay.microservices.persistence.entity.IEmployee;
import com.binay.microservices.persistence.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	@Query("Select p from Person p where name like :nameLike")
	List<Person> selectByNameLike(@Param("nameLike")String nameWildChar);  /*To be used for dropdown suggestion from the UserInterface*/

}
