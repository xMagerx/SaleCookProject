package ua.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.entity.Costs;


public interface CostsRepository extends JpaRepository<Costs, Integer>{


//	void Filter(String timeproduction,int complexityPay);
}
