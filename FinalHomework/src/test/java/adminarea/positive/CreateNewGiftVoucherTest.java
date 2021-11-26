package adminarea.positive;

import adminarea.core.BaseTest;
import org.testng.annotations.Test;
import pages.adminarea.AdminDashboard;
import pages.adminarea.AdminLogin;
import pages.adminarea.GiftVouchersPage;


public class CreateNewGiftVoucherTest extends BaseTest {

    @Test
    public void successfulNewVoucher() {
        AdminLogin.navigate();
        AdminLogin.login("admin17", "parola123!");
        AdminDashboard.loadGiftVouchers();
        GiftVouchersPage.clearOld();
        GiftVouchersPage.createNew();
        GiftVouchersPage.verifyThereIsNewVoucher();
        GiftVouchersPage.logOut();
    }
}
