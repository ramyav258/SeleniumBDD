package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import driverFactory.DriverFactory;
public class SearchPage {
	
	private WebDriver driver;	
	public By searchTextBox = By.id("twotabsearchtextbox");
	public By searchButton = By.id("nav-search-submit-button");
	public By productList = By.xpath("//span[@class='a-price']");
	public By sortByButton = By.xpath("//span[@class='a-button-inner']/span[@id='a-autoid-0-announce']");
	public By lowToHigh = By.xpath("//a[text()='Price: Low to High']");
	public By highToLow = By.xpath("//a[text()='Price: High to Low']");
	public By delivery = By.xpath("//div[@class='glow-toaster-footer']/span/span/input");
//	public By location = By.id("GLUXCountryValue");
//	public By countryName = By.xpath("//ul[@class='a-nostyle a-list-link']/li/a[text()='Norway']");
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
	}
	public void launchURL(String URL) {
		driver.get(URL);
	}
	public void enterProduct(String product) {
		driver.findElement(searchTextBox).sendKeys(product);
	}
	public void pressSearch() {
		driver.findElement(searchButton).click();
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
	public String productList() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Thread Interupted");
		}
		List<WebElement> prodList = driver.findElements(productList);
		WebElement firstrow = prodList.get(0);
		return firstrow.getText();		
	}
	public void clickSortBy() {
		driver.findElement(sortByButton).click();
	}
	public String highToLow() {
		driver.findElement(highToLow).click();
		return productList();
	}
	public Boolean changeDelivery() {
		try {
			DriverFactory.waitFunction().until(ExpectedConditions.visibilityOf(driver.findElement(delivery)));
			driver.findElement(delivery).click();
			return true;
		}
		catch(NoSuchElementException exception) {
			return false;
		}
	}
}
