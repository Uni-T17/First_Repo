package com.kit.kat.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
	
	public List<User> findAll();
	public User findByName(String name);
	public void deleteByName(String name);
	

}
