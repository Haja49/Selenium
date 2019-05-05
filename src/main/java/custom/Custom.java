package custom;

import org.openqa.selenium.By;

public enum Custom {
	Selenium_Id {
		public By buildBy(String value) {
			return How.seleniumId(value);
		}
	};
	public abstract By buildBy(String value);
}
