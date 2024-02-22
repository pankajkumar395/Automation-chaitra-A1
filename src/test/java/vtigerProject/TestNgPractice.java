package vtigerProject;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgPractice {
	
	@Test(invocationCount=2,priority = 1 )//To Execute The @Test multiple Time We Use invocationCount
	public void createCustumer()
	{
		System.out.println("Custmer Created");//Executed-Java Program
	}
	
	@Test(priority =-2)
	public void modifyCustmer()
	{
		System.out.println("Data modified");
	}
	
	@Test(priority = 3)
	public void deleteCustmer()
	{
		System.out.println(" Data Deleted");
	}

	@Test(enabled=false)//To Disable This Method Or We Can Use (invocationCount=0) and Many Other Options
	                    //But Good Practice Is Use (enabled=false) and Default value Is True
	public void updateCustmer()
	{
		System.out.println(" update Deleted");
	}
	
	
}
