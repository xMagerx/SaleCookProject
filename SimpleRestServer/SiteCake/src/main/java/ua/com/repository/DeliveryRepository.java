package ua.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.entity.Delivery;


public interface DeliveryRepository extends JpaRepository<Delivery, Integer>{


//	void Filter(String delivery);
}
