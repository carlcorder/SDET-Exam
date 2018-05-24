package com.xpanxion.training.java.selenium.core.pageobject.home;

import com.xpanxion.training.java.selenium.core.pageobject.PageObject;
import com.xpanxion.training.java.selenium.core.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by ccorder on 2/15/2017.
 */
public class XpxnHomePage extends PageObject {

    public static final String BASE_URL = "http://www.xpanxion.com/";
    public static final String FOOTER_CONTAINER_CLASS = ".footer-container";
    public static final String SITE_NAV_ID = "site-navigation";
    public static final String HEADER_SELECTOR = "h2.header-text";

    @FindBy(how = How.ID, id = SITE_NAV_ID)
    private WebElement siteNav;

    @FindBy(how = How.CSS, css = FOOTER_CONTAINER_CLASS )
    private WebElement footerContainer;

    /**
     * Clicks a link by the given text and return a list of strings that contains the expected url and web element text
     * @param topNavText text to search on
     * @return a string of the text contained within the heading of the clicked to page
     */
    public String clickTopNavLinkAndGetHeading(String topNavText) {
        siteNav.findElement(By.linkText(topNavText)).click();
        WaitUtils.waitUntilElementIsLocated(driver, By.cssSelector(HEADER_SELECTOR));
        // find h2 on new page and return text content
        return driver.findElement(By.cssSelector(HEADER_SELECTOR)).getText();
    }

    /**
     * Clicks a footer with the given text within the footer container class
     * @param footerText the footer text
     * @return a string of the text contained within the heading of the clicked to page
     */
    public String clickFooterLinkAndGetHeading(String footerText) {
        footerContainer.findElement(By.linkText(footerText)).click();
        WaitUtils.waitUntilElementIsLocated(driver, By.cssSelector(HEADER_SELECTOR));
        // find h2 on new page and return text content
        return driver.findElement(By.cssSelector(HEADER_SELECTOR)).getText();
    }

    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    public XpxnHomePage(WebDriver driver) {
        super(driver, BASE_URL);
    }

}