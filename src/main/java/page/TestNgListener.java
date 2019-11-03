package page;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListener implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test has started" + " "+ result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test is successfull" + " "+ result.getName());
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Fail" + " "+ result.getName());
	}
	

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test onTestSkipped" + " "+ result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test onTestFailedButWithinSuccessPercentage" + " "+ result.getName());
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test onStart" + " "+ context.getName());
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test onFinish" + " "+ context.getName());
		
	}

}
