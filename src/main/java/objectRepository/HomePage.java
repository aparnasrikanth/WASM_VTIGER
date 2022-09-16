package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	//declaration
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLnk;

	
	@FindBy(linkText="Leads")
	private WebElement LeadsLnk;

	
	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLnk;

	
	@FindBy(linkText="Products")
	private WebElement ProductsLnk;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorImg;

	@FindBy(linkText="Sign Out")
	private WebElement SignoutLnk;
	
	
	
	//Intialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//Utilization
	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}



	public WebElement getContactsLnk() {
		return ContactsLnk;
	}



	public WebElement getLeadsLnk() {
		return LeadsLnk;
	}



	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}



	public WebElement getProductsLnk() {
		return ProductsLnk;
	}



	public WebElement getadminstratorImg() {
		return adminstratorImg;
	}



	public WebElement getSignoutLnk() {
		return SignoutLnk;
	}
	/**
	 * this method will perform signout operation
	 * @param driver
	 */
	
	
	public void signOutOfApp(WebDriver driver) {
		mouseHoverOn(driver,adminstratorImg);
		SignoutLnk.click();
		}
	
	/**
	 * this method will click on organizations
	 */
	
	public void clickonOrgLink() {
		OrganizationsLnk.click();
		}
	
	/**
	 * this method will click on contacts
	 */
	
	
	public void clickOnContactsLnk() {
		ContactsLnk.click();
		
		}
	
}


