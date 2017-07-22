package org.clothingrfid.config;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.clothingrfid.utils.GetData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateWebDriver {
	public static WebDriver instance() throws IOException {
		
		WebDriver driver = null;
		
		String browsername = GetData.fromProperties("configuration", "browser");
		String url = GetData.fromProperties("configuration", "url");
		Integer timeouts = new Integer(GetData.fromProperties("configuration", "timeouts"));
		
		if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "F:\\Practice\\JAVA\\Softwares\\FireFox_Exe\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\Practice\\JAVA\\Softwares\\Chrome_exe\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else
		{
			System.err.println("Improper browser for Selenium");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeouts, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
		
	}
}

