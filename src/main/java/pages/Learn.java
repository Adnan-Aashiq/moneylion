package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Learn {
	WebDriver driver;
	
	public Learn(WebDriver driver) {
		this.driver = driver;
	}
	
	public void assertLearnPageUrl() throws InterruptedException {
		String currentUrl = driver.getCurrentUrl();
    	System.out.println("Current URL: " + currentUrl);
    	Assert.assertTrue(currentUrl.contains("learn"), "The URL does not contain 'learn'.");
    }
}
