package vtigerProject;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	
	@Test
	public void test()
	{
		System.out.println("Execcution Started");
		
		Assert.assertEquals("a", "a");
		
		System.out.println("Hi");
		
		Assert.assertEquals("a", "b");
		
		System.out.println("I Am Here");
	}
	
	@Test
	public void test2()
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("step1");
		//pass-10 SA -8 SA
		
		System.out.println("step2");
		
		sa.assertTrue(false);//fail
		System.out.println("step3");
		
		sa.assertEquals(1, 2);//fail
		System.out.println("Step4");
		
		Assert.assertEquals(false,true);
		
		System.out.println("step5");
		
		sa.assertAll();
		
	}

}
