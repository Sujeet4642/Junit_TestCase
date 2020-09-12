package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;

public class LogInPageObject {
	
private WebDriver driver;

private By TextBox = By.id("ap_email");
private By CreateAccount = By.id("createAccountSubmit");

public LogInPageObject(WebDriver driver) {
	this.driver = driver;
}

public void ValidatePageTitle(String expected) {
	WebDriverWait wait = new WebDriverWait(driver,20);
	boolean b = wait.until(ExpectedConditions.titleContains(expected));
	Assert.assertEquals("LogInPageTitle", true, b);
}

public void CheckLogInPageIsDisplayed() {
	WebDriverWait wait2 = new WebDriverWait(driver,20);
	wait2.until(ExpectedConditions.elementToBeClickable(TextBox));
	boolean b = driver.findElement(CreateAccount).isDisplayed();
	Assert.assertEquals("Check LogInPage", true, b);
	
	
}

public void CheckEmailInputBox() {
	boolean b = driver.findElement(TextBox).isDisplayed();
	Assert.assertEquals("Validate Email box", true, b);
	
	}
}
