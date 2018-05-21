package com.hipasserby.repository;

import com.hipasserby.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface UserRepository extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User>{
	User findByEmail(String email);
}
