package stepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CartPage;
import util.ExcelReader;

public class CartPageStep extends ExcelReader {
	
	private CartPage cart = new CartPage(DriverFactory.getDriver());
	private String amount;
	private String email;
	private String name;
	
	@Then("Click on Gift Cards")
	public void click_on_gift_cards() {
		cart.clickGiftCard();
	}
	@And("select the card type and choose the card")
	public void select_the_card_type_and_choose_the_card() {
		cart.selectCard();
	}

	@Then("^Enter the details (.*)$")
	public void enter_the_details(int row) throws InvalidFormatException, IOException {
		List<Map<String,String>> testData = 
				getData(prop.getProperty("excelPath"), this.getClass().getSimpleName());
		amount = testData.get(row).get("Amount");
		email = testData.get(row).get("Email");
		name = testData.get(row).get("Name");
		cart.enterAmount(amount);
		cart.enterRecEmail(email);
		cart.enterSenderName(name);		
	}

	@And("click on add to cart")
	public void click_on_add_to_cart() {
		cart.addToCart();
	}

	@Then("Validate the confirmation message")
	public void validate_the_confirmation_message() {
		Assert.assertEquals(true, cart.confirmation());
	}
}
