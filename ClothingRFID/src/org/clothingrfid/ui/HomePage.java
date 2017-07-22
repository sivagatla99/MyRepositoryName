package org.clothingrfid.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	WebElement element;
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	public void waitForHomePageToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//Span[text()='Sivajee']"), "Sivajee"));
	}
	public boolean getTextforHomePage() {
		element = driver.findElement(By.xpath("//Span[text()='Sivajee']"));
		if (element!=null)
		return true;
		else 
			return false;
	}

}
