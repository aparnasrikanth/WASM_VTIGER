package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class ContactsInfoPage extends WebDriverUtility {
	//declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactHeaderText;
	
	//initialization
	public ContactsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization

	public WebElement getOrgHeaderText() {
		return contactHeaderText;
		
		}
	public String getContactHeader()
	{
		String contactHeader = contactHeaderText.getText();
		return contactHeader;
	}

}
