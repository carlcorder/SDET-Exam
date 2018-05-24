package com.xpanxion.training.java.selenium.core.pageobject.contact;

import com.xpanxion.training.java.selenium.core.pageobject.PageObject;
import com.xpanxion.training.java.selenium.core.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Collections;
import java.util.List;

/**
 * Created by ccorder on 2/16/2017.
 */
public class XpxnContactPage extends PageObject {

    public static final String BASE_URL = "http://www.xpanxion.com/contact/";
    public static final String SEND_BTN_XPATH = "//input[@value='Send']";
    public static final String CONTACT_FORM_ID = "wpcf7-f2460-o1";
    public static final String VALIDATION_SUMMARY_XPATH = "//div[contains(@class, 'validation-errors')]";
    public static final String VALIDATION_SUMMARY_COLOR = "rgb(255, 68, 68)";// #ff4444
    public static final String VALIDATION_TIP_XPATH = "//span[contains(@class, 'not-valid-tip')]";
    public static final String VALIDATION_TIP_COLOR = "rgb(255, 0, 0)";// #ff0000
    public static final String VALIDATION_TIP_TEXT = "The field is required.";

    @FindBy(how = How.XPATH, xpath = SEND_BTN_XPATH)
    private WebElement sendButton;

    @FindBy(how = How.ID, id = CONTACT_FORM_ID)
    private WebElement contactForm;

    /**
     * Clicks the send button and returns the validation summary element from the contact page.
     * @return web element representing the form validation summary
     */
    public WebElement getValidationSummaryFromContactForm() {
        submitForm();
        return contactForm != null ? contactForm.findElement(
                By.xpath(VALIDATION_SUMMARY_XPATH))
                    : null;
    }

    /**
     * Returns a list of validation tips found on the contact page. There is a validation tip
     * for name, email & phone. The validations are present after clicking the send button.
     * @return a list of web elements representing the form validation tips
     */
    public List<WebElement> getValidationTipsFromContactForm() {
        submitForm();
        return contactForm != null ? contactForm.findElements(
                By.xpath(VALIDATION_TIP_XPATH))
                    : Collections.<WebElement> emptyList();
    }

    /**
     * clicks the send button and waits for the contact form to be visible
     */
    private void submitForm() {
        sendButton.click();
        WaitUtils.waitUntilElementIsVisible(driver, contactForm);
    }

    public XpxnContactPage(WebDriver driver) {
        super(driver, BASE_URL);
    }

}