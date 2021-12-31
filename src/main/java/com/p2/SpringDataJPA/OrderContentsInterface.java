package com.p2.SpringDataJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.p2.model.OrderContents;

@Repository
public interface OrderContentsInterface extends JpaRepository<OrderContents, Integer>{

	OrderContents findByOrderID(int orderID);
	
}
