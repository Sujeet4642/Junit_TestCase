package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;

public class ShoppingCartPageObject {

	private WebDriver driver;
	private By AddedToCartMsg = By.id("huc-v2-order-row-items-msg");
	private By AddedToCart = By.id("nav-cart-count");
	private By ProceedToBuy = By.id("hlb-ptc-btn-native");
	
	public ShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void ClickOnCart() {
		ProductDescrPageObject obj = new ProductDescrPageObject(driver);
		obj.ClickOnAddToCart();
	}
	
	public void Validate_ShoppingPageTitle(String expectedTitle) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		boolean b = wait.until(ExpectedConditions.titleContains(expectedTitle));
		Assert.assertEquals("Title Validation", true, b);
	}
	
	public void Validate_CheckAddedToCartMsg() {
		boolean b = driver.findElement(AddedToCartMsg).isDisplayed();
		Assert.assertEquals("Added To Cart Msg Displayed", true, b);
		
		/*String expected = "Amazon.in Shopping Cart";
		String actual = driver.getTitle();
		WebDriverWait wait1 = new WebDriverWait(driver,20);
		wait1.until(ExpectedConditions.titleContains(expected));
		Assert.assertEquals("Title Shopping Page", expected, actual);*/
	}
	
	public void AddedToCart() {
		boolean b = driver.findElement(AddedToCart).isDisplayed();
		Assert.assertEquals("one product is added", true, b);	
		
	}
	public void ValidateProceedToButton() {
		boolean b = driver.findElement(ProceedToBuy).isDisplayed();
		Assert.assertEquals("ProccedToButton", true, b);
	}
	
	public void ClickOnProceedButtn() {
		driver.findElement(ProceedToBuy).click();
		
		String expected = "Amazon Sign In";
		WebDriverWait wait2 = new WebDriverWait(driver,20);
		wait2.until(ExpectedConditions.titleContains(expected));
		Assert.assertEquals("LogIn Page Title", expected, driver.getTitle());
	}
}
