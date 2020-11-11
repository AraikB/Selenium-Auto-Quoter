package MercTestPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.readertut.CsvReaderWriter;
import com.readertut.driverInfo;

public class quotePage {	
	public quotePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}
	public driverInfo driverinfo;
	public CsvReaderWriter reader;

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//input[@id='firstName']")
	private WebElement firstNames;

	@FindBy(xpath = "//input[@id='lastName']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@id='addressLine1']")
	private WebElement addressLine1;

	@FindBy(xpath = "//input[@id='zipId']")
	private WebElement zipCode;

	@FindBy(xpath = "//input[@id='hpPart1']")
	private WebElement phoneNumb;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailAdd;

	@FindBy(xpath = "//input[@name='insurTrnHhldMems[0].dateOfBirth']")
	private WebElement dOB;

	public void typeFirstNameField(String text) {
		firstNames.sendKeys(text);
	}

	public void typeLastName(String text) {
		lastName.sendKeys(text);
	}

	public void typeAddressLine(String text) {
		addressLine1.sendKeys(text);}

	public void typeZip(String text) {
		zipCode.sendKeys(text);
	}

	public void typePhone(String text) {
		phoneNumb.sendKeys(text);
	}}
