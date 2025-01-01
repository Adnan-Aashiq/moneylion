package tests.homepage;

import org.testng.annotations.Test;

import pages.BusinessPage;
import pages.HomePage;
import utils.BaseClass;

public class MyBusiness extends BaseClass {

	@Test(groups = {"Regression"})
	public void verifyGuidanceContent() throws InterruptedException {
		HomePage homepage = new HomePage(driver);
		BusinessPage businesspage = new BusinessPage(driver);
		
		homepage.clickOnBusiness();
		businesspage.assertBusinessPageUrl();
		businesspage.closeBusinessTab();
	}
}
