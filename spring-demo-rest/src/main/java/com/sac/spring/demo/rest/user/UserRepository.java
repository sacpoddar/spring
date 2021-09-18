package com.sac.spring.demo.rest.user;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	// translates into the following query: 
	// select u from User u where u.email = ?1 and u.name = ?2
	List<User> findByEmailAndName(String email, String name);
	
	// uses named query. See User.java
	//	@NamedQuery(name = "User.findByEmailAddress",
	//			query = "select u from User u where u.email = ?1")
	User findByEmailAddress(String email);
	
	// @Query("select u from User u where u.email = ?1")		// JPQL
	@Query( value = "select * from User u where u.email = ?1",	// JPQL Native
			nativeQuery = true)
	User findByEmailAddress2(String email);
}
