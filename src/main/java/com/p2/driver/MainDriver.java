package com.p2.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.p2.driver.logins.LoginsService;

@SpringBootApplication
public class MainDriver {

		public static void main(String[] args) {
			SpringApplication.run(MainDriver.class, args);
		}
}
