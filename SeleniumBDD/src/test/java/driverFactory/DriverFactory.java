package driverFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public static WebDriver driver;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	@SuppressWarnings("deprecation")
	public static WebDriver initiateBrowser(String browser) {
		if(browser.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			tldriver.set(new ChromeDriver(options));
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		}
		else {
			System.out.println("Invalid Browser Name");
		}
	
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return tldriver.get();
	}	
	public synchronized static WebDriver getDriver() {
		return tldriver.get();		
	}	
	public static Wait<WebDriver> waitFunction() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
			       .withTimeout(Duration.ofSeconds(30))
			       .pollingEvery(Duration.ofSeconds(5))
			       .ignoring(NoSuchElementException.class);
		return wait;
		
	}
}