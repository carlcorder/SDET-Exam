package com.xpanxion.training.java.selenium.core.basetest;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by ccorder on 2/17/2017.
 */
public class TestNgBaseTest {

    public static final Logger LOG = LoggerFactory.getLogger(TestNgBaseTest.class);
    protected WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        LOG.debug("initializing Webdriver...");
        FirefoxDriverManager.getInstance().version("0.14.0").setup();
        driver = new FirefoxDriver();
//        ChromeDriverManager.getInstance().setup();
//        driver = new ChromeDriver();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        LOG.debug("tearing down Webdriver...");
        driver.quit();
    }

}
