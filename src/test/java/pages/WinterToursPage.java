package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WinterToursPage extends BasePage {

	public WinterToursPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "field_qh4icy4")
	private WebElement nameField;

	@FindBy(id = "field_29yf4d4")
	private WebElement emailField;

	@FindBy(id = "field_e5nnt")
	private WebElement phoneField;

	@FindBy(id = "field_9jv0r13")
	private WebElement messageField;

	public WinterToursPage enterName(String name) {
		nameField.sendKeys(name);
		return this;
	}

	public WinterToursPage enterEmail(String email) {
		emailField.sendKeys(email);
		return this;
	}

	public WinterToursPage enterPhone(String phone) {
		phoneField.sendKeys(phone);
		return this;
	}

	public WinterToursPage enterMessage(String message) {
		messageField.sendKeys(message);
		return this;
	}

}
