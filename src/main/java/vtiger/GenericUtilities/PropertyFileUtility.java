package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This Class Consist Of generic/Reusable methods Related to Property File
 * @author Pankaj k
 */
public class PropertyFileUtility {

	/*
	 * This method Will Read Data From Property File And Return tThe Value to Caller
	 *@param propertyFileKey
	 *@return
	 *@throws Throwable
	 */
	
	public String readDataFrompropertyFile(String PropertyFileKey) throws Throwable {
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p= new Properties();
		p.load(fis);
		String value = p.getProperty(PropertyFileKey);
		return value;
	}
}
