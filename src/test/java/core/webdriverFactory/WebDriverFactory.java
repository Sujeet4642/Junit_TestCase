package core.webdriverFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

	private static WebDriver driver = null;
	public static WebDriver getWebDriverForBrowser(String browserName) throws Exception{
		
		switch(browserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
			default:
				throw new Exception("No such browser is implemented.Browser name sent: " + browserName);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		}
	}

