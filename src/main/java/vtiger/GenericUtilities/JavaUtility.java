package vtiger.GenericUtilities;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This Class Consist Reusable Method Related To Java
 * @author Pankaj
 */
public class JavaUtility {

	/**
	 * This Method Will return A Random Number For Every Execution
	 * @return
	 */
	public int getRandomNumber() {
		Random r=new Random();
		return r.nextInt(1000);	
	}
	public String getSystemDate() {
		Date d=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		String date= formatter.format(d);
		return date;
	}
}
