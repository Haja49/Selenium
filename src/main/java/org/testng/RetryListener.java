package org.testng;

public class RetryListener implements IRetryAnalyzer{
	int retryLimit = 1;

	public boolean retry(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE && retryLimit<=3) {			
			try {
				Thread.sleep(2000);
				System.out.println(String.format(""+result.getMethod(), result.getName()));
				retryLimit++;
				return true;				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
		return false;
	}
}
