package org.testng;

public class DataProviderListener implements IDataProviderListener {
	public void beforeDataProviderExecution(IDataProviderMethod dataProviderMethod, ITestNGMethod method,
			ITestContext iTestContext) {
		System.out.println(dataProviderMethod.getIndices());
	}

	public void afterDataProviderExecution(IDataProviderMethod dataProviderMethod, ITestNGMethod method,
			ITestContext iTestContext) {
	}
}
