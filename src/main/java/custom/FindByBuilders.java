package custom;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;

public abstract class FindByBuilders{

	protected By buildByFromShortFind(Find find) {

		if (!"".equals(find.seleniumId())) {
			return How.seleniumId(find.seleniumId());
		}

		// Fall through
		return null;
	}

	protected By buildByFromLongFind(Find find) {
		return find.by().buildBy(find.using());
	}

	protected void assertValidFind(Find find) {
		if (find.by() != null) {
			if (find.using() == null) {
				throw new IllegalArgumentException(
						"If you set the 'how' property, you must also set 'using'");
			}
		}

		Set<String> finders = new HashSet<>();
		if (!"".equals(find.using())) finders.add("how: " + find.using());
		if (!"".equals(find.seleniumId())) finders.add("selenium id:" + find.seleniumId());

		if (finders.size() > 1) {
			throw new IllegalArgumentException(
					String.format("You must specify at most one location strategy. Number found: %d (%s)",
							finders.size(), finders.toString()));
		}
	}
}
