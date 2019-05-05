package custom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class CustomPage {
	WebDriver driver = new ChromeDriver();
	public CustomPage() {
		PageFactory.initElements(driver, this);
	}
	
	@Find(by=Custom.Selenium_Id, using="username")
	WebElement ele;
	public void enterUserName() {
		
	}
}
