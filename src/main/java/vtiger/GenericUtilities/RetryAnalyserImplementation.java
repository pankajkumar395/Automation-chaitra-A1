package vtiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This Class Provides Implementation For IRetryAnalyzer Interface Of Test NG
 * @author Pankaj
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer {

	int count = 0;
	int retryCount = 2;
	@Override
	public boolean retry(ITestResult result) {
		while(count<retryCount) {
			count++;
			return true;
		}
		return false;
	}

}
