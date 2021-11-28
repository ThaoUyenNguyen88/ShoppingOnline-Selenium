package page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePageObject {

	String url = "http://automationpractice.com/index.php";
	@FindBy(xpath = "//*[@id=\"homefeatured\"]/li[2]/div/div[2]/h5/a")
	WebElement blouseElement;

	public HomePage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	public void openPage() {
		log.info("Open " + url);
		openUrl(url);
	}

	// Clicking to blouse image
	public BlousePage clickToBlouse() {
//		Actions action = new Actions(driver);
//		action.moveToElement(blouseImg);
		blouseElement.click();
		return new BlousePage(driver, log);
	}

}
