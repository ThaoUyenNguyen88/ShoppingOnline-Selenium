package page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SummaryPage extends BasePageObject{

	@FindBy (xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
	WebElement checkoutBtn;
	
	
	public SummaryPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	public SignInPage moveToSignInPage() {
		checkoutBtn.click();
		return new SignInPage(driver, log);
	}
}
