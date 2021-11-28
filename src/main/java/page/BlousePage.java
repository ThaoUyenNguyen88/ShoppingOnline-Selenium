package page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BlousePage extends BasePageObject{
	
	By blouseLbl = By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1");
	
	@FindBy (name = "qty")
	WebElement quantityTxt;
	@FindBy (name = "group_1")
	WebElement sizeSelect;
	@FindBy (name = "Black")
	WebElement blackColor;
	@FindBy (name = "White")
	WebElement whiteColor;
	@FindBy (name = "Submit")
	WebElement addtoCartBtn;
	@FindBy (xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
	WebElement successMessage;
	@FindBy (xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
	WebElement checkoutBtn;
	
	
	public BlousePage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}
	
	public void addBlouseToCart(int quantity, String size, String color) {
		waitForVisibilityOf(blouseLbl, 10);
		quantityTxt.clear();
		quantityTxt.sendKeys(Integer.toString(quantity));
		Select drpSize = new Select(sizeSelect);
		drpSize.selectByVisibleText(size);
		if(color=="white") {
			whiteColor.click();
		}
		else if(color=="black") {
			blackColor.click();
		}
		addtoCartBtn.click();
	}
	
	public SummaryPage moveToSummaryPage() {
		checkoutBtn.click();
		return new SummaryPage(driver, log);
	}
	
	public String addToCartSuccess() {
		return successMessage.getText();
	}
	
	

}
