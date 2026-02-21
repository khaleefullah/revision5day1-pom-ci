package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import java.net.URL;

public class DriverManager {

	public static WebDriver createDriver() {
		
		String browser = Config.getBrowser();

		switch (browser.toLowerCase()) {
		
		case "chrome":
			
			ChromeOptions chromeOptions = new ChromeOptions();
			if (Config.isHeadless()) {
				chromeOptions.addArguments("--headless=new");
			}
			if (Config.getExecutionMode().equalsIgnoreCase("remote") ) {
				return createRemoteDriver(chromeOptions);
			}
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver(chromeOptions);

		case "firefox":
			
			FirefoxOptions firefoxOptions = new FirefoxOptions();

			if (Config.isHeadless() == true) {
				firefoxOptions.addArguments("--headless=new");
			}

			if (Config.getExecutionMode().equalsIgnoreCase("remote")) {
				return createRemoteDriver(firefoxOptions);
			}

			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver(firefoxOptions);

		case "edge":
			
			EdgeOptions edgeOptions = new EdgeOptions();

			if (Config.isHeadless() == true) {
				edgeOptions.addArguments("--headless=new");
			}
			if (Config.getExecutionMode().equalsIgnoreCase("remote")) {
				return createRemoteDriver(edgeOptions);
			}
			WebDriverManager.edgedriver().setup();
			return new EdgeDriver(edgeOptions);
		
		default:
			
			throw new IllegalArgumentException("Invalid browser passed : "+browser);
		}
	}

	public static WebDriver createRemoteDriver(Object options) {

		try {
			return new RemoteWebDriver(new URL(Config.getGridUrl()), (org.openqa.selenium.Capabilities) options);

		} catch (Exception e) {
			throw new RuntimeException("Failed to create Remote WebDriver", e);
		}

	}
}
