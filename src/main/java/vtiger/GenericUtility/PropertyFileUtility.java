package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	
	/**
	 * this method gives value as return for the key passed from the property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	
	
	
	public String readDataFromPropertyfile(String key) throws IOException {
	FileInputStream fis	=new FileInputStream(ConstantsUtility.PropertyFilePath);
	Properties pobj =new Properties();
	pobj.load(fis);
	String value=pobj.getProperty(key);
	return value;
	

	
}

}
