package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import driverFactory.DriverFactory;

public class CartPage {
	
	private WebDriver driver;
	private By giftCard = By.xpath("//a[text()='Gift Cards']");
	private By cardLink = By.linkText("Amazon Gift Cards");
	private By cardType = By.linkText("Anytime");
	private By selectCard = By.xpath("//span[contains(text(),'eGift')][1]");
	private By amount = By.xpath("//input[@id='gc-order-form-custom-amount']");
	private By recEmail = By.xpath("//textarea[@id='gc-order-form-recipients']");
	private By senderName = By.xpath("//input[@id='gc-order-form-senderName']");
//	private By giftMsg = By.xpath("//textarea[@id='gc-order-form-message']");
	private By addToCart = By.id("gc-buy-box-atc-button");
	private By confirmationMsg = By.id("NATC_SMART_WAGON_CONF_MSG_SUCCESS");
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	public void clickGiftCard() {
		driver.findElement(giftCard).click();
		driver.findElement(cardLink).click();
	}
	public void selectCard() {
		driver.findElement(cardType).click();
		driver.findElement(selectCard).click();
	}
	public void enterAmount(String value) {
		DriverFactory.waitFunction().until(ExpectedConditions.elementToBeClickable(driver.findElement(amount)));
		driver.findElement(amount).sendKeys(value);
	}
	public void enterRecEmail(String email) {
		driver.findElement(recEmail).sendKeys(email);
	}
	public void enterSenderName(String name) {
		driver.findElement(senderName).sendKeys(name);
	}
	public void addToCart() {
		((JavascriptExecutor)driver).executeScript
		("arguments[0].setAttribute('style','visibility:visible');",driver.findElement(addToCart));
		driver.findElement(addToCart).click();
	}
	public boolean confirmation() {
		return driver.findElement(confirmationMsg).isDisplayed();
	}
}
