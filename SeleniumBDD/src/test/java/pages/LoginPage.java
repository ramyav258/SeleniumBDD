package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

import driverFactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class LoginPage{
	private WebDriver driver;
	private By signInButton = By.className("nav-line-1-container");
	private By emailTextBox = By.id("ap_email");
	private By emailContinue = By.id("continue");
	private By passwordTextBox = By.id("ap_password");
	private By passwordSignIn = By.id("signInSubmit");
	private By signOutButton = By.xpath("//a[text()='Sign Out']");
	private By menu = By.xpath("//a[@id='nav-hamburger-menu']");
	private By error = By.xpath("//div[contains(text(),'Wrong or Invalid email')]");
	private By validate = By.linkText("Get free shipping to Norway");
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public Boolean checkPage() {
		try {
			DriverFactory.waitFunction().until(ExpectedConditions.visibilityOf(driver.findElement(validate)));
		    return true;
		} catch (NoSuchElementException exception) {
		    return false;
		}
	}
	public void launchURL(String URL) {
		driver.get(URL);
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
	public void signInClick() {
		driver.findElement(signInButton).click();
	}
	public void emailEnter(String email) {
		driver.findElement(emailTextBox).sendKeys(email);
	}
	public void emailContinue() {
		driver.findElement(emailContinue).click();
	}
	public void passwordEnter(String pwd) {
		driver.findElement(passwordTextBox).sendKeys(pwd);
	}
	public void signInAccount() {
		driver.findElement(passwordSignIn).click();
	}
	public void signOut() {
		driver.findElement(menu).click();
		DriverFactory.waitFunction().until(ExpectedConditions.elementToBeClickable(driver.findElement(signOutButton)));
		((JavascriptExecutor)driver).executeScript
		("arguments[0].setAttribute('style','visibility:visible');",driver.findElement(signOutButton));
		driver.findElement(signOutButton).click();
	}
	public boolean errorMsgAvl() {
		return driver.findElement(error).isDisplayed();
	}
	public boolean errorPage() {
		try{
			driver.findElement(menu).isDisplayed();
			return false;
		}
		catch(NoSuchElementException exception){
			return true;
		}
		
	}
}