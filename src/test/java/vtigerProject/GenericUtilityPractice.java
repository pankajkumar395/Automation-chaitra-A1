package vtigerProject;

import vtiger.GenericUtilities.JavaUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws Throwable {

		/*PropertyFileUtility pUtil=new PropertyFileUtility();
		String Bname = pUtil.readDataFrompropertyFile("browser");
		System.out.println(Bname);
		String ul = pUtil.readDataFrompropertyFile("url");
		System.out.println(ul);
		
		ExelFileUtility eUtil = new ExelFileUtility();
		String orgname = eUtil.readDataFromExelFile("Organization", 4, 2);
		System.out.println(orgname);
		String TC_name = eUtil.readDataFromExelFile("Organization", 4, 1);
		System.out.println(TC_name);
		
		eUtil.writeDataIntoExelFile("TrialNow", 6, 8, "PeterEngland");
		System.out.println("Data Added");      */
		
		JavaUtility ju=new JavaUtility();
		System.out.println(ju.getRandomNumber());
		
		System.out.println(ju.getSystemDate());
	}

}
