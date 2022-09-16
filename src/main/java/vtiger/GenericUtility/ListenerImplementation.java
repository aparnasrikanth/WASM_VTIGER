package vtiger.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	
	/**
	 * this class acts like a implementation to override all methods 
	 * present in ITestlistener interface
	 */
	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		test=report.createTest(methodName);//test is created which will intialize the individual test
		//Reporter.log(methodName+"==>test script excution started", true);
	
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"---->passed");
		//Reporter.log(methodName+"==>test script is passed", true);
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jlib = new JavaUtility();
		
		//this will capture the exception occured
		//String msg = result.getThrowable().toString();
		
		//this will capture the current test method name
		String methodName=result.getMethod().getMethodName();
		
		//this will append method name with date for screenshot
		String screenShotName = methodName+"-"+jlib.getSystemDateInFormat();
		
		//this will log in report and console
		test.log(Status.FAIL,methodName+"------>Failed" );
		test.log(Status.FAIL, result.getThrowable());
		
		//Reporter.log(methodName+"==>test script is failed because=>"+msg, true);
		//this will capture the screenshot and provide the screenshot name and save it in folder
		try {
			String path=wLib.takeScreenShot(BaseClass.sdriver,screenShotName );
			test.addScreenCaptureFromPath(path);//Navigate to screenshot path and attach it to the report
		}catch(IOException e) {
			e.printStackTrace();
		}
	
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//String msg = result.getThrowable().toString();
		String methodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"---->Skipped");
		test.log(Status.SKIP, result.getThrowable());
		//Reporter.log(methodName+"==>test script is failed because=>"+msg, true);
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//start of suite execution
		/*configure the extent repotrs*/							//inside the ExtentReports - Report-06 sep 2022 10-38-41.html
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\Report-"+ new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("WASM-5-Vtiger Execution Report ");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Vtiger Execution Report");
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "Firefox");
		report.setSystemInfo("Base-Platform", "Windows");
		report.setSystemInfo("Base-Url", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "Aparna");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//End of suite execution 
		report.flush();//consolidate all the test script execution and dump the status into report
		
	}
	


}
