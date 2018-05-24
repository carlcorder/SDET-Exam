package com.xpanxion.training.java.selenium.automation.sample;

import com.xpanxion.training.java.selenium.core.basetest.JUnitBaseTest;
import com.xpanxion.training.java.selenium.core.utils.WaitUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * FIXME This test will not run unless you update the DRIVER & DRIVER_PATH for your specific machine.
 */
public class SampleTest extends JUnitBaseTest {

	public static final Logger LOG = LoggerFactory.getLogger(SampleTest.class);

	private static final String ACCESS = "file:///";
	private static final String TEST_HTML = "/src/test/resources/sample/helloWorld.html";

	private static final String DRIVER = "webdriver.gecko.driver";
	private static final String DRIVER_PATH = "C:/Users/ccorder/gecko-driver/geckodriver-v0.14.0-win64/geckodriver.exe";

	@BeforeClass
	public static void setGeckoDriver() {
		System.setProperty(DRIVER, DRIVER_PATH);
	}

	@Test
	public void test() throws IOException {
		LOG.info("Hello World!");
		driver.get(ACCESS + new File(".").getCanonicalPath() + TEST_HTML);
		WaitUtils.hardWait(5000);
	}

}
