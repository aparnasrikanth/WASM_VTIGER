package vtiger.ContactsTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import objectRepository.ContactsInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.CreateNewOrganiszationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;
import vtiger.GenericUtility.BaseClass;

@Listeners(vtiger.GenericUtility.ListenerImplementation.class)

public class CreateContactsWithOrganisationTest extends BaseClass {
	
	@Test(groups="SmokeSuite",retryAnalyzer=vtiger.GenericUtility.RetryAnalyserImpementation.class)

	public void createContactWithOrgTest() throws Throwable {
		
		 
		//read the data req data from excelsheet
		String ORGNAME = eUtil.readDataFromExcel("Contact", 4, 3)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 2);
		
		
				
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
				cop.CreateNewOrg(ORGNAME);
				Reporter.log("New organization created", true);
				
		//validate
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrgHeader();
		System.out.println(OrgHeader);

		//Assert.assertTrue(OrgHeader.contains(ORGNAME));
	//Assert.fail();
		
		//Navigate to the contacts
		hp.clickOnContactsLnk();
		Reporter.log("Contacts link clicked", true);
		
		//Navigate to create contacts image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateNewContactImg();
		Reporter.log(" create Contact lookup image clicked", true);
		
		
		//Create contact with org details
		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		cnp.CreateNewContact(LASTNAME,ORGNAME,driver);
		Reporter.log(" new contact with organization created", true);
		
		
		//validate
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		System.out.println(contactHeader);
		//Assert.fail();

		
		Assert.assertEquals(contactHeader.contains(LASTNAME), true);
		//signout
		hp.signOutOfApp(driver);
		
		
		
		

	}


}
