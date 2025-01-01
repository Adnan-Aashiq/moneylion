package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver = null;

	By footerLinkSection = By.xpath("//footer //section[3]");
	By careersLink = By.xpath("//a[@href='https://www.moneylion.com/careers/']");
	By productAndGuidanceButton = By.cssSelector("button[aria-describedby*=':R']"); 
	By viewAllProducts = By.xpath("//a[@href='https://www.moneylion.com/personal-finance-products-and-services/']");
	By viewAllGuidance = By.xpath("//a[@href='https://www.moneylion.com/learn']");
	By myBusiness = By.xpath("//a[@href='https://engine.tech/']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	
	public void goTofooter() {
		WebElement element = driver.findElement(footerLinkSection);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void clickCareersLink() throws InterruptedException {
		driver.findElement(careersLink).click();

	}
	
	public void clickOnProduct() {
		List<WebElement> elements = driver.findElements(productAndGuidanceButton);

		// Check if the list contains at least one element to avoid any IndexOutOfBoundsException
		if (!elements.isEmpty()) {
		    // Click the first element
		    elements.get(0).click();
		} else {
		    System.out.println("No elements found with the given cssSelector");
		}

	}

	public void clickOnViewAllProducts() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(viewAllProducts));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();

	}

	public void clickOnViewAllGuidance() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(viewAllGuidance));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();

	}
	
	public void clickOnGuidance() {
		List<WebElement> elements = driver.findElements(productAndGuidanceButton);

		// Check if the list contains at least one element to avoid any IndexOutOfBoundsException
		if (!elements.isEmpty()) {
		    // Click the first element
		    elements.get(1).click();
		} else {
		    System.out.println("No elements found with the given cssSelector");
		}
	}

	public void clickOnBusiness() throws InterruptedException {
		driver.findElement(myBusiness).click();
		Thread.sleep(5000);

	}

}
