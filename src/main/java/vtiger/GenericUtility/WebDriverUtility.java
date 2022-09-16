package vtiger.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	
	/**
	 * This method is used to maximise the window
	 * @param driver
	 */
	
	public void maximiseWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * this method will wait for 20 seconds for the entire DOM structure to load 
	 * @param driver
	 */
	
	
	public void waitElementsToLoadInDom(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	/**
	 * this method will wait for particular element to be visible
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementToLoad(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,20);
		
		
	}
	/**
	 * this method will wait for particular element to be clickable
	 * @param driver
	 * @param element
	 */
public void waitForElementToBeClicable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		
	}
	
/**
 * 	this method will wait for particular element to perform click operation 
 * if the element is not interactive it will wait for 1 second
 * @param element
 * @throws InterruptedException
 */
	
	public void customWaitAndClickOnElement(WebElement element) throws InterruptedException {
		int count=0;
		while(count<10)
		{
			try {
				element.click();
				break;
				}
			catch(Exception e) {
				Thread.sleep(1000);
				count++;
				
			}
		}
		
	}
	
/**
 * this method will handle the dropdown by using select class using index	
 * @param element
 * @param index
 */
	public void handleDropDown(WebElement element,int index) {
	Select s=new Select(element);
	s.selectByIndex(index);
			
}

/**
 * this method will handle the dropdown by  select class using visible text	
 * @param element
 * @param visibletext
 */

public void handleDropDown(WebElement element,String visibletext) {
	Select s=new Select(element);
	s.selectByVisibleText(visibletext);

}

/**
 * this method will handle the dropdown by  select class using visible text	
 * @param value
 * @param element
 */


public void handleDropDown(String value,WebElement element) {
	Select s=new Select(element);
	s.selectByValue(value);
}
	
/**
 * this method will perform double click over a page	
 * @param driver
 */
public void doubleClickOn(WebDriver driver) {
	Actions act=new Actions(driver);
	act.doubleClick().perform();
	
}


/**
 * this method will perform double  click over a particular element	
 * @param driver
 * @param element
 */
public void doubleClickOn(WebDriver driver,WebElement element) {
	Actions act=new Actions(driver);
	act.doubleClick(element).perform();
}
/**
 * this method will perform mousehover action on a particular element
 * @param driver
 * @param element
 */
	public void mouseHoverOn(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		
	}
/**
 * this method will perform mousehover action over the offset
 * @param driver
 * @param x
 * @param y
 */
	
public void mouseHoverOn(WebDriver driver,int x,int y)
{
	Actions act=new Actions(driver);
	act.moveByOffset(x,y).perform();
	
}
	/**
	 * this method will perform right click on the page
	 * 
	 * @param driver
	 */
	
	public void rightClickOn(WebDriver driver) {
		Actions act=new Actions(driver);
		act.contextClick().perform();
		
		
	}
	/**
	 * this method will perform right click on particular element
	 * @param driver
	 * @param element
	 */
	
	
public void rightClickOn(WebDriver driver,WebElement element) {
	
	Actions act=new Actions(driver);
	act.contextClick(element).perform();
	
}


/**
 * this method will perform the drag and drop action from src element to target element
 * @param driver
 * @param srcElement
 * @param targetElement
 */
public void dragAndDropOn(WebDriver driver,WebElement srcElement,WebElement targetElement) {
	Actions act=new Actions(driver);
	act.dragAndDrop(srcElement, targetElement).perform();	}

/**
 * this method will accept alert popup
 * @param driver
 */
public void acceptAlert(WebDriver driver) {
	driver.switchTo().alert().accept();
}


/**
 * this method will dismiss alert popup
 * @param driver
 */

public void dismissAlert(WebDriver driver) {
	driver.switchTo().alert().dismiss();
	
}

/**
 * this method will get the text from the alert popup and return it to caller method
 * @param driver
 * @return
 */

public String getTextInAlert(WebDriver driver) {
	String alertText = driver.switchTo().alert().getText();
	return alertText;
	
}

/**
 * this method will switch to window with respect to the window title
 * @param driver
 * @param partialTitle
 */

public void switchToWindow(WebDriver driver,String partialTitle) {
	//step1:get all the window handles
	Set<String> windowIds = driver.getWindowHandles();
	

	//step2:iterate through all the window handle
	Iterator<String> it = windowIds.iterator();
	
	//Step3:navigate inside the windows
	while(it.hasNext()) {
		//capture all the window ids
		String wind = it.next();
		//switch to the window and capture the title
		String currentTitle = driver.switchTo().window(wind).getTitle();
		if(currentTitle.contains(partialTitle)) {
			break;
		}
		
		
	}
	
	
	}

/**
 * switch tom frame based on index
 * @param driver
 * @param index
 */

public void switchToFrame(WebDriver driver,int index) {
	driver.switchTo().frame(index);
}

/**
 * switch to frame based on id or name
 * @param driver
 * @param idOrName
 */
public void switchToFrame(WebDriver driver,String idOrName) {
	driver.switchTo().frame(idOrName);
}

/**
 * switch to frame based on frame element
 * @param driver
 * @param element
 */


public void switchToFrame(WebDriver driver,WebElement element) {
	driver.switchTo().frame(element);
}
/**
 * this method will take screenshot and return the destination path
 * @param driver
 * @param screenShotName
 * @return
 * @throws IOException
 */

	public  String takeScreenShot(WebDriver driver,String screenShotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=".\\ScreenShots\\"+screenShotName+".png";
		File dst=new File(path);
		Files.copy(src, dst);
		return dst.getAbsolutePath();//used for reporting in listeners
	}
	
	/**
	 * this method will perform random scroll
	 * @param driver
	 */
	
	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)","");
		
	}
	
	/**
	 *this method will scroll until the particular element
	 * @param driver
	 * @param element
	 */
	
	public void scrollAction(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("argument[0].scrollIntoView()", element);
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}

}
