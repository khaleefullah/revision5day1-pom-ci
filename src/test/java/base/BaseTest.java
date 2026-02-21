package base;

import core.Config;
import core.DriverFactory;
import org.testng.annotations.*;


public class BaseTest {

	@BeforeMethod
	public void setup() {
		DriverFactory.initDriver();
		DriverFactory.getDriver().get(Config.getBaseUrl());
	}

	@AfterMethod
	public void teardown() {
		DriverFactory.quitDriver();
	}

}
