package vtigerProject;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGmathodPractice {

	@Test
	public void createCustomer()//fail
	{
		//Assert.fail();  //We Put This Statement Intentionally To Fail This createCustomer() method
		System.out.println("Customer Created");
	}
	
	@Test(dependsOnMethods="createCustomer")//This Will Skip Because This Method Depends Upon createCustomer Method
	public void modifyCustomer()
	{
		System.out.println("Customer Modified");
	}
	
	@Test(dependsOnMethods={"createCustomer", "modifyCustomer"})
	public void updateCustumer()//This Will Also Skip For Same Reason
	{
		System.out.println("Customer Updated");
	}
	//So the Conclusion Is Status PASS=0; Fail=1; Skipped=2
}
