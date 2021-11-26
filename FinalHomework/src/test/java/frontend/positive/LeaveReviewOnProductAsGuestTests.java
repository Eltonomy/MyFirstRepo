package frontend.positive;

import adminarea.core.BaseTest;
import org.testng.annotations.Test;
import pages.frontend.Cameras;

@Test
public class LeaveReviewOnProductAsGuestTests extends BaseTest {
    public void reviewOnCamera() {
       Cameras.navigate();
       Cameras.chooseProduct();
       Cameras.writeOneReview();
       Cameras.verifyReviewSent();
    }

 }
