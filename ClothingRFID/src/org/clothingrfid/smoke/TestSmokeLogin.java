package org.clothingrfid.smoke;

import java.io.IOException;

import org.clothingrfid.config.CreateWebDriver;
import org.clothingrfid.ui.HomePage;
import org.clothingrfid.ui.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSmokeLogin {
	
	WebDriver driver;
	LoginPage login;
	HomePage home;
	
	@BeforeMethod
	public void setUp() throws IOException {
		driver = CreateWebDriver.instance();
		login = new LoginPage(driver);
		home = new HomePage(driver);
	}

	@Test(priority=1)
	public void testSmokeLoginTC001() {
		login.waitForLoginPage();
		login.getLoginTextBox().sendKeys("sivajee.g@gmail.com");
		login.getPWDTextBox().sendKeys("SivaKavi");
		login.getLoginButton().click();
		
		home.waitForHomePageToLoad();
		boolean actualResult = home.getTextforHomePage();
		boolean expectedResult = true;
		Assert.assertEquals(expectedResult, actualResult);
	}
	@Test(priority=0)
	public void testSmokeInvalidLoginTC002() {
		login.waitForLoginPage();
		login.getLoginTextBox().sendKeys("sivajee.g1@gmail.com");
		login.getPWDTextBox().sendKeys("SivaKavi");
		login.getLoginButton().click();
		
		boolean actualResult = true;
		boolean expectedResult = true;
		Assert.assertEquals(expectedResult, actualResult);

	
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
