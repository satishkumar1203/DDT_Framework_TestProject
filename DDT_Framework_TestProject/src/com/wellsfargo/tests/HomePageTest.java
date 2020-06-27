package com.wellsfargo.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wellsfargo.pages.HomePage;

import util.TestUtil;

public class HomePageTest extends TestUtil {
	WebElement element;

	@Test(priority = 0)
	public void openURL() {
		try {
			driver.get(prop.getProperty("url"));
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void validateHomePage() {
		String currURL = driver.getCurrentUrl();

		if (currURL.contains("wellsfargo")) {
			Reporter.log("HomePage Validation SUCCESS...!!", true);
		} else {
			Reporter.log("HomePage Validation FAILURE...!!", true);
		}
	}

	@Test(priority = 2)
	public void verifyLogin() {
		try {
			Thread.sleep(2000);

			System.out.println("Company = " + eElement.getElementsByTagName("company").item(0).getTextContent());
			driver.findElement(HomePage.company)
					.sendKeys(eElement.getElementsByTagName("company").item(0).getTextContent());
			Thread.sleep(2000);

			System.out.println("User Name = " + eElement.getElementsByTagName("userName").item(0).getTextContent());
			driver.findElement(HomePage.userName)
					.sendKeys(eElement.getElementsByTagName("userName").item(0).getTextContent());
			Thread.sleep(2000);

			System.out.println("User Name = " + eElement.getElementsByTagName("password").item(0).getTextContent());
			driver.findElement(HomePage.password)
					.sendKeys(eElement.getElementsByTagName("password").item(0).getTextContent());
			Thread.sleep(2000);

			element = driver.findElement(HomePage.submitBtn);
			WebDriverWait explicitWait = new WebDriverWait(driver, 10);
			explicitWait.until(ExpectedConditions.visibilityOf(element));

			
			element.click();
			Thread.sleep(2000);

			if (driver.getCurrentUrl().contains("SIGNON_SYSTEM_ERROR") || driver.getCurrentUrl().contains("failure")) {
				Reporter.log("Invalid Logon Validation - SUCCESS", true);
			} else {
				Reporter.log("Invalid Logon Validation - FALIED", true);
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@BeforeClass
	public void beforeClass() {
		Reporter.log("************************ Home Page Test Class Execution - STARTS ************************", true);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
		Reporter.log("************************ Home Page Test Class Execution - ENDS ************************", true);
	}

}
