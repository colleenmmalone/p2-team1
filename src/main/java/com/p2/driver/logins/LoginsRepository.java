package com.p2.driver.logins;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.p2.driver.ordercontents.OrderContents;

@Repository
public interface LoginsRepository extends JpaRepository<Logins, Integer>{

}