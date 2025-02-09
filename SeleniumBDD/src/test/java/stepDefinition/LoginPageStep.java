package stepDefinition;

import org.junit.Assert;
import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import util.ConfigReader;
import util.ExcelReader;

public class LoginPageStep extends ExcelReader{
	
	private LoginPage login = new LoginPage(DriverFactory.getDriver());
	
	@Given ("User is in the Home page")
	public void user_launches_the_chrome_browser(){
		login.launchURL(ConfigReader.prop.getProperty("URL"));
		if(login.checkPage()==false) {
			login.launchURL(ConfigReader.prop.getProperty("URL"));
		}
		else {
			System.out.println("Loaded page");			
		}
	}

//	@Then ("^get data from the excel(.*)$")
//	public void get_data_from_the_excel(int row) throws InvalidFormatException, IOException {
//		List<Map<String,String>> testData = 
//				getData(prop.getProperty("excelPath"), this.getClass().getSimpleName());
//		expected = testData.get(row).get("Title");
//		System.out.println(expected);
//		email = testData.get(row).get("Email");
//		pwd = testData.get(row).get("Password");
//	}
	@And ("^validate the home page title (.*)$")
	public void validate_the_home_page_title(String expected){
		String title = login.getPageTitle();
		Assert.assertEquals(expected, title);
	}
	@Then ("click on sign in button")
	public void click_on_sign_in_button() {
		login.signInClick();
	}
	
    @And ("^enter email address (.*)$")
    public void enter_email_address(String email) {
    	login.emailEnter(email);
    }
    @Then ("click on continue button")
    public void click_on_continue_button() {
    	login.emailContinue();
    }
    @And ("^enter password (.*)$")
    public void enter_password(String pwd) {
    	login.passwordEnter(pwd);
    }
    @When ("user is signed in")
    public void user_is_signed_in() {
    	login.signInAccount();
    }
    @Then ("click on sign out button")
    public void click_on_sign_out_button() {
    	login.signOut();
    }
    @Then ("Validate error message on entering wrong email")
    public void Validate_error_message_on_entering_wrong_email() {
    	Assert.assertEquals(true, login.errorMsgAvl());
    }
    @Then ("validate error page")
    public void validate_error_page() {
    	Assert.assertEquals(true, login.errorPage());
    }
}
