package com.hipasserby.repository;

import com.hipasserby.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Integer> {



}
