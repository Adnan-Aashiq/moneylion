package tests.careerpage;
import pages.CareersPage;
import pages.HomePage;
import utils.BaseClass;
import org.testng.annotations.Test;

public class OpenRolesOfficeLocationsVerification extends BaseClass {

    @Test(groups = {"Sanity"})
    public void verifyOpenRolesLocationFilter() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        CareersPage careersPage = new CareersPage(driver);

        homePage.goTofooter();
        homePage.clickCareersLink();
        careersPage.assertCareersPageUrl();
        careersPage.goToOpenRolesSection();
        careersPage.selectDepartment();
        careersPage.selectOfficeLocation();
        careersPage.clickOnViewOpenings();
        careersPage.assertOpenRolesOfficeLocations();
    }
}
