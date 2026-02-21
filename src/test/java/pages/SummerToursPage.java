package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class SummerToursPage extends BasePage {

	public SummerToursPage(WebDriver driver) {
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

	public SummerToursPage enterName(String name) {
		nameField.sendKeys(name);
		return this;
	}

	public SummerToursPage enterEmail(String email) {
		emailField.sendKeys(email);
		return this;
	}

	public SummerToursPage enterPhone(String phone) {
		phoneField.sendKeys(phone);
		return this;
	}

	public SummerToursPage enterMessage(String message) {
		messageField.sendKeys(message);
		return this;
	}

}
