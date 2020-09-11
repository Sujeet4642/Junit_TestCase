package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;

public class SearchPageObject {

	private WebDriver driver;
	private By BoatBassHeads = By.xpath("//span[text()='boAt BassHeads 100 in-Ear Wired Earphones with Super Extra Bass, in-line Mic, Hawk Inspired Design and Perfect Length Cable (Black)']");
	
	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void validate_search_title(String expectedTitle) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		boolean b = wait.until(ExpectedConditions.titleContains(expectedTitle));
		Assert.assertEquals("Search Title Validation", true, b);
		
	}
	
	public void find_product_and_click(String expectedTitle) {
		
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.titleContains(expectedTitle));
		String searchTitle = driver.getTitle();
		Assert.assertEquals("Match Search Title", expectedTitle, searchTitle);
		
		driver.findElement(BoatBassHeads).click();
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> It = handles.iterator();
		String ParentWindowId = It.next();
		String childWindowId = It.next();
		driver.switchTo().window(childWindowId);
		
		WebDriverWait wait2 = new WebDriverWait(driver,20);
		String expected = "boAt BassHeads 100 in-Ear Wired Earphones with Super: Amazon.in: Electronics";
		String actual = driver.getTitle();
		wait2.until(ExpectedConditions.titleContains(expected));
		Assert.assertEquals(expected, actual);
		
	}
		
}	

