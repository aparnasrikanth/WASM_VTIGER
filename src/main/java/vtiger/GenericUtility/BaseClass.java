package vtiger.GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	public DatabaseUtility dUtil=new DatabaseUtility();
	public JavaUtility jUtil=new JavaUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver;
	@BeforeSuite(groups= {"SmokeSuite","RegressionSuite"})
	public void bsConfig() {
		//dutil.connectToDb();
		Reporter.log("Database connection successful", true);
		
	}
	//@Parameters("BROWSER")
	//@BeforeTest
	@BeforeClass(groups= {"SmokeSuite","RegressionSuite"})
	public void bcConfig(/*String Browser*/) throws IOException {
		String BROWSER=pUtil.readDataFromPropertyfile("browser");
		String URL=pUtil.readDataFromPropertyfile("url");

		if(BROWSER.equalsIgnoreCase("CHROME")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			Reporter.log("--Browser "+BROWSER+"launched successfulluy--", true);
			}
		else if(BROWSER.equalsIgnoreCase("FIREFOX")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			Reporter.log("--Browser "+BROWSER+"launched successfulluy--", true);
			}
		else {
			System.out.println("invalid browser");
		}
		sdriver=driver;
		wUtil.maximiseWindow(driver);
		wUtil.waitElementsToLoadInDom(driver);
		driver.get(URL);
	}
	
	
	@BeforeMethod(groups= {"SmokeSuite","RegressionSuite"})
	public void bmConfig() throws IOException {
		String USERNAME=pUtil.readDataFromPropertyfile("username");
		String PASSWORD=pUtil.readDataFromPropertyfile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("---login successful---", true);
	}
		
	
	@AfterMethod(groups= {"SmokeSuite","RegressionSuite"})
	public void amConfig() {
		HomePage hp=new HomePage(driver);
		hp.signOutOfApp(driver);
		Reporter.log("SignOut Successfull", true);
	}
	//@AfterTest
	@AfterClass(groups= {"SmokeSuite","RegressionSuite"})
	public void acConfig() {
		driver.close();
		Reporter.log("---browser closed successfull---", true);
		
	}
		@AfterSuite(groups= {"SmokeSuite","RegressionSuite"})
		public void asConfig() {
			//dUtil.closeDB();
			Reporter.log("---database closed successfull---", true);
			
		}
	
	
}
