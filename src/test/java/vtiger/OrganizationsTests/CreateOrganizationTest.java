package vtiger.OrganizationsTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import objectRepository.CreateNewOrganiszationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;
import vtiger.GenericUtility.BaseClass;
@Listeners(vtiger.GenericUtility.ListenerImplementation.class)

public class CreateOrganizationTest extends BaseClass {
	@Test(groups="SmokeSuite")

	public void createOrgTest() throws Throwable {
		
		 
		
		//read the data req data from excelsheet
		String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
		//String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 2);
		
		
		//Navigate to the Organizations
		HomePage hp=new HomePage(driver);
		hp.clickonOrgLink();
		Reporter.log("Organization clicked", true);
		
		//navigate to create org img
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateNewOrgImg();
		Reporter.log("create org look up image clicked", true);
		
		
		//create organization with mandatory fields and save 
		//vtiger.OrganizationsTests.CreateNewOrganiszationPage cop = new CreateNewOrganiszationPage(driver);
		CreateNewOrganiszationPage cop=new CreateNewOrganiszationPage(driver);
		cop.CreateNewOrg(ORGNAME);
		Reporter.log("New organization created", true);
		
		//validate
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String OrgHeader = oip.getOrgHeader();
		System.out.println(OrgHeader);
	
//Assert.assertEquals(OrgHeader.contains(ORGNAME), true);
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

//	public static void main(String[] args) throws Throwable {
//		WebDriver driver;
//		
//		//Generate random number to avoid duplicate data
//				Random r = new Random();
//				int RANDOM = r.nextInt(1000);
//		
//		
//		// Step1:read the necessary data
//		//----property file--->common data
//		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
//		Properties pobj =new Properties();
//		pobj.load(fisp);
//		String BROWSER = pobj.getProperty("browser");
//		String URL = pobj.getProperty("url");
//		String USERNAME = pobj.getProperty("username");
//		String PASSWORD = pobj.getProperty("password");
//		
//		//----read the data from excelsheet--->testdata
//		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
//		Workbook wb = WorkbookFactory.create(fise);
//		Sheet sh = wb.getSheet("Organization");
//		Row row = sh.getRow(1);
//		Cell cel = row.getCell(2);
//		String ORGNAME = cel.getStringCellValue();
//	
//		
//		//step2:launch the browser
//		if(BROWSER.equalsIgnoreCase("chrome")) {
//			driver=new ChromeDriver();
//		System.out.println("---chrome browser launched  successfully---");
//		
//		}
//		else if(BROWSER.equalsIgnoreCase("firefox")) {
//			driver=new FirefoxDriver();
//			System.out.println("---firefox browser launched  successfully---");
//			
//		}
//		else {
//		System.out.println("browser invalid");
//		driver=new ChromeDriver();
//		System.out.println("---firefox browser launched  successfully---");
//		}
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.get(URL);
//		
//	//step3:login to app
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();	
//		
//		
//	//step4:navigate to organization
//		driver.findElement(By.linkText("Organizations")).click();
//		
//		//step5:navigate to  create organization
//		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
//		
//		
//
//		//Step 6: create Organization with mandatory fields
//		driver.findElement(By.name("accountname")).sendKeys(ORGNAME+RANDOM);
//		
//		//Step 7: save
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//		System.out.println("organization created");
//		
//		//Step 8: logout and close
//		Thread.sleep(5000);
//		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		Actions act = new Actions(driver);
//		act.moveToElement(element).perform();
//		//WebDriverWait wait = new WebDriverWait(driver, 10);
//		//wait.until(ExpectedConditions.visibilityOf(element));
//		Thread.sleep(3000);
//		driver.findElement(By.linkText("Sign Out")).click();
//		
//		System.out.println("-----Scenario executed suxxessfully------");
//		
//		
//
	}


}
