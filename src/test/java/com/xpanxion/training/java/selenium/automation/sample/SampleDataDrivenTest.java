package com.xpanxion.training.java.selenium.automation.sample;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(JUnitParamsRunner.class)
public class SampleDataDrivenTest /* extends JUnitBaseTest */ {

	public static final Logger LOG = LoggerFactory.getLogger(SampleDataDrivenTest.class);

	@Test
	@FileParameters("src/test/resources/sample/animals.csv")
	public void testWithFileParameters(String animal, int num) {
		LOG.info("Number of {}(s): {}", animal, num);
	}

	@Test
	@Parameters({"tapir, 5", "capybara, 1"})
	public void testWithAnnotationParameters(String animal, int num) {
		LOG.info("Number of {}(s): {}", animal, num);
	}

}
