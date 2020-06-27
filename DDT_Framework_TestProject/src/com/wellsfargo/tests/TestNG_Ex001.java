package com.wellsfargo.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class TestNG_Ex001 {

	WebDriver driver;
	ChromeOptions settings;

	@Test(priority = 0)
	public void openURL() {

		try {
			driver.get("https://www.gmail.com");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void verifyTitle() {
		String validate = "Gmail";

		if (validate.contains("gmail")) {
			Reporter.log("HomePage Validation SUCCESS...!!", true);
		} else {
			Reporter.log("HomePage Validation FAILURE...!!", true);
		}
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/SatishKumarM/eclipse-workspace/MyProject_New/Sources/chromedriver.exe");

		settings = new ChromeOptions();
		settings.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		driver = new ChromeDriver(settings);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
