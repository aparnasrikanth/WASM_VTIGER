package vtiger.GenericUtility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	/**
	 * this method will generate the random number for every execution
	 * @return
	 */
	public  int getRandomNumber() {
	Random r=new Random();
	int ran =r.nextInt(1000);
	return ran;
	
	}
	
/**
 * This method will return the system date and return the value	
 * @return
 */
	
	
	
	public String getSystemDate()
	{
		Date date=new Date();
		String d=date.toString();
		return d;
		
	}
	
/**
 * this method will generate the current date and time	in specific format
 * @return
 */
	
	public String getSystemDateInFormat() {
		Date d=new Date();
		String[] darr = d.toString().split(" ");
		String date=darr[2];
		String month=darr[1];
		String year=darr[5];
		String time=darr[3];
		String currentDateAndTime=date+" "+month+" "+year;
		return currentDateAndTime;
		
	}
	
	

}
