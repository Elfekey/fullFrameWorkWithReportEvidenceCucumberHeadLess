package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.WebDriverEventListenerClass;
import Utilities.WordDocumentEvidence;
import Utilities.extentReport;
import Utilities.screenShots;
import io.cucumber.core.backend.Options;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest   {
	public   WebDriver driver;
	public  WebDriverWait wait;

	//event listener
	WebDriverEventListenerClass webDriverEventListener ;
	public   EventFiringWebDriver  eDriver;
	public String tCName ;
	public  String tCDescription;	


	protected WordDocumentEvidence wordDocumentEvidence;
	//	protected screenShots screenShotsOb;

	//exxtent report class object to use it in all childs
	protected extentReport reportOb  = new extentReport();
	//screenshots  class object to use it in all childs
	protected screenShots screenShotsOb = new screenShots();

	//#######below we are using thread safe to keep every instance of the test and not override them!!!
	public static ThreadLocal<ExtentTest> extentTesThreadLocal = new  ThreadLocal<ExtentTest>();
	//#######End of thread local for thread safe 

	//#######below headless option use!!!
	ChromeOptions options = new ChromeOptions();
	/*
	 * FirefoxOptions options = new FirefoxOptions();
	
	options.setHeadless(true);
	WebDriver driver = new FirefoxDriver(options);
	driver.get("https://demoqa.com/");
	System.out.println("Title of the page is -> " + driver.getTitle());
	driver.close();
	} 
	*/
	//#######End of headless option use!!!

	//the before suite
	@BeforeSuite
	public void setupSuite() {
		WebDriverManager.chromedriver().setup();
		//open report page in the beginning 
		extentReport.setUpExtent();
		reportOb.open_reportPage(); 
	}

	@BeforeMethod
	public synchronized void beforeMethod(ITestResult result) {
//				driver=new ChromeDriver();
		//#######Start of headless option use!!!
		options.setHeadless(true);
		driver=new ChromeDriver(options);
		//#######End of headless option use!!!
		driver.manage().window().maximize();
				//setting up webdriver listener for actions
				//	//getting tc name and description
				tCName =result.getMethod().getMethodName();
		tCDescription=result.getMethod().getDescription();

		//##Creating tests and set the test as thread safe
		reportOb.test = extentReport.extent.createTest(tCName + "_" +tCDescription);
		extentTesThreadLocal.set(reportOb.test);
		//##End of Creating tests and set the test as thread safe

	}
	//after  test method  
	public synchronized void TearDown() {

		if (driver != null) {
			driver.close();//close the current window !
		}
	}


	//event listener implementation 	
	private synchronized void setUplistener() {

		webDriverEventListener = new WebDriverEventListenerClass();
		eDriver = new EventFiringWebDriver(this.driver);
		eDriver.register(webDriverEventListener);

	}




	@AfterMethod
	public synchronized void afterMethod(ITestResult result) {
		try {
			wordDocumentEvidence = new WordDocumentEvidence();
			if (result.getStatus() == ITestResult.SUCCESS) {

				//				screenShotsOb= new screenShots();

				String status = "Passed";
				System.out.println(result.getName()+" passed **********");

				//				//rename the folder to new name with status
				screenShotsOb.renameScreenShotsFolder(result.getName(), result.getMethod().getDescription(),status);

				//				//				//save screenshots to word evidence file
				wordDocumentEvidence.saveAllScreenShotsIntoWordDocument(result.getName(), result.getMethod().getDescription(),status);

				//  log the status to the html report and insert screenshot to it
				//#########
				extentTesThreadLocal.get().log(Status.PASS, result.getMethod().getMethodName()+"  :  "+status);
				reportOb.InsertAllImagesToTheReport(result.getName(), result.getMethod().getDescription(),status);
				//#######	
				extentReport.extent.flush();
				reportOb.refreshReport();
				TearDown();
			} else if (result.getStatus() == ITestResult.FAILURE) {
				//				screenShotsOb= new screenShots();

				String status = "Failed";
				System.out.println(result.getName()+" Failed **********");

				//				rename the folder to new name with status
				screenShotsOb.renameScreenShotsFolder(result.getName(), result.getMethod().getDescription(),status);

				//				//save screenshots to word evidence file
				wordDocumentEvidence.saveAllScreenShotsIntoWordDocument(result.getName(), result.getMethod().getDescription(),status);

				//  log the status to the html report and insert screenshot to it
				//########
				extentTesThreadLocal.get().log(Status.FAIL,result.getMethod().getMethodName()+"  :  "+status);
				extentTesThreadLocal.get().fail(result.getThrowable());	
				reportOb.InsertAllImagesToTheReport(result.getName(), result.getMethod().getDescription(),status);
				//########
				extentReport.extent.flush();
				reportOb.refreshReport();
				TearDown();

			} else {
				//				screenShotsOb= new screenShots();

				String status = "Skiped";
				System.out.println(result.getName()+" Skiped **********");

				//rename the folder to new name with status
				screenShotsOb.renameScreenShotsFolder(result.getName(), result.getMethod().getDescription(),status);

				//save screenshots to word evidence file
				wordDocumentEvidence.saveAllScreenShotsIntoWordDocument(result.getName(), result.getMethod().getDescription(),status);

				//  log the status to the html report and insert screenshot to it
				//#########
				extentTesThreadLocal.get().log(Status.SKIP, result.getMethod().getMethodName()+"  :  "+status);
				reportOb.InsertAllImagesToTheReport(result.getName(), result.getMethod().getDescription(),status);
				//#######	
				extentReport.extent.flush();
				reportOb.refreshReport();
				TearDown();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterSuite
	public void afterSuite() {

		reportOb.refreshReport();

	}


}
