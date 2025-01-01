package pages;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.time.Duration;

public class CareersPage {
	WebDriver driver = null;

	By whereWeWorkSection = By.id("OurTeamWhereWeWork");
	By citiesNames = By.xpath("//figcaption");
	By openRolesSection = By.id("OpenRoles");
	By department = By.xpath("//select[@class='department-filter']");
	By officeLocation = By.xpath("//select[@class='office-filter']");
	By viewOpenings = By.xpath("//div[@class='department-single']");
	By locations = By.xpath("//div[@class='jobs'] //p[@class='job-location']");
	
	String departmentName = "Data Engineering";
	String officeLocationName = "Kuala Lumpur, Kuala Lumpur, Malaysia";

	public CareersPage(WebDriver driver) {
		this.driver = driver;
	}

	// Common wait method
    private WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(10));  // Set the wait time once here
    }
    
	public void assertCareersPageUrl() throws InterruptedException {
		Thread.sleep(5000);
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL: " + currentUrl);
		Assert.assertTrue(currentUrl.contains("careers"), "The URL does not contain 'careers'.");

	}
	
	public List<String> getCitiesFromJson() {
		List<String> cities = new ArrayList<>();
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("src/test/resources/cities.json")) {
			JSONObject obj = (JSONObject) jsonParser.parse(reader);
			JSONArray citiesArray = (JSONArray) obj.get("cities");

			for (Object city : citiesArray) {
				cities.add(city.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cities;
	}

	public void goTowhereWeWorkSection() {
		WebElement element = driver.findElement(whereWeWorkSection);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void assertCityNames() throws InterruptedException {
		List<WebElement> cityElements = driver.findElements(citiesNames);
		List<String> expectedCities = getCitiesFromJson();

		for (int i = 0; i < cityElements.size(); i++) {
			String actualCity = cityElements.get(i).getText().trim().toLowerCase();
			String expectedCity = expectedCities.get(i).trim().toLowerCase();
			Assert.assertEquals(actualCity, expectedCity, "City name does not match!");
		}
		Thread.sleep(3000);

	}

    public void goToOpenRolesSection() throws InterruptedException {
        WebElement element = getWait().until(ExpectedConditions.visibilityOfElementLocated(openRolesSection));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(3000);
    }

    public void selectDepartment() throws InterruptedException {
        WebElement departmentElement = getWait().until(ExpectedConditions.visibilityOfElementLocated(department));
        Select departmentDropdown = new Select(departmentElement);
        departmentDropdown.selectByVisibleText(departmentName);
        Thread.sleep(1500);
    }

    public void selectOfficeLocation() throws InterruptedException {
        WebElement officeLocationElement = getWait().until(ExpectedConditions.visibilityOfElementLocated(officeLocation));
        Select officeLocationDropdown = new Select(officeLocationElement);
        officeLocationDropdown.selectByVisibleText(officeLocationName);
        Thread.sleep(1500);
    }

    public void clickOnViewOpenings() throws InterruptedException {
        WebElement viewOpeningsElement = getWait().until(ExpectedConditions.elementToBeClickable(viewOpenings));
        viewOpeningsElement.click();
        Thread.sleep(3000);
    }

    public void assertOpenRolesOfficeLocations() throws InterruptedException {
        List<WebElement> officelocations = getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locations));
        for (WebElement location : officelocations) {
            Assert.assertEquals(location.getText().trim(), "Kuala Lumpur, Kuala Lumpur, Malaysia", "Location does not match expected value.");
        }
    }
}
