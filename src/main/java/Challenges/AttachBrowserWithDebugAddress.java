package Challenges;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class AttachBrowserWithDebugAddress {
	
	@Test
	public void browserPage() throws IOException {
		
		// Read from Property File
		FileInputStream input = new FileInputStream("./config.properties");
		
		Properties prop = new Properties();
		prop.load(input);
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions op = new ChromeOptions();
		op.setExperimentalOption("debuggerAddress", prop.getProperty("debugger"));
		
		ChromeDriver driver = new ChromeDriver(op);
		driver.findElementByLinkText("Create Lead").click();
		
		
		
	}
	
	
	

}

