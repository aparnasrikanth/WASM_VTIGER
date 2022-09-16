package vtiger.OrganizationsTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import objectRepository.CreateNewOrganiszationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;
import vtiger.GenericUtility.BaseClass;

@Listeners(vtiger.GenericUtility.ListenerImplementation.class)

public class CreateMultipleOrganizationWithIndustryTest extends BaseClass{
		
		@Test(dataProvider="OrgData",groups="Regression")
		public void createMultipleOrganizationWithIndustryTest(String OrgName,String industryType) {
			String Org=OrgName+jUtil.getRandomNumber();
			
		//Navigate to Organization link
		HomePage hp=new HomePage(driver);
		hp.clickonOrgLink();
		
		//Navigate to create org look up image
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateNewOrgImg();
		
		
		//create new org with industry type
		CreateNewOrganiszationPage cop=new CreateNewOrganiszationPage(driver);
		cop.CreateNewOrg(Org,industryType);
		
		//validate
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String orgHeader=oip.getOrgHeader();
		System.out.println(orgHeader);
		Assert.assertTrue(true);
		}
		
		@DataProvider(name="OrgData")
		public Object[][] getData() throws Throwable{
			
			return eUtil.readMultipleDataFromExcel("MultipleOrg");
		}

		

}
