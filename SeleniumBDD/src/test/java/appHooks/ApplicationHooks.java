package appHooks;

import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.ConfigReader;

public class ApplicationHooks {
	
	
	private ConfigReader cp = new ConfigReader();
	Properties prop;
	
	@Before(order=0)
	public void getProperty(){
		prop=cp.getProperty();
	}
	@Before(order=1)
	public void launchBrowser() {
		DriverFactory.initiateBrowser(prop.getProperty("browser"));
	}
	@After(order=0)
	public void quitBrowser() {
		DriverFactory.getDriver().quit();
	}
	@After(order=1)
	public void takeSS(Scenario sc) {
		if(sc.isFailed()) {
			String SSName = sc.getName().replaceAll(" ", "_")+System.currentTimeMillis();
			System.out.println("printing ss name"+SSName);
			byte[] src = ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
			sc.attach(src, "image/png", SSName);
		}
		
	}
	
}
