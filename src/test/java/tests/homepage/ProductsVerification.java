package tests.homepage;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.PersonalFinanceProductsAndServices;
import utils.BaseClass;

public class ProductsVerification extends BaseClass {

	@Test(groups = {"Smoke"})
	public void verifyProductsContent() throws InterruptedException {
		HomePage homepage = new HomePage(driver);
		PersonalFinanceProductsAndServices personalfinanceproductsandservices = new PersonalFinanceProductsAndServices(driver);
		
		homepage.clickOnProduct();
		homepage.clickOnViewAllProducts();
		personalfinanceproductsandservices.assertPersonalFinanceProductsAndServicesPageUrl();
		
	}
	
	@Test(groups = {"Smoke"})
	public void creditbuilderapp() throws InterruptedException {
		HomePage homepage = new HomePage(driver);
		PersonalFinanceProductsAndServices personalfinanceproductsandservices = new PersonalFinanceProductsAndServices(driver);
		
		homepage.clickOnProduct();
		//click
		homepage.clickOnViewAllProducts();
		personalfinanceproductsandservices.assertPersonalFinanceProductsAndServicesPageUrl();
		
	}
	
	Actions actions = new Actions(driver);
	
}
