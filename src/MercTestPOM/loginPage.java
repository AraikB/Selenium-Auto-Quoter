package MercTestPOM;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class loginPage {
	private WebDriver driver;
	private WebDriverWait wait;

	//username pom
	@FindBy(xpath = "//input[contains(@id,'USER')]")
	private WebElement usernameField;

	//pass POM
	@FindBy(xpath = "//input[contains(@name,'PASSWORD')]")
	private WebElement passwordField;	

	//click
	@FindBy(xpath = "(//span[contains(.,'Login')])[2]")
	private WebElement loginButton;

	public loginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	public void setUsernameField(String text) {
		usernameField.sendKeys(text);
	}

	public void setPasswordField(String text) {
		passwordField.sendKeys(text);
	}
	public void clickLogin() {
		waitUntilClickable(loginButton).click();
	}

	private WebElement waitUntilClickable(WebElement usernameField) {
		return wait.until(elementToBeClickable(usernameField));
	}
	public void loginWait(WebDriver driver) {
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(usernameField));
	}
}
