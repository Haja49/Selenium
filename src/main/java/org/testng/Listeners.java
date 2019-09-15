package org.testng;

public class Listeners implements ITestListener{

	// Invoked each time before a test will be invoked
	public void onTestStart(ITestResult result) {
		
	}

	// Invoked each time when a test is success
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	// Invoked each time when a test is failed
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("test failed");
	}

	//Invoked each time when a test is skiped
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	//Invoked each time when a test fails but has been annotated with successPercentage 
	//and this failure still keeps it within the success percentage requested
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	//Invoked after the test class is instantiated and before any configuration method is called
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	//Invoked after the test class have run and their configuration method been called
	public void onFinish(ITestContext context) {
		ITestNGMethod[] allTestMethods = context.getAllTestMethods();
		for (ITestNGMethod iTestNGMethod : allTestMethods) {
			System.out.println(iTestNGMethod.getSuccessPercentage());
		}
		System.out.println("test complete");
	}
	
}
