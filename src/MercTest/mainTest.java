package MercTest;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.readertut.driverInfo;
import com.opencsv.CSVReader;
import com.readertut.CsvReaderWriter;
import MercTestPOM.loginPage;
import MercTestPOM.mainPage;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import MercTestPOM.quotePage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class mainTest {
	private WebDriver driver;
	private final String exePath = "C:\\chromedriver.exe";
	//private final String exePath = "C:\\geckodriver.exe";
	private final String filePath = "C:\\Users\\Disco Ric\\Documents\\Book1.csv";
	public driverInfo driverinfo;
	public CsvReaderWriter reader;
	String subWindowHandler;
	private static Object firstHandle;
	private static Object lastHandle;


	@Before
	public void systemDefine() throws Throwable {
		CsvReaderWriter reader = new CsvReaderWriter("C:\\Users\\Disco Ric\\Documents\\Book1.csv");
		driverinfo = reader.getDriverInfo();
		//System.setProperty("webdriver.gecko.driver", exePath);
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	} 
	@Test
	public void letsStart()  throws Throwable {
		//go to site 
		driver.get("https://www.mercuryfirst.com");
		//create an object loginpage on this page using class loginPage
		loginPage loginpage = new loginPage(driver);
		//implement wait until clickable code for username field  
		loginpage.loginWait(driver);		
		//set username
		//		loginpage.setUsernameField(driverinfo.getFirstName());
		loginpage.setUsernameField("________");
		// set pass 
		loginpage.setPasswordField("________");
		// click login
		loginpage.clickLogin();

		//create new mainpage object
		mainPage main = new mainPage(driver);
		//use the wait for the button to be visible
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//click the button
		//main.clickmercuryToolsButton();
		//Select the DMS finding it by Index 
		//main.selectDMS();
		//click the go button
		//String hello = driver.getWindowHandle();
		//System.out.print(hello + "\n");
		main.startButtonClick();

		//wait 10 sec
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//GO to new tab
		quotePage quotepage = new quotePage(driver);
		main.switchToNewWindow();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		quotepage.typeFirstNameField(driverinfo.getFirstName());
		quotepage.typeLastName(driverinfo.getLastName());
		quotepage.typeAddressLine(driverinfo.getMailingAddress());
		quotepage.typeZip(driverinfo.getZipCode());
		//String hello2 = driver.getWindowHandle();
		//System.out.print(hello2 + "\n");
		//create new object to pull dmsPage
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	}// Now iterate using Iterator

}