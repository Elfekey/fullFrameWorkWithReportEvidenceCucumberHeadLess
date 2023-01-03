package Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Tests.BaseTest;

public class Listener extends BaseTest implements ITestListener {

//	if we want to use this listener in the suite we have to add the below under suite 
	/*
<listeners>
<listener class-name="Utilities.Listener"></listener>
</listeners>
*/
	
	

	//object from extent report calss
	//below is an object from the parent base test   "report" from extent report class
	//	ExtentReports extent = extentReport.setUpExtent();
//	ExtentTest test;
	//#######below we are using thread safe to keep every instance of the test and not override them!!!
	public static ThreadLocal<ExtentTest> extentTesThreadLocal = new  ThreadLocal<ExtentTest>();
	//	//starting test afeter thread safe done inside extent report
	@Override
	public void onTestStart(ITestResult result) {
//		extentReport.test = extentReport.extent.createTest(result.getMethod().getMethodName() + "_" +result.getMethod().getDescription());
//		extentTesThreadLocal.set(extentReport.test);
		reportOb.test = extentReport.extent.createTest(result.getMethod().getMethodName() + "_" +result.getMethod().getDescription());
		extentTesThreadLocal.set(reportOb.test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTesThreadLocal.get().log(Status.PASS, result.getMethod().getMethodName()+"  :  "+"Passed");
		//				report.InsertAllImagesToTheReport(result.getName(),result.getMethod().getDescription(),"Passed");
		//				extent.flush();
		//				report.refreshReport();

	}

	@Override
	public void onTestFailure(ITestResult result) {
		//		test.fail(result.getThrowable());
		extentTesThreadLocal.get().fail(result.getThrowable());	

	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub


		extentReport.extent.flush();
		reportOb.refreshReport();

	}

}
