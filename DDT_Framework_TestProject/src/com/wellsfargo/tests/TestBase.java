/*Test Base class (TestBase.java) deals with all the common functions used by all the pages. 
This class is responsible for loading the configurations from properties files, Initializing the WebDriver, Implicit Waits, 
Extent Reports and also to create the object of FileInputStream which is responsible for pointing towards the file from 
which the data should be read.*/

package com.wellsfargo.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Reporter;

public class TestBase {
	protected Properties prop;
	FileInputStream fis;
	protected WebDriver driver;
	ChromeOptions settings;

	public TestBase() {

		try {
			prop = new Properties();
			fis = new FileInputStream(
					"C:\\Users\\Satish Kumar M\\eclipse-workspace\\DDT_Framework_TestProject\\Configuration\\config.properties");

			// Load Properties file...
			prop.load(fis);

			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriver"));

			settings = new ChromeOptions();
			settings.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			driver = new ChromeDriver(settings);
			driver.manage().window().maximize();

			Reporter.log("************************ Test Base Class Execution - SUCCESS ************************", true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
