package com.xpanxion.training.java.selenium.automation.contact;

import com.xpanxion.training.java.selenium.core.basetest.TestNgBaseTest;
import com.xpanxion.training.java.selenium.core.pageobject.contact.XpxnContactPage;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by ccorder on 2/16/2017.
 */
public class XpxnContactSubmitErrorTest extends TestNgBaseTest {

    private XpxnContactPage xcp;

    @BeforeClass
    public void initializePageObject() {
        xcp = new XpxnContactPage(this.driver);
    }

    /**
     * Test checks that an error summary element is displayed on the contact us page when the form is
     * submitted with an empty field for name, email or phone.
     */
    @Test
    public void testErrorSummaryOnEmptyContactSubmit() {
        // click send button on contact form and get validation summary
        WebElement errorSummary = xcp.getValidationSummaryFromContactForm();
        // error text in validation summary
        assertThat(errorSummary.getText(), is(notNullValue()));
        // proper color
        MatcherAssert.assertThat(errorSummary.getCssValue("border-top-color"),
                Matchers.equalToIgnoringCase(XpxnContactPage.VALIDATION_SUMMARY_COLOR));
    }

    /**
     * Test checks that a validation error tool tip is displayed under each form field when empty form is submitted.
     */
    @Test void testErrorValidationTipsOnEmptyContactSubmit() {
        // click send button on contact form and get validation tips
        List<WebElement> validationTips = xcp.getValidationTipsFromContactForm();
        // validation tips for name, email, phone
        assertThat(validationTips.size(), is(equalTo(3)));
        // validation tips have the correct message & color
        for(WebElement tip : validationTips) {
            MatcherAssert.assertThat(tip.getText(),
                    Matchers.equalTo(XpxnContactPage.VALIDATION_TIP_TEXT));
            MatcherAssert.assertThat(tip.getCssValue("color"),
                    Matchers.equalTo(XpxnContactPage.VALIDATION_TIP_COLOR));
        }
    }

}
