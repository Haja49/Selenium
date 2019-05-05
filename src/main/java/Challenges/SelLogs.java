package Challenges;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.Test;

public class SelLogs {

	@Test
	public void logs() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions op = new ChromeOptions();

		LoggingPreferences lp = new LoggingPreferences();
		lp.enable(LogType.DRIVER, Level.ALL);
		op.setCapability(CapabilityType.LOGGING_PREFS, lp);

		ChromeDriver driver = new ChromeDriver();
		Logs logs = driver.manage().logs();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		Set<String> availableLogTypes = logs.getAvailableLogTypes();
		for (String eachTy : availableLogTypes) {
			System.out.println(eachTy);
		}
		WebElement firstLinkEle = driver.findElementByLinkText("Go to Home Page");
		firstLinkEle.click();
		LogEntries logEntries = driver.manage().logs().get("driver");
		for (LogEntry logEntry : logEntries) {
			System.out.println(logEntry.getMessage());
			System.out.println(logEntry.getTimestamp());
		}
	}

}
