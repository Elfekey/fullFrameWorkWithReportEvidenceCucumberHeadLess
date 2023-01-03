package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import Utilities.WordDocumentEvidence;
import Utilities.extentReport;
import Utilities.retryFailedTCs;
import Utilities.screenShots;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bytecode.Throw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;
import com.aventstack.extentreports.Status;


//Listeners imports
//@Listeners(ScreenShotsListener.class)
//@Listeners(Utilities.Listener.class)
//@Listeners(Utilities.Listener.class)

public class testing extends BaseTest {

//it'll be in the parent to use it inside all the class
	screenShots screenShots = new screenShots();


	@Test(description = "This is test case one now")
	public void test1() throws Exception {

		driver.navigate().to("https://www.lambdatest.com/blog/extent-reports-in-selenium/");
		screenShots.takeFullScreenshot(tCName,tCDescription,driver);
		driver.navigate().to("https://www.google.com/?client=safari");
		screenShots.takeFullScreenshot(tCName,tCDescription,driver);

	}

	@Test(description = "This is test case Two  now",retryAnalyzer = retryFailedTCs.class)
	public void test2() {

		driver.navigate().to("https://www.google.com/");
		screenShots.takeFullScreenshot(tCName,tCDescription,driver);
		driver.navigate().to("https://www.youtube.com/");
		screenShots.takeFullScreenshot(tCName,tCDescription,driver);

		AssertJUnit.assertTrue(false);

	}

	@Test(description = "This is test case Three  now",retryAnalyzer = retryFailedTCs.class)
	public void test3() {

		driver.navigate().to("https://www.google.com/");
		screenShots.takeFullScreenshot(tCName,tCDescription,driver);
		driver.navigate().to("https://www.youtube.com/");
		screenShots.takeFullScreenshot(tCName,tCDescription,driver);

		
		
	}







}
