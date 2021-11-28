package page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePageObject{

	@FindBy (xpath = "//*[@id=\"product_2_7_0_595617\"]/td[2]/small[2]/a")
	WebElement colorSizeElement;
	@FindBy (xpath = "//*[@id=\"product_2_7_0_595617\"]/td[5]/span")
	WebElement quantityElement;
	
	
	public PaymentPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	public String getColorSize() {
		return colorSizeElement.getText();
	}
	
	public String getQuantity() {
		return quantityElement.getText();
	}
}
