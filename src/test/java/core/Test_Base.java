package core;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import core.webdriverFactory.WebDriverFactory;
import org.junit.After;
import org.junit.Assert;

public class Test_Base {
protected WebDriver driver;
protected final static String Base_url= "https://amazon.in";
protected final static String defaultPageTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

private String getBrowserName() {
	String browserDefault = "chrome";
	String browserSentFromCmd = System.getProperty("browserName");
	if(browserSentFromCmd==null) {
		return browserDefault;
	}
	else {
		return browserSentFromCmd; 
	}
}

@Before
public void setup() {
String browserName = getBrowserName();
try {
	driver = WebDriverFactory.getWebDriverForBrowser(browserName);
} catch (Exception e) {
	e.getStackTrace();
	Assert.fail("Browser Initialization failed. Check the Stack Trace."+e.getMessage());
}
}

@After
public void cleanUp() {
	driver.quit();
}


}
