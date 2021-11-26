package pages.adminarea;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Browser;

public class AdminDashboard {


    /**
     * Asserts the heading in the Dashboard page that it
     * equals the provided as parameter text
     *
     * @param expectedDashboardHeadingText the expected dashboard heading text
     * @param messageOnTestFailure the message that will appear in your test reports in case of failure
     */
    public static void verifyDashboardHeadingText(String expectedDashboardHeadingText, String messageOnTestFailure) {
        String actualDashboardHeadingText = Browser.driver.findElement(By.cssSelector("div#content h1")).getText();

        Assert.assertEquals(actualDashboardHeadingText, expectedDashboardHeadingText, messageOnTestFailure);
    }
    public static void goToProfile () {
        Browser.driver.findElement(By.cssSelector("li.dropdown a.dropdown-toggle")).click();
        Browser.driver.findElement(By.cssSelector("ul.dropdown-menu li:first-of-type")).click();
    }

    public static void loadGiftVouchers() {
        Browser.driver.findElement(By.xpath("//li[@id='menu-sale']/a")).click();
        Browser.driver.findElement(By.xpath("//ul[@id='collapse4']/li/a[.='Gift Vouchers']")).click();
        Browser.driver.findElement(By.xpath("//ul[@id='collapse4-3']/li/a[.='Gift Vouchers']")).click();

    }
}
