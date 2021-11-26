package pages.adminarea;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import static utils.Browser.driver;

/** This class contains all the methods to take place on Gift Vouchers page*/
public class GiftVouchersPage {
    /**
     * This method is used to clear an existing gift voucher with the same code, created beforehand
     * @throws NoSuchElementException when we try to delete a voucher which is not there
     */
    public static void clearOld() throws NoSuchElementException {
        /**
         * Here we check if the gift voucher is there
         */
        try {
            driver.findElement(By.xpath("//td[text() = 'MyGift']"));
            driver.findElement(By.xpath("//td[text() = 'MyGift']/preceding-sibling::td/input")).click();
            driver.findElement(By.cssSelector(" button.btn-danger")).click();
        } catch (NoSuchElementException e1) {
            e1.printStackTrace();
        }
        /**
         * Here we check if an alert appears after clicking the delete button
         */
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    /**
     * This is where we create the new gift voucher
     */
    public static void createNew() {
        driver.findElement(By.cssSelector("a.btn-primary")).click();
        driver.findElement(By.id("input-code")).sendKeys("MyGift");
        driver.findElement(By.id("input-from-name")).sendKeys("mum");
        driver.findElement(By.id("input-from-email")).sendKeys("mytest@test.bg");
        driver.findElement(By.id("input-to-name")).sendKeys("mimi");
        driver.findElement(By.id("input-to-email")).sendKeys("maya_elt@yahoo.com");
        driver.findElement(By.id("input-amount")).sendKeys("200");
        driver.findElement(By.cssSelector("button.btn-primary")).click();
    }

    /**
     * Here we verify the voucher was successfully created
     * by checking the success message AND the presence of the new voucher code/name
     */
    public static void verifyThereIsNewVoucher() {

        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-success")).getText().contains("You have modified vouchers!"));
        Assert.assertTrue(driver.findElement(By.xpath("//td[text()='MyGift']")).isDisplayed());
    }

    /**
     * This is used to make sure next time we attempt to log in there is no already-logged-in problem
     */
    public static void logOut() {
        driver.findElement(By.cssSelector("span.hidden-sm")).click();
    }
}
