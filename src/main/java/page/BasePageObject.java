package page;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePageObject {

	protected WebDriver driver;
	protected Logger log;
//	WebDriverWait wait;

	public BasePageObject(WebDriver driver, Logger log) {
		super();
		this.driver = driver;
		this.log = log;
//		wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		PageFactory.initElements(driver, this);
	}

	// open url
	public void openUrl(String url) {
		driver.get(url);
	}

	// get url of current page
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	//get title of current page
	public String getCurrentTittlePage() {
		return driver.getTitle();
	}
	
	//get src of current page
	public String getCurrentPageSrc() {
		return driver.getPageSource();
	}

	// Wait for specific ExpectedCondition for the given amount of time in seconds
	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(condition);
	}

	// Wait for given number of seconds for element with given locator to be visible
	// on the page
	protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
		int attemps = 0;
		while (attemps < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
						(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
				// TODO: handle exception
			}
			attemps++;
		}

	}

	// compare expectedUrl and actualUrl
	protected void compareUrl(String expectedUrl, String actualUrl) {
		actualUrl = getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	protected Alert switchToArlet() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert();

	}
	
	protected void switchToWindowWithTitle(String expectedTitle) {
		String firtWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		Iterator<String> windowIterator = allWindow.iterator();
		while(windowIterator.hasNext()){
			String windowHandle = windowIterator.next().toString();
			if(!windowHandle.equals(firtWindow)) {
				driver.switchTo().window(windowHandle);
				if(getCurrentTittlePage().equals(expectedTitle)) {
					break;
				}
			}
		}
		
	}
	
	protected void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	protected void pressKey(WebElement element, Keys key) {
		element.sendKeys(key);
	}

}