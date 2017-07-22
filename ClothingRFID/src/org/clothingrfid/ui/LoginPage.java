package org.clothingrfid.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	WebElement element;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void waitForLoginPage()
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("facebook")));
	}
	public WebElement getLoginTextBox() {
		element = driver.findElement(By.id("email"));
		return element;
	}
	public WebElement getPWDTextBox() {
		element = driver.findElement(By.id("pass"));
		return element;
	}
	public WebElement getLoginButton() {
		element = driver.findElement(By.id("u_0_r"));
		return element;
	}

}
