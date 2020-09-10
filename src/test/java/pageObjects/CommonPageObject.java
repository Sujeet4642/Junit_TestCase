package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonPageObject {

	private WebDriver driver;
	
	
	private By searchButton = By.xpath("//input[@value='Go']");
	
	public CommonPageObject(WebDriver driver){
		this.driver = driver;
	}
	
	public void Give_input_to_textbox() {
		HomePageObject home = new HomePageObject(driver);
		home.inputInTextBox("earphone");
		
	}
	
	public void Click_On_Search_Button() {
		driver.findElement(searchButton).click();
	}
}
