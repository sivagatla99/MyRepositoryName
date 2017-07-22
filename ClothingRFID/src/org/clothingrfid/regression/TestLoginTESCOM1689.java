package org.clothingrfid.regression;

import java.io.IOException;

import org.clothingrfid.config.CreateWebDriver;
import org.clothingrfid.ui.HomePage;
import org.clothingrfid.ui.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class TestLoginTESCOM1689 {
	
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
	public void testLoginTC001() {
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
	public void testInvalidLoginTC002() {
		login.waitForLoginPage();
		login.getLoginTextBox().sendKeys("sivajee.g1@gmail.com");
		login.getPWDTextBox().sendKeys("SivaKavi");
		login.getLoginButton().click();

	
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
