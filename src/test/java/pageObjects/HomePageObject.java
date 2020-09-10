package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObject {

	private WebDriver driver;
	
	private By amazonLogo = By.xpath("//a[@class='nav-logo-link']");
	private By TextBox = By.id("twotabsearchtextbox");
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void ValidateTitle(String expectedTitle) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		boolean b = wait.until(ExpectedConditions.titleContains(expectedTitle));
		Assert.assertEquals("Title Validation", true, b);
	}
	
	public void ValidateAmazonLogo() {
		boolean b = driver.findElement(amazonLogo).isDisplayed();
		Assert.assertEquals("Amazon logo displayed" , true, b);
	}
	
	public void ValidateTextBox() {
		boolean b = driver.findElement(TextBox).isDisplayed();
		Assert.assertEquals("search Box displayed", true, b);
	}
	
	public void inputInTextBox(String text) {
		driver.findElement(TextBox).sendKeys(text);
	}
	
}

