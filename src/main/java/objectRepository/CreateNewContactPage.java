package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
	//declaration
	
	@FindBy(name="lastname")
	private WebElement LastnameEdt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement OrgLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement SearchBoxEdt;
	
	@FindBy(name="search")
	private WebElement SearchBtn;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
//intialization
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		}
	//utilization
	
	public WebElement getLastnameEdt() {
		return LastnameEdt;
	}






	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}






	public WebElement getSearchBoxEdt() {
		return SearchBoxEdt;
	}






	public WebElement getSearchBtn() {
		return SearchBtn;
	}






	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}






	public WebElement getSaveBtn() {
		return saveBtn;
	}

//business library
/**
* this method will create a contact with organization name		
* @param lastname
* @param orgName
* @param driver
*/
	public void CreateNewContact(String lastname,String orgName,WebDriver driver) {
		LastnameEdt.sendKeys(lastname);
		OrgLookUpImg.click();
		switchToWindow(driver,"Accounts");
		SearchBoxEdt.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver,"Contacts");
		saveBtn.click();
		}

	/**
	 * this method will create a contact using mandatory fields and save
	 * @param lastname
	 */
		
	

	public void CreateNewContact(String lastname) {
		LastnameEdt.sendKeys(lastname);
		saveBtn.click();
		
	}

/**
* this method will create a contact with lastname/contactname and source drop down
* @param lastname
* @param leadSourceType
*/



	public void CreateNewContact(String lastname,String leadSourceType) {
		LastnameEdt.sendKeys(lastname);
		handleDropDown(leadSourceType,leadSourceDropDown);
		saveBtn.click();

	

}}


