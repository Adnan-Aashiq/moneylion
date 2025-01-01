package tests.homepage;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.Learn;
import utils.BaseClass;

public class GuidanceVerification extends BaseClass {

	@Test(groups = {"Regression"})
	public void verifyGuidanceContent() throws InterruptedException {
		HomePage homepage = new HomePage(driver);
		Learn learn = new Learn(driver);
		
		homepage.clickOnGuidance();
		homepage.clickOnViewAllGuidance();
		learn.assertLearnPageUrl();
		
	}
}
