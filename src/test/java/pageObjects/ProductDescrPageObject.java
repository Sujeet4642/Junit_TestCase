package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.junit.Assert;

public class ProductDescrPageObject {
	
   private WebDriver driver;
   private By AddToCartBttn = By.id("add-to-cart-button");
   private By BuyNowBttn = By.id("buy-now-button");
   private By Quantity = By.xpath("//div[@class='a-column a-span12 a-text-left']//span[@class='a-dropdown-container']");
   private By PriceOfProduct = By.id("priceblock_ourprice");
   
   
   public ProductDescrPageObject(WebDriver driver) {
	   this.driver = driver;
   }

   public void Validate_Cart_Buttn() {
		 boolean  b = driver.findElement(AddToCartBttn).isDisplayed();
		 Assert.assertEquals("validate AddToCart", true, b);
   }
   
   public void Validate_BuyNow_Bttn(){
	  boolean b = driver.findElement(BuyNowBttn).isDisplayed();
	  Assert.assertEquals("validate BuyNow", true, b);
   }
   
   public void Validate_Quantity() {
	  boolean b = driver.findElement(Quantity).isDisplayed();
	  Assert.assertEquals("validate Quantity box", true, b);
   }	 
   
  public void validate_price() {
	 boolean b = driver.findElement(PriceOfProduct).isDisplayed();
	 Assert.assertEquals("validate Product Price", true, b);
		 } 
  
  public void ClickOnAddToCart() {
	  driver.findElement(AddToCartBttn).click(); 
  }
		 	
	   
   }
  
   

