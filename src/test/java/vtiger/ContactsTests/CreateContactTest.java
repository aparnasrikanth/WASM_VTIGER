package vtiger.ContactsTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import objectRepository.ContactsInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import vtiger.GenericUtility.BaseClass;

@Listeners(vtiger.GenericUtility.ListenerImplementation.class)



public class CreateContactTest extends BaseClass {
		@Test

		public void createContactTest() throws Throwable {
			
			 
			
			//read the data req data from excelsheet
			//String ORGNAME = eUtil.readDataFromExcel("Organization", 2, 1)+jUtil.getRandomNumber();
			String LASTNAME = eUtil.readDataFromExcel("Contact", 1, 2);
			//Navigate to the contacts
			HomePage hp=new HomePage(driver);
					hp.clickOnContactsLnk();
					Reporter.log("Contacts link clicked", true);
					
					//Navigate to create contacts image
					ContactsPage cp = new ContactsPage(driver);
					cp.clickOnCreateNewContactImg();
					Reporter.log(" create Contact lookup image clicked", true);
					
					
					//Create contact with org details
					CreateNewContactPage cnp = new CreateNewContactPage(driver);
					cnp.CreateNewContact(LASTNAME);
					Reporter.log(" new contact with contact  created", true);
					
					
					//validate
					ContactsInfoPage cip = new ContactsInfoPage(driver);
					String contactHeader = cip.getContactHeader();
					System.out.println(contactHeader);
					Assert.assertEquals(contactHeader.contains(LASTNAME), true);
					
					//signout
					hp.signOutOfApp(driver);
					
					
					
					

				}

			

}
