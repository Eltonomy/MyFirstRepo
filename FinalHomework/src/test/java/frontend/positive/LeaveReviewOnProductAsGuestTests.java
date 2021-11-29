package frontend.positive;

import adminarea.core.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.adminarea.ReviewsPage;
import pages.frontend.Cameras;


public class LeaveReviewOnProductAsGuestTests extends BaseTest {

    @Test
    public void reviewOnCamera() {
        Cameras.navigate();
        Cameras.chooseProduct();
        Cameras.writeOneReview();
        Cameras.verifyReviewSent();
        ReviewsPage.navigateToReviewsPage();
        ReviewsPage.enableAnExistingReview();
        ReviewsPage.logOut();
        Cameras.navigate();
        Cameras.chooseProduct();
        Cameras.verifyReviewPresent();
    }

    @AfterTest
    public void deleteTestReview(){
        ReviewsPage.navigateToReviewsPage();
        ReviewsPage.deleteAnExistingReview();
        ReviewsPage.logOut();
    }
}



