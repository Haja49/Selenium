package custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactoryFinder;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
@PageFactoryFinder(FindBy.FindByBuilder.class)
public @interface Find {
	Custom by() default Custom.Selenium_Id;

	String using() default "";

	String seleniumId() default "";

	public static class FindByBuilder extends FindByBuilders {
		public By buildIt(Object annotation, Field field) {
			Find find = (Find) annotation;
			assertValidFind(find);

			By ans = buildByFromShortFind(find);
			if (ans == null) {
				ans = buildByFromLongFind(find);
			}

			return ans;
		}
	}
}
