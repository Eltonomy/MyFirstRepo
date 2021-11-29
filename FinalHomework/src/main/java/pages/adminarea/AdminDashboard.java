package pages.adminarea;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Browser;

import static utils.Browser.driver;

public class AdminDashboard {


    /**
     * Asserts the heading in the Dashboard page that it
     * equals the provided as parameter text
     *
     * @param expectedDashboardHeadingText the expected dashboard heading text
     * @param messageOnTestFailure the message that will appear in your test reports in case of failure
     */
    public static void verifyDashboardHeadingText(String expectedDashboardHeadingText, String messageOnTestFailure) {
        String actualDashboardHeadingText = driver.findElement(By.cssSelector("div#content h1")).getText();

        Assert.assertEquals(actualDashboardHeadingText, expectedDashboardHeadingText, messageOnTestFailure);
    }
    public static void goToProfile () {
        driver.findElement(By.cssSelector("li.dropdown a.dropdown-toggle")).click();
        driver.findElement(By.cssSelector("ul.dropdown-menu li:first-of-type")).click();
    }

    public static void loadGiftVouchers() {
        driver.findElement(By.xpath("//li[@id='menu-sale']/a")).click();
        driver.findElement(By.xpath("//ul[@id='collapse4']/li/a[.='Gift Vouchers']")).click();
        driver.findElement(By.xpath("//ul[@id='collapse4-3']/li/a[.='Gift Vouchers']")).click();
    }

    public static void loadReviews() {
        driver.findElement(By.id("menu-catalog")).click();
        driver.findElement(By.xpath("//ul[@id='collapse1']/li/a[.='Reviews']")).click();
    }


}
