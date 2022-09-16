package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class ContactsPage extends WebDriverUtility {
	//declaration
	
		@FindBy(xpath="//img[@alt='Create Contact...']")
		private WebElement createNewContactLookUpImg;
		
		//initialization
		
		public ContactsPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
			}
		
		//Utilization
		public WebElement getCreateNewContactLookUpImg() {
			return createNewContactLookUpImg;
		}

		//business library
		
		public void clickOnCreateNewContactImg() {
			createNewContactLookUpImg.click();
		}
		
}
