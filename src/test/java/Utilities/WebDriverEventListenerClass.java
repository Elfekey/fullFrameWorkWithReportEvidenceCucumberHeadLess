package Utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.aventstack.extentreports.Status;

import Tests.testing;

public class WebDriverEventListenerClass  implements WebDriverEventListener {//org.openqa.selenium.support.events.WebDriverEventListener   
	//objects that we'll use
	screenShots screenShots = new screenShots();
	testing testing ;
	WordDocumentEvidence wordDocumentEvidence = new WordDocumentEvidence();
	extentReport report = new extentReport();


 	
    

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		//
		
//		System.out.println("tc name and desc :   "+t1.tCName+t1.tCDescription);		
//			screenShots.takeFullScreenshot(t.tCName,t.tCDescription,t.eDriver);
//		screenShots.takeFullScreenshot(testing.tCName,testing.tCDescription,testing.eDriver);
//		report.test.log(Status.PASS, "beforeNavigateTo"+url);
//		report.refreshReport();
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
//		screenShots.takeFullScreenshot(tCName,tCDescription);
//		report.test.log(Status.PASS, "afterNavigateTo   : "+url);
////		report.refreshReport();
//		testing = new testing();
//		screenShots.takeFullScreenshot(testing.tCName,testing.tCDescription,testing.eDriver);

	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
	
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {

	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
	

	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub

	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub

	}

}
