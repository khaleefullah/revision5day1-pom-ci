package tests;

import java.util.Hashtable;

import org.testng.annotations.Test;

import base.BaseTest;
import core.DriverFactory;
import dataprovider.TestDataProvider;
import pages.HomePage;
import pages.SummerToursPage;

public class SummerToursTest extends BaseTest {

	HomePage homePage;
	SummerToursPage summerToursPage;
	
	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "dp")
	public void summerToursTest(Hashtable<String, String> data){

		homePage = new HomePage(DriverFactory.getDriver());
		summerToursPage = homePage.goToSummerToursPage();
		summerToursPage
			.enterName(data.get("Name"))
			.enterEmail(data.get("Email"))
			.enterPhone(data.get("Phone"))
			.enterMessage(data.get("Message"));
	}

}
