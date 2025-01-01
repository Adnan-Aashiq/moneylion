package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BusinessPage {
    WebDriver driver = null;
    
    String firstTab;
    String secondTab;
    
    public BusinessPage(WebDriver driver) {
        this.driver = driver;
        getTabHandles(); 
    }
    
    public void getTabHandles() {
    	Set<String> allTabs = driver.getWindowHandles();
        Iterator<String> iterator = allTabs.iterator();
        
        if (iterator.hasNext()) {
            firstTab = iterator.next();
        }
        if (iterator.hasNext()) {
            secondTab = iterator.next();
        }
    }
    
    public void assertBusinessPageUrl() throws InterruptedException {
    	getTabHandles();
    	Thread.sleep(3000);
        driver.switchTo().window(secondTab); 
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Second Tab URL: " + currentUrl);
        
        Assert.assertTrue(currentUrl.contains("engine.tech"), "The URL does not contain 'engine.tech'.");
        
    }
    
    public void closeBusinessTab() throws InterruptedException {
    	driver.close(); 
        driver.switchTo().window(firstTab); 
        Thread.sleep(3000);
    }
}
