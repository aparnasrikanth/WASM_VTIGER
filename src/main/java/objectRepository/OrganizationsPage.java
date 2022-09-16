package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class OrganizationsPage extends WebDriverUtility {
	
	
	//declaration
@FindBy(xpath="//img[@alt='Create Organization...']")
private WebElement createNewOrgLookUpImg;



//intialization
public OrganizationsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
	}


//Utilization

public WebElement getCreateNewOrgLookUpImg() {
	return createNewOrgLookUpImg;
}

//bussiness library

public void clickOnCreateNewOrgImg() {
	createNewOrgLookUpImg.click();
}








}
