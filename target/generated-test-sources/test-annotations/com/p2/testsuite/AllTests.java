package com.p2.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.p2.driver.MainDriverTest;
import com.p2.model.LoginsTest;

@RunWith(Suite.class)
@SuiteClasses({
	LoginsTest.class,
	MainDriverTest.class
})
public class AllTests {

}
