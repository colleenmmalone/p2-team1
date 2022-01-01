package com.p2.driver.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderContentRepository extends JpaRepository<OrderContents, Integer>{

}