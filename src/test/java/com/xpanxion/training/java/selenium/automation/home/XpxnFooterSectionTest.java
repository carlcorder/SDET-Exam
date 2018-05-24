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
 * Created by ccorder on 2/15/2017.
 */
public class XpxnFooterSectionTest extends TestNgBaseTest {

    private CSVService csvService = new CSVService();
    private XpxnHomePage xhp;

    @BeforeClass
    public void initializePageObject() {
        xhp = new XpxnHomePage(this.driver);
    }

    @DataProvider(name = "footerBlockLinks")
    public Object[][] getTestData() {
        String fileName = "xpxnHome/footerBlockLinks.csv";
        return csvService.readCsv(fileName);
    }

    /**
     * This test checks that each of the footer links redirect to the expected url and that the heading content
     * on the new page is correct.
     * @param footerText text within the navigation link <..footer-blocks><a href=..>footerText</a></..footer-blocks>
     * @param urlPath url of the navigated page
     * @param headerText text within the <h2 class="header-text">headerText</h2>
     */
    @Test(dataProvider = "footerBlockLinks")
    public void testFooterAboutLinksFunctional(String footerText, String urlPath, String headerText) {
        // click each of the footer block links under the 'About' section on the xpxn home page object
        String h2Text = xhp.clickFooterLinkAndGetHeading(footerText);
        // directed to correct url
        MatcherAssert.assertThat(xhp.getCurrentUrl(),
                Matchers.containsString(XpxnHomePage.BASE_URL + urlPath));
        // page object contains correct header text
        MatcherAssert.assertThat(h2Text,
                Matchers.containsString(headerText));
    }

}
