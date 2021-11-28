package page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePageObject{
	
	@FindBy (name = "email")
	WebElement emailTxt;
	@FindBy (name = "passwd")
	WebElement passwordTxt;
	@FindBy (name = "SubmitLogin")
	WebElement signInBtn;
	@FindBy (xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]")
	WebElement signinBtnMenuBar;
	
	public SignInPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	public void signIn(String email, String password) {
		emailTxt.sendKeys(email);
		passwordTxt.sendKeys(password);
		signInBtn.click();
	}
	
	//Checking SignIn yet when confirm the order
	public AddressPage checkSignIn(String email, String password) {
		if(signinBtnMenuBar.isDisplayed()) {
			signIn(email, password);
		}
		return new AddressPage(driver, log);
			
	}

}
