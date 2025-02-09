package stepDefinition;

import java.util.List;

import org.junit.Assert;
import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.SearchPage;

public class SearchStep {
	
	SearchPage search = new SearchPage(DriverFactory.getDriver());
	
	@Then ("search for product")
	public void search_for_product(DataTable product) {
		List<String> prod = product.asList();
		search.enterProduct(prod.get(0));
		search.pressSearch();
	}
    @And ("validate page title")
    public void validate_page_title(DataTable title) {
    	List<String> expected = title.asList();
		Assert.assertEquals(expected.get(0),search.getPageTitle());
	}
    @Then ("get the price of the first product")
    public void get_the_price_of_the_first_product() {
		System.out.println("First Product Price is "+search.productList());
	}
    @And ("sort products by High to Low")
    public void sort_products_by_High_To_Low() {
    	search.clickSortBy();
    	System.out.println(search.highToLow());
    }
    @And ("change delivery to Norway")
    public void change_delivery_to_Norway() {
    	search.changeDelivery();
    }
}
