package vtigerProject;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(vtiger.GenericUtilities.ListenerImplementation.class)
public class ListenerImplementationPractice {

	@Test
	public void demo()
	{
		Assert.fail();
		System.out.println("Hello");
	}
	
	@Test(dependsOnMethods= "demo")
	public void demo1()
	{
		System.out.println("Hi");
	}
}
