package Prudvi.basetest;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import Prudvi.resource.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class Listeners extends Baseclass implements ITestListener {
	ExtentTest test;
	//ExtentReports extent= ExtentReporter.getReportObject();
	ExtentReports extent= ExtentReporter.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
		@Override
	    public void onTestStart(ITestResult result) {
			
			test=extent.createTest(result.getMethod().getMethodName());
			extentTest.set(test);
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	    	extentTest.get().log(Status.PASS, "Test Passed");
	    	
	    	
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	    	extentTest.get().fail(result.getThrowable());
	        try {
				driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    String filepath = null;
		try {
			filepath = getScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        System.out.println("Test Skipped: " + result.getName());
	       
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        System.out.println("Test Failed but within success percentage: " + result.getName());
	    }

	    @Override
	    public void onTestFailedWithTimeout(ITestResult result) {
	        System.out.println("Test Failed due to timeout: " + result.getName());
	        onTestFailure(result);  // usually call failure method
	    }

	    @Override
	    public void onStart(ITestContext context) {
	        System.out.println("Test Started: " + context.getName());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	       extent.flush();
	    }
	

	

}
