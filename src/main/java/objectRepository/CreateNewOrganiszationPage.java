package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewOrganiszationPage extends WebDriverUtility
	{
		//declaration
		@FindBy(name="accountname")
		private WebElement OrgNameEdt;
		
		@FindBy(name="industry")
		private WebElement industryDropDown;
		
		@FindBy(name="accounttype")
		private WebElement typeDropDown;
		
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
	//intialization
		public CreateNewOrganiszationPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		
		//utilization
		public WebElement getOrgNameEdt() {
			return OrgNameEdt;
		}


		public WebElement getIndustryDropDown() {
			return industryDropDown;
		}


		public WebElement getTypeDropDown() {
			return typeDropDown;
		}


		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
	//business library	
		/**
		 * this method will create organization with organization name
		 * @param Orgname
		 */
		
		public void CreateNewOrg(String Orgname) {
			OrgNameEdt.sendKeys(Orgname);
			saveBtn.click();
			
		}
		
	/**
	 * this method will create organization with industry	
	 * @param Orgname
	 * @param industryType
	 */
		public void CreateNewOrg(String Orgname,String industryType ) {
			OrgNameEdt.sendKeys(Orgname);
			handleDropDown(industryType,industryDropDown);
			saveBtn.click();
			
		}
		
		/**
		 * this method will create organization with type and industry dropdown
		 *
		 * @param Orgname
		 * @param industryType
		 * @param Type
		 */
		
		
		public void CreateNewOrg(String Orgname,String industryType,String Type ) {
			OrgNameEdt.sendKeys(Orgname);
			handleDropDown(industryType,industryDropDown);
			handleDropDown(industryType,typeDropDown);
			saveBtn.click();
			
		}
		

}
