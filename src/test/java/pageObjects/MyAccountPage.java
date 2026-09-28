package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	private WebElement headerElement;
	
	
	@FindBy(xpath="//span[@class='oxd-userdropdown-tab']")
	private WebElement logoutDropdown;
	
	@FindBy(linkText="Logout")
	private WebElement logoutButton;
	
	
	public boolean isMyAccountPageExists() {		
		
		try {
			return waitUntilElementIsVisible(By.xpath("//h6[text()='Dashboard']"), 15).isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void logOut() {
		waitUntilElementIsVisible(By.xpath("//span[@class='oxd-userdropdown-tab']"), 15);
		logoutDropdown.click();
		waitUntilElementIsVisible(By.linkText("Logout"), 15);
		logoutButton.click();
	}
	

}
