package com.p2.driver.ordercontents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderContentsRepository extends JpaRepository<OrderContents, Integer>{

}