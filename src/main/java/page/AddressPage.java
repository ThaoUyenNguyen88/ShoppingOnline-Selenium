package page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends BasePageObject{

	@FindBy (name = "processAddress")
	WebElement checkoutBtn;
	
	public AddressPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}
	
	public ShippingPage moveToShippingPage() {
		checkoutBtn.click();
		return new ShippingPage(driver, log);
	}

}
