package com.hcl.intranet.springboot2authserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.intranet.springboot2authserver.entity.Users;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<Users, Long> {

	Users findByUsername(String username);
	
	 Users save(Users users);

}


