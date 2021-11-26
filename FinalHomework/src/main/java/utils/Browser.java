package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Browser {

    public static WebDriver driver;

    /**
     * Opens Chrome browser instance and sets Implicit wait for 10 seconds
     */
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "E:\\install\\BrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    /** Creates a wait to use in explicit waits wherever needed*/
    WebDriverWait wait = new WebDriverWait(driver, 15);
    /**
     * Quits the browser and all windows created
     */
    public static void quit() {
        driver.quit();
    }
}
