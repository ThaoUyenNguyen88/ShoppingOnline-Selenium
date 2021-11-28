package page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPage extends BasePageObject{

	@FindBy (name = "processCarrier")
	WebElement checkoutBtn;
	@FindBy (name = "cgv")
	WebElement agreeCkb;
	
	public ShippingPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	public PaymentPage moveToPaymentPage() {
		if(agreeCkb.isSelected()) {
			checkoutBtn.click();
		}
		else {
			agreeCkb.click();
			checkoutBtn.click();
		}
		return new PaymentPage(driver, log);
	}
	
}
