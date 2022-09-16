package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//rule1:create a seperate class for every page
		//rule2:identify the elements using @FindBy,@FindAll,@Findbys and store
		//declaration
		@FindBy(name="user_name")
		private WebElement userNameEdt;
		@FindBy(name="user_password")
		private WebElement passwordEdt;	
		@FindBy(id="submitButton")
		private WebElement loginBtn;	
		//rule3:create a constructor to intialise
		//initialization
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		
		//rule4:provide getters to access the elements
		public WebElement getUserNameEdt() {
			return userNameEdt;
		}
		public WebElement getPasswordEdt() {
			return passwordEdt;
		}
		public WebElement getLoginBtn() {
			return loginBtn;
		}
		
		//step5: bussiness library
		public void loginToApp(String username,String password) {
			userNameEdt.sendKeys(username);
			passwordEdt.sendKeys(password);
			loginBtn.click();
		}
		
		
		
		
		
}
