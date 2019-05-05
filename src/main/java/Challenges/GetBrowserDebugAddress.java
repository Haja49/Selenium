package Challenges;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class GetBrowserDebugAddress {

	@Test
	public void browserPage() throws IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions op = new ChromeOptions();
		// op.addArguments("--start-maximized");
		// op.addArguments("--window-position=100,600");
		ChromeDriver driver = new ChromeDriver(op);
		// driver.manage().window().maximize();
		
		// Launch the URL
		driver.get("http://leaftaps.com/opentaps/");
		
		// Get the Google ChromeOptions
		Object capability = driver.getCapabilities().getCapability("goog:chromeOptions");	// moz:firefoxOptions
		@SuppressWarnings("unchecked")
		Map<String, Object> cap = (Map<String, Object>) capability;
		
		// Debugger Address
		Object object = cap.get("debuggerAddress");
		System.out.println(object.toString());
		
		// Write to a property file
		OutputStream output = new FileOutputStream("./config.properties");
		
		// Set the Debugger address
		Properties prop = new Properties();
		prop.setProperty("debugger", object.toString());
		prop.store(output, null);
		
		
		//Login
		WebElement userName = driver.findElementById("username");
		userName.sendKeys("DemoSalesManager", Keys.TAB);
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		String title = driver.getTitle();
		System.out.println(title);
		String version = driver.getCapabilities().getVersion();
		System.out.println(version);

	}

}
