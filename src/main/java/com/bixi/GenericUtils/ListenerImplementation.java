package com.bixi.GenericUtils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) // STEP : 2
	{
		// Starting of the report
		String MethodName = result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		Reporter.log(MethodName+"---->Testscript execution starts from here<----");
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"--> PASSED");
		Reporter.log(MethodName+"---->Test Script Executed Successfully<----");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String FS = result.getMethod().getMethodName();
		String FScript = FS+ new JavaUtlis().systemDateInFormat();
		test.addScreenCaptureFromPath(FScript); //to capture screen-shot and set the path
		
		try {
			WebDriverUtils.getScreenshot(BaseClass.sdriver, FScript);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, FScript+"---> FAILED");
		Reporter.log(FScript+"---->Test-Script execution Failed<----");
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"--SKIPPED");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+"---->Test-Script execution Skipped<----");
	}

	@Override
	public void onStart(ITestContext context) // STEP : 1
	{
		//It is used to create/ configure the report
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("SDET-52");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("Bixi");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("url", "http://rmgtestingserver/domain/Online_Banking_System");
		report.setSystemInfo("Reporter Name", "Md Neyaz Ahmed");
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		//consolidate the report/ clean older report
		report.flush();
	}
	
}
