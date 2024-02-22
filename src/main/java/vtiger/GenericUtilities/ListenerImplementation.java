package vtiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"=========Test Execution Start=========");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();

		System.out.println(methodName+"=============Pass============");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		WebDriverUtility w = new WebDriverUtility();
		JavaUtility j = new JavaUtility();
		
   		String methodName = result.getMethod().getMethodName();
   		String screenshotName = methodName+j.getSystemDate();

                   System.out.println(result.getThrowable());
		System.out.println(methodName+"==============fail============");
		
		try {
			w.captureScreenShot(BaseClass.sdriver, screenshotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
        System.out.println(result.getThrowable());
   		String methodName = result.getMethod().getMethodName();

		System.out.println(methodName+"=========skip=========");
	}

	
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("=======Suite File Execution Start=======");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("=======Suite File Execution End=======");

	}

}
