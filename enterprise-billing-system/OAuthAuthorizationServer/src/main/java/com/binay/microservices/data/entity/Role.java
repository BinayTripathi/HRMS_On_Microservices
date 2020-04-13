package com.binay.microservices.data.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Role implements GrantedAuthority{

	@Id
	private Integer id;
	
	@NonNull
	private String name;
	@ManyToMany(mappedBy = "roles")
	Set<User> users;

	@Override
	public String getAuthority() {
		return name;
	}

}
