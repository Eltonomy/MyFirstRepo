package pages.frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utils.Browser;

public class RegisterAccount {

    public static void navigate () {
        Browser.driver.get("https://shop.pragmatic.bg/index.php?route=account/register");
    }

    public static void register() {
        Browser.driver.findElement(By.id("input-firstname")).sendKeys("First");
        Browser.driver.findElement(By.id("input-lastname")).sendKeys("Last");
        Browser.driver.findElement(By.id("input-email")).sendKeys("test@test.bg");
        Browser.driver.findElement(By.id("input-telephone")).sendKeys("12345678");
        Browser.driver.findElement(By.id("input-password")).sendKeys("q1w2e3r4");
        Browser.driver.findElement(By.id("input-confirm")).sendKeys("q1w2e3r4");
        Browser.driver.findElement(By.cssSelector("input[name='agree']")).click();
        WebElement button = Browser.driver.findElement(By.cssSelector("input.btn-primary"));
        Actions action = new Actions(Browser.driver);
        action.moveToElement(button).click(button).perform();
    }

    public static void verifyNewRegistration() {
        String actualMessage = Browser.driver.findElement(By.cssSelector("h1")).getText();
        Assert.assertTrue(actualMessage.contains("Your Account Has Been Created!"));
    }

}
