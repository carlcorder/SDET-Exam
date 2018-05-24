package com.xpanxion.training.java.selenium.core.basetest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is the main testing class. Extend this class from a test class to
 * create a WebDriver object and gain access to it to use for testing.
 */
public class JUnitBaseTest {

	public static final Logger LOG = LoggerFactory.getLogger(JUnitBaseTest.class);

	/**
	 * The WebDriver object for use in testing. Since the scope is protected,
	 * the object will be available to all sub-classes.
	 */
	protected WebDriver driver;

	/**
	 * This method is executed before a test method begins, using JUnit's @Before
	 * annotation. This method is primarily responsible for obtaining a unique
	 * WebDriver object for the test to use.
	 */
	@Before
	public void setup() {
		LOG.debug("Initializing WebDriver...");
		this.driver = new FirefoxDriver();
		LOG.debug("Finished initializing WebDriver!");
	}

	/**
	 * This method is executed after a test method has completed, using JUnit's @After
	 * annotation. This method is primarily responsible for taking care of all
	 * clean up tasks, so that more tests may be run.
	 */
	@After
	public void teardown() {
		LOG.debug("Tearing down WebDriver...");
		this.driver.quit();
		LOG.debug("Finished tearing down WebDriver!");
	}
}
