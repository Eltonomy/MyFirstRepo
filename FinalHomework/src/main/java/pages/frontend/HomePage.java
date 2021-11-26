package pages.frontend;


import utils.Browser;

public class HomePage {
    public static void loadHomePage () {
        Browser.driver.get("http://shop.pragmatic.bg/");
    }
}
