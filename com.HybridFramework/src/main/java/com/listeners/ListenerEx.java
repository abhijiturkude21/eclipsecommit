package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.model.Report;
import com.base.BaseClass;

public class ListenerEx extends BaseClass implements ITestListener{

	public void onFinish(ITestContext context) {
		log.info("test suite finished");
		report.flush();
		
	}

	public void onStart(ITestContext context) {
		
		log.info("test suite started");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onTestFailure(ITestResult result) {
		
		test.log(test.getStatus().FAIL, "testcase failed");
		log.info("test case failed with name"+result.getName());
		log.info("captured screenshot on test failed");
		test.addScreenCaptureFromPath(getScreenshot(result.getName()));
	}

	public void onTestSkipped(ITestResult result) {
		test.log(test.getStatus().SKIP, "testcase passed");
		log.info("test case skipped with name"+result.getName());
		
	}

	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
		log.info("extent report initiated");
	}

	public void onTestSuccess(ITestResult result) {
		test.log(test.getStatus().PASS, "testcase passed");
		log.info("test case passed with name"+result.getName());
	}

}
