package com.p2.driver;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;




@RunWith(SpringRunner.class)
class MainDriverTest {
	


	@Test
	public void test() {
		MainDriver.main(new String[] {});
	//	String s = "running";
	//	assertEquals(s, "running");
	}

}
