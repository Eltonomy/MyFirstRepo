package frontend.positive;

import adminarea.core.BaseTest;
import org.testng.annotations.Test;
import pages.frontend.RegisterAccount;

public class NewCustomerRegistrationTests extends BaseTest {

    @Test
    public void registerNew() {
        RegisterAccount.navigate();
        RegisterAccount.register();
        RegisterAccount.verifyNewRegistration();
    }
}
