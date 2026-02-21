package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (linkText="Alaska Winter Tours")
	private WebElement winterToursMenu;
	
	public WinterToursPage goToWinterToursPage() {
		winterToursMenu.click();
		return new WinterToursPage(driver);
	}

}
