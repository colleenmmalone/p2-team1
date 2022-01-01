package com.p2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p2.model.Logins;

public interface LoginsRepository  extends JpaRepository<Logins, Integer>{

}
