package com.xpanxion.training.java.selenium.automation.home;

import com.xpanxion.training.java.selenium.core.basetest.TestNgBaseTest;
import com.xpanxion.training.java.selenium.core.pageobject.home.XpxnHomePage;
import com.xpanxion.training.java.selenium.core.services.CSVService;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by ccorder on 2/14/2017.
 */
public class XpxnTopNavLinksClickableTest extends TestNgBaseTest {

    private CSVService csvService = new CSVService();
    private XpxnHomePage xhp;

    @BeforeClass
    public void initializePageObject() {
        xhp = new XpxnHomePage(this.driver);
    }

    @DataProvider(name = "topNavLinks")
    public Object[][] getTestData() {
        String fileName = "xpxnHome/topNavLinks.csv";
        return csvService.readCsv(fileName);
    }

    /**
     * This test checks that each of the top navigation links redirect to the expected url and that the heading content
     * on the new page is correct.
     * @param navLinkText text within the navigation link <a href=..>navLinkText</a>
     * @param headerText text within the <h2 class="header-text">headerText</h2>
     */
    @Test(dataProvider = "topNavLinks")
    public void testTopNavLinksFunctional(String navLinkText, String headerText) {
        // click each of the top navigation links on the xpxn home page
        String h2Text = xhp.clickTopNavLinkAndGetHeading(navLinkText);
        // directed to correct url
        MatcherAssert.assertThat(xhp.getCurrentUrl(),
                Matchers.containsString(XpxnHomePage.BASE_URL + navLinkText.toLowerCase()));
        // page object contains correct header text
        MatcherAssert.assertThat(h2Text,
                Matchers.containsString(headerText));
    }

}