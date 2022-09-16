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


public class CreateOrganizationWithIndustryDropDownTest extends BaseClass {
	@Test(groups= {"SmokeSuit","RegressionSuit"})

	public void createOrgTest() throws Throwable {
		
		 
		
		//read the data req data from excelsheet
		String ORGNAME = eUtil.readDataFromExcel("Organization", 4, 2)+jUtil.getRandomNumber();
		String INDUSTRYTYPE = eUtil.readDataFromExcel("Organization", 4, 3);
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
		CreateNewOrganiszationPage cop=new CreateNewOrganiszationPage(driver);
		cop.CreateNewOrg(ORGNAME, INDUSTRYTYPE);
		Reporter.log("New organization created", true);
		
		//validate
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String OrgHeader = oip.getOrgHeader();
		System.out.println(OrgHeader);
//		if(OrgHeader.contains(ORGNAME)) {
//			System.out.println("org created");
//		}
//		else {
//			System.out.println("org  not created");
//		}
//Assert.assertEquals(OrgHeader.contains(ORGNAME), true);
		Assert.assertTrue(OrgHeader.contains(ORGNAME));

}}


