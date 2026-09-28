package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameElement;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordElement;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;

	public void setUserName(String userName) {
		waitUntilElementIsVisible(By.xpath("//input[@name='username']"), 15);
		userNameElement.clear();
		userNameElement.sendKeys(userName);
	}

	public void setPassword(String password) {
		waitUntilElementIsVisible(By.xpath("//input[@name='password']"), 15);
		passwordElement.clear();
		passwordElement.sendKeys(password);
	}

	public void clickLogin() {
		waitUntilElementIsClickable(By.xpath("//button[@type='submit']"), 15);
		loginButton.click();
	}
}
