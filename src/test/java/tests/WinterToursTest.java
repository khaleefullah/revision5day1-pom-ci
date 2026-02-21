package tests;

import base.BaseTest;
import core.DriverFactory;
import dataprovider.TestDataProvider;
import pages.HomePage;
import pages.WinterToursPage;

import java.util.Hashtable;

import org.testng.annotations.*;

public class WinterToursTest extends BaseTest{
	
	HomePage homePage;
	WinterToursPage winterToursPage;
	
	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "dp")
	public void winterToursTest(Hashtable<String, String> data) {
		homePage = new HomePage(DriverFactory.getDriver());
		homePage.goToWinterToursPage()
			.enterName(data.get("Name"))
			.enterEmail(data.get("Email"))
			.enterPhone(data.get("Phone"))
			.enterMessage(data.get("Message"));		
	}

}
