package vtiger.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * this class retry the failed test scripts due to synchronization or network issues
 * @author DELL
 *
 */

public class RetryAnalyserImpementation implements IRetryAnalyzer {
	
	int count=0;
	int retryCount=4;//manually try and then specify the retry count

	public boolean retry(ITestResult result) {
		
		while(count<retryCount)
		{
			count++;
			return true;
		}
		
		return false;
	}

}
