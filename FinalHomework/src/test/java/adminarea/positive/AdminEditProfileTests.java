package adminarea.positive;

import adminarea.core.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.adminarea.AdminDashboard;
import pages.adminarea.AdminLogin;
import pages.adminarea.AdminProfile;

public class AdminEditProfileTests extends BaseTest {

    @BeforeMethod
    public void loginAsAdmin() {
        AdminLogin.navigate();
        AdminLogin.login("admin", "parola123!");
    }

    @Test
    public void changeProfilePhoto () {
        AdminDashboard.goToProfile();
        AdminProfile.changeImage();
        AdminProfile.verifyPictureChangedWithChosen();
    }
    @AfterTest
    public void getAllBackToNormal () {
        AdminDashboard.goToProfile();
        AdminProfile.changeImageBack();
    }
}
