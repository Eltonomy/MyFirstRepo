package pages.frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utils.Browser;

public class Cameras {
    public static void navigate () {
        Browser.driver.get("http://shop.pragmatic.bg/index.php?route=product/category&path=33");
    }

    public static void chooseProduct () {
        Browser.driver.findElement(By.cssSelector("div.product-thumb a img")).click();
    }
    public static void writeOneReview() {
        Actions action = new Actions(Browser.driver);
        WebElement product = Browser.driver.findElement(By.cssSelector("#content ul.nav a[href='#tab-review']"));
        action.moveToElement(product).click(product).perform();
        Browser.driver.findElement(By.id("input-name")).sendKeys("Some Name");
        Browser.driver.findElement(By.id("input-review")).sendKeys("Something good or bad about this product");
        Browser.driver.findElement(By.cssSelector("div.col-sm-12>input[name='rating']:nth-of-type(3)")).click();
        WebElement button = Browser.driver.findElement(By.id("button-review"));
        action.moveToElement(button).click(button).perform();
    }

    public static void verifyReviewSent() {
        String actualMessage = Browser.driver.findElement(By.cssSelector("div.alert-success")).getText();
        Assert.assertEquals(actualMessage, "Thank you for your review. It has been submitted to the webmaster for approval.");
    }
}
