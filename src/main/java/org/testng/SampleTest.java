package org.testng;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.testng.Listeners.class)
public class SampleTest {
	@Test(successPercentage=50)
	public void test() {
		int i=5;
		boolean a ;
		if(i==5) {
			a=true;
		} else {
			a =false;
		}
		Assert.assertEquals(false, a);
		
	}
}
