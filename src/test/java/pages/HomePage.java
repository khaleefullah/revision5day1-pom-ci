package pages;

import base.BasePage;
import core.Config;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (linkText="Alaska Winter Tours")
	private WebElement winterToursMenu;
	
	public WinterToursPage goToWinterToursPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Config.getTimeout()));
		wait.until(ExpectedConditions.elementToBeClickable(winterToursMenu)).click();
		return new WinterToursPage(driver);
	}

}
