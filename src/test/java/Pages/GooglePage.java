package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends BasePage{
	
	public GooglePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//Elements 
	@FindBy (xpath ="//*[@name='q']")
	public WebElement  searchbarElement;


	//Methods
	public void TestCase(String textTosend) {
		searchbarElement.clear();
		
	searchbarElement.sendKeys(textTosend);
	}
	
	
	

}
