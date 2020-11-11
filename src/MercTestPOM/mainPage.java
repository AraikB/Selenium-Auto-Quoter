package MercTestPOM;

import static org.junit.Assert.assertNotNull;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mainPage {
	//create a private WebDriver constructor called driver
	private WebDriver driver;
	//create a private WebDriver wait Constructor
	private WebDriverWait wait;

	public mainPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	@FindBy(xpath = "//input[@id='firstName']")
	private WebElement firstNames;

	@FindBy(xpath = "(//span[contains(.,'Start')])[1]")	
	private WebElement startButton;

	public void typeFirstNameField(String text) {
		firstNames.sendKeys(text);
	}
	public void startButtonClick() {
		startButton.click();
	}
	public void mercToolWait(WebDriver driver) {
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(startButton));
	}
	private static Object firstHandle;
	private static Object secondHandle;
	private static Object lastHandle;

	public void switchToNewWindow() throws InterruptedException {
		// before clicking on the link
		String parent = driver.getWindowHandle();

		// after clicking on the link
		Thread.sleep(1000);
		Set<String> availableWindows = driver.getWindowHandles();
		String newWindow = null;
		for (String window : availableWindows) {
			if (!parent.equals(window)) {
				newWindow = window;
			}
		}
		assertNotNull(newWindow);

		// switch to new window
		driver.switchTo().window(newWindow);
	}

	public void switchToMainWindow() {
		driver.switchTo().window(firstHandle.toString());
	}
}
