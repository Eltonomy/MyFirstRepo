package pages.adminarea;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static utils.Browser.driver;

public class ReviewsPage {

    public static void navigateToReviewsPage() {
        AdminLogin.navigate();
        AdminLogin.login("admin17", "parola123!");
        AdminDashboard.loadReviews();
    }

    public static void enableAnExistingReview() {
        driver.findElement(By.xpath("//td[text() = 'Some Name']"));
        driver.findElement(By.xpath("//td[text() = 'Some Name']/preceding-sibling::td/input")).click();
        driver.findElement(By.xpath("//td[text() = 'Some Name']//..//td/a")).click();
        Select dropdown = new Select(driver.findElement(By.id("input-status")));
        dropdown.selectByValue("1");
        driver.findElement(By.cssSelector("button.btn-primary")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText().contains("You have modified reviews!"));
    }

    public static void deleteAnExistingReview() throws NoSuchElementException {

        /**
         * Here we check if the review is there
         */
        try {
            driver.findElement(By.xpath("//td[text() = 'Some Name']"));
            driver.findElement(By.xpath("//td[text() = 'Some Name']/preceding-sibling::td/input")).click();
            driver.findElement(By.cssSelector("button.btn-danger")).click();
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

    public static void logOut() {
        driver.findElement(By.cssSelector("span.hidden-sm")).click();
    }


}
