package pages.adminarea;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utils.Browser;

public class AdminProfile {
    public static void changeImage () {
        Browser.driver.findElement(By.id("thumb-image")).click();

        WebElement button = Browser.driver.findElement(By.id("button-image"));
        Actions action = new Actions(Browser.driver);
        action.moveToElement(button).perform();
        button.click();

        WebElement picture = Browser.driver.findElement(By.cssSelector("img[title='opencart-logo. png']"));
        action.moveToElement(picture).click(picture).perform();
        Browser.driver.findElement(By.cssSelector("div.pull-right button.btn.btn-primary")).click();
    }
    public static void verifyPictureChangedWithChosen () {
        String pictureSource = Browser.driver.findElement(By.id("user-profile")).getAttribute("src");
        Assert.assertEquals(pictureSource, "https://shop.pragmatic.bg/image/cache/catalog/opencart-logo-45x45.png");
        Assert.assertTrue(Browser.driver.findElement(By.cssSelector("div.container-fluid div.alert.alert-dismissible")).getText().contains("Success: You have modified your profile!"));
    }

    public static void changeImageBack() {
        Browser.driver.findElement(By.id("thumb-image")).click();

        WebElement button = Browser.driver.findElement(By.id("button-image"));
        Actions action = new Actions(Browser.driver);
        action.moveToElement(button).pause(500).click(button).perform();
        WebElement picture = Browser.driver.findElement(By.cssSelector("img[title='profile-pic.pn g']"));
        action.moveToElement(picture).click(picture).perform();
        Browser.driver.findElement(By.cssSelector("div.pull-right button.btn.btn-primary")).click();
        Assert.assertTrue(Browser.driver.findElement(By.cssSelector("div.container-fluid div.alert.alert-dismissible")).getText().contains("Success: You have modified your profile!"));
    }
}
