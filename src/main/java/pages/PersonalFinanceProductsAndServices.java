package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PersonalFinanceProductsAndServices {
	WebDriver driver;
	
	public PersonalFinanceProductsAndServices(WebDriver driver) {
		this.driver = driver;
	}
	
	public void assertPersonalFinanceProductsAndServicesPageUrl() throws InterruptedException {
		String currentUrl = driver.getCurrentUrl();
    	System.out.println("Current URL: " + currentUrl);
    	Assert.assertTrue(currentUrl.contains("personal-finance-products-and-services"), "The URL does not contain 'personal-finance-products-and-services'.");
    }
}
