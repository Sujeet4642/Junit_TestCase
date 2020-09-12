package testcases;

import org.junit.Test;
import org.openqa.selenium.interactions.ClickAction;

import core.Test_Base;
import pageObjects.CommonPageObject;
import pageObjects.HomePageObject;
import pageObjects.LogInPageObject;
import pageObjects.ProductDescrPageObject;
import pageObjects.SearchPageObject;
import pageObjects.ShoppingCartPageObject;
import pageObjects.CommonPageObject;

import org.junit.Assert;

public class TestCase1 extends Test_Base{
	
	 @Test
	public void t_01_check_PageTitle_Logo_TextBox() {
		driver.get(Base_url);
		HomePageObject homePageObject = new HomePageObject(driver);
		homePageObject.ValidateTitle(defaultPageTitle);
		homePageObject.ValidateAmazonLogo();
		homePageObject.ValidateTextBox();
		
	}

	 @Test
	public void t_02_Search_for_products_and_click()  {
		driver.get(Base_url);
		CommonPageObject commonPageObject = new CommonPageObject(driver);
		commonPageObject.Give_input_to_textbox();
		commonPageObject.Click_On_Search_Button();
		
		SearchPageObject searchPageObject = new SearchPageObject(driver);
		searchPageObject.validate_search_title("Amazon.in : earphone");
		searchPageObject.find_product_and_click("Amazon.in : earphone");
		
		ProductDescrPageObject productDescrPageObject = new ProductDescrPageObject(driver);
		productDescrPageObject.Validate_Cart_Buttn();
		productDescrPageObject.Validate_BuyNow_Bttn();
		productDescrPageObject.Validate_Quantity();
		productDescrPageObject.validate_price();
		
		ShoppingCartPageObject shopCartObj = new ShoppingCartPageObject(driver);
		shopCartObj.ClickOnCart();
		shopCartObj.Validate_ShoppingPageTitle("Amazon.in Shopping Cart");
		shopCartObj.Validate_CheckAddedToCartMsg();
		shopCartObj.AddedToCart();
		shopCartObj.ValidateProceedToButton();
		shopCartObj.ClickOnProceedButtn();
		
		LogInPageObject LoginObj = new LogInPageObject(driver);
		LoginObj.ValidatePageTitle("Amazon Sign In");
		LoginObj.CheckLogInPageIsDisplayed();
		LoginObj.CheckEmailInputBox();
		
	}
	

	
	
}
