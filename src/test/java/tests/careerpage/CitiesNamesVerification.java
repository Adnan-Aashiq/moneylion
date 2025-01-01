package tests.careerpage;
import pages.CareersPage;
import pages.HomePage;
import utils.BaseClass;
import org.testng.annotations.Test;

public class CitiesNamesVerification extends BaseClass {

    @Test(groups = {"Smoke"})
    public void verifyCitiesOnCareersPage() throws InterruptedException {
    	
        HomePage homePage = new HomePage(driver);
        CareersPage careersPage = new CareersPage(driver);
        
        homePage.goTofooter();
        homePage.clickCareersLink();
        careersPage.assertCareersPageUrl();
        careersPage.goTowhereWeWorkSection();
        careersPage.assertCityNames();
    }
}
