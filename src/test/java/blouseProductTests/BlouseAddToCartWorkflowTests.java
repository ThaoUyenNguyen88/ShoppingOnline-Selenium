package blouseProductTests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Log;

import base.TestUtilities;
import page.AddressPage;
import page.BlousePage;
import page.HomePage;
import page.PaymentPage;
import page.ShippingPage;
import page.SignInPage;
import page.SummaryPage;

@Test
public class BlouseAddToCartWorkflowTests extends TestUtilities {

	
	/*
	 * Feature: Add blouse product to cart
	 * 
	 * # The first example has 13 steps Scenario: User add blouse product suscess
	 * When User go to homepage Then User click on blouse image Then User direct to
	 * blouse product page And User choose quantity, size and color they want And
	 * User click "Check Out" button Then success message displays to notify success
	 * order Then User confirm their order and click "Check out" button Then User
	 * direct to Summary page and click "Check out" button Then User direct to
	 * Signin page then User login with valid account and click "Check out" button
	 * Then User direct to Address page and click "Check out" button Then User
	 * direct to Shipping page and click "Check out" button Then User direct to
	 * Payment page and click "Check out" button Go to Home page then click blouse
	 * product and move to Blouse page
	 */
	@Test
	public void move_To_Blouse_Page_By_Click_Product_AddToCart_Workflow_Test() {
		log.info("Go to homepage, click blouse product and move to blouse page");
		HomePage homepage = new HomePage(driver, log);
		log.info("Open Home Page");
		homepage.openPage();
		log.info("Move to Blouse Page by clicking blouse product");
		BlousePage blousePage = homepage.clickToBlouse();
		log.info("Check move to Blouse page success or not");
		String blousePageUrl = "http://automationpractice.com/index.php?id_product=2&controller=product";
		AssertJUnit.assertTrue(blousePage.getCurrentUrl().equals(blousePageUrl));
	}

	//Add blouse product by clicking Add to cart button in blouse page
	@Test
	public void blouse_Add_To_Cart_AddToCart_Workflow_Tests() {
		log.info("Add blouse product by clicking Add to cart button in blouse page");
		HomePage homepage = new HomePage(driver, log);
		log.info("Open Home Page");
		homepage.openPage();
		log.info("Move to Blouse Page by clicking blouse product");
		BlousePage blousePage = homepage.clickToBlouse();
		log.info("Add blouse product with quantity: = 2, size = S, color = white");
		blousePage.addBlouseToCart(2, "S", "White");
		sleep(4000);
		log.info("Check add to cart success or not");
		String addToCartSuccessMessage = "Product successfully added to your shopping cart";
		AssertJUnit.assertTrue(blousePage.addToCartSuccess().equals(addToCartSuccessMessage));
	}

	//After add blouse to cart success then move to Summary page
	@Test
	public void blouse_Summary_Page_AddToCart_Workflow_Test() {
		log.info("Add blouse product by clicking Add to cart button in blouse page");
		HomePage homepage = new HomePage(driver, log);
		log.info("Open Home Page");
		homepage.openPage();
		log.info("Move to Blouse Page by clicking blouse product in home page");
		BlousePage blousePage = homepage.clickToBlouse();
		log.info("Add blouse product with quantity: = 2, size = S, color = white");
		blousePage.addBlouseToCart(2, "S", "White");
		sleep(5000);
		SummaryPage summaryPage = blousePage.moveToSummaryPage();
		log.info("Check move to Summary Page success or not");
		String summaryPageUrl = "http://automationpractice.com/index.php?controller=order";
		AssertJUnit.assertTrue(summaryPage.getCurrentUrl().equals(summaryPageUrl));
	}

	
	//After move to Summary page, then move to Sign in page, after sign in success, then move to Address page
	@Test
	public void blouse_Signin_Page_AddToCart_Workflow_Test() {
		log.info("Add blouse product by clicking Add to cart button in blouse page");
		HomePage homepage = new HomePage(driver, log);
		log.info("Open Home Page");
		homepage.openPage();
		log.info("Move to Blouse Page by clicking blouse product in home page");
		BlousePage blousePage = homepage.clickToBlouse();
		log.info("Add blouse product with quantity: = 2, size = S, color = white");
		blousePage.addBlouseToCart(2, "S", "White");
		sleep(2000);
		SummaryPage summaryPage = blousePage.moveToSummaryPage();
		log.info("Click 'Proceed to checkout button' and move to Sign in page");
		SignInPage signinPage = summaryPage.moveToSignInPage();
		log.info("Check sign in yet, if not, sign in with created account before and move to Address page");
		AddressPage addressPage = signinPage.checkSignIn("uyen@a.b", "12345");
		log.info("Check move to Address Page success or not");
		String addressPageUrl = "http://automationpractice.com/index.php?controller=order&step=1&multi-shipping=0";
		AssertJUnit.assertTrue(addressPage.getCurrentUrl().equals(addressPageUrl));
	}
	
	//After move to Address page, then agree with Terms of Service and move to  page
		@Test
		public void blouse_Address_Page_AddToCart_Workflow_Test() {
			log.info("Add blouse product by clicking Add to cart button in blouse page");
			HomePage homepage = new HomePage(driver, log);
			log.info("Open Home Page");
			homepage.openPage();
			log.info("Move to Blouse Page by clicking blouse product in home page");
			BlousePage blousePage = homepage.clickToBlouse();
			log.info("Add blouse product with quantity: = 2, size = S, color = white");
			blousePage.addBlouseToCart(2, "S", "White");
			sleep(2000);
			SummaryPage summaryPage = blousePage.moveToSummaryPage();
			log.info("Click 'Proceed to checkout button' and move to Sign in page");
			SignInPage signinPage = summaryPage.moveToSignInPage();
			log.info("Check sign in yet, if not, sign in with created account before and move to Address page");
			AddressPage addressPage = signinPage.checkSignIn("uyen@a.b", "12345");
			ShippingPage shippingPage = addressPage.moveToShippingPage();
			log.info("Check move to Shipping Page success or not");
			String shippingPageUrl = "http://automationpractice.com/index.php?controller=order";
			AssertJUnit.assertTrue(shippingPage.getCurrentUrl().equals(shippingPageUrl));
		}
		
		//After move to Shipping page, then agree with Terms of Service and move to Payment page
				@Test
				public void blouse_Payment_Page_AddToCart_Workflow_Test() {
					log.info("Add blouse product by clicking Add to cart button in blouse page");
					HomePage homepage = new HomePage(driver, log);
					log.info("Open Home Page");
					homepage.openPage();
					log.info("Move to Blouse Page by clicking blouse product in home page");
					BlousePage blousePage = homepage.clickToBlouse();
					log.info("Add blouse product with quantity: = 2, size = S, color = white");
					blousePage.addBlouseToCart(2, "S", "White");
					sleep(2000);
					SummaryPage summaryPage = blousePage.moveToSummaryPage();
					log.info("Click 'Proceed to checkout button' and move to Sign in page");
					SignInPage signinPage = summaryPage.moveToSignInPage();
					log.info("Check sign in yet, if not, sign in with created account before and move to Address page");
					AddressPage addressPage = signinPage.checkSignIn("uyen@a.b", "12345");
					ShippingPage shippingPage = addressPage.moveToShippingPage();
					PaymentPage paymentPage = shippingPage.moveToPaymentPage();
					log.info("Check move to Shipping Page success or not");
					String shippingPageUrl = "http://automationpractice.com/index.php?controller=order&multi-shipping=";
					AssertJUnit.assertTrue(shippingPage.getCurrentUrl().equals(shippingPageUrl));
				}

}
