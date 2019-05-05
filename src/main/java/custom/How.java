package custom;

import java.io.Serializable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class How{

	/**
	 * @param seleniumId The value of the "seleniumId" attribute to search for.
	 * @return A By which locates elements by the value of the "seleniumId" attribute.
	 */
	public static By seleniumId(String seleniumId) {
		if (seleniumId == null) {
			throw new IllegalArgumentException("Cannot find elements when the For is null.");
		}
		return new BySeleniumId(seleniumId);
	}

	public static class BySeleniumId extends By implements Serializable{

		private static final long serialVersionUID = 1L;


		public String altLctrValue;

		public BySeleniumId(String altLctrValue){
			this.altLctrValue = altLctrValue;
		}

		@Override
		public List<WebElement> findElements(SearchContext context) {
			List<WebElement> altElements = context.findElements(By.xpath("//*[@for='"+altLctrValue+"']"));
			return altElements;
		}

		@Override
		public WebElement findElement(SearchContext context) {
			WebElement altElements = context.findElement(By.xpath("//*[@for='"+altLctrValue+"']"));
			return altElements;
		}
	}
}