package vtiger.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	
	
	Driver driverRef;
	Connection con=null;

	/**
	 * this method will establish connection with db
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException {
		driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection(ConstantsUtility.DBUrl,ConstantsUtility.DBUserName,ConstantsUtility.DBpassword);
		
	}

	public void closeDB() throws SQLException {
		con.close();
	}
	/**
	 * this method will excute a query and check for the expected data
	 * if the expected data is found,it will return the data
	 * else it will return null
	 * data validation wit respect to database
	 * @param query
	 * @param colindex
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryAndVerifyTheData(String query,int colindex,String expData) throws SQLException {
		boolean flag=false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next()) {
			String actData = result.getString(colindex);
			if(actData.equals(expData)) {
				flag=true;//flag rising event
				break;
			}
			
		}
		if(flag)
		{
			System.out.println("data present "+expData);
			return expData;
		}
		else {
			System.out.println("data not present");
			return" ";
		}
	}

}
