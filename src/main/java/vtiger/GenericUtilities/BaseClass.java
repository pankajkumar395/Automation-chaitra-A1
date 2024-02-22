package vtiger.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.Homepage;
import vtiger.ObjectRepository.LoginPage;

/**
 * This is a Generic Class Consisting Of All Basic Configuration
 * Annotation Of TestNG
 * @author Pankajk
 */
public class BaseClass {

	public JavaUtility jUtil = new JavaUtility();
	public ExelFileUtility eUtil =  new ExelFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"ReggressionSuite","SmokeSuite"})
	public void bsConfig()
	{
		System.out.println("========Data Base Conection Successful==========");
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws Throwable
	{
	String BROWSER = pUtil.readDataFrompropertyFile("browser");
	String URL = pUtil.readDataFrompropertyFile("url");
	 if(BROWSER.equalsIgnoreCase("chrome")) {
     	WebDriverManager.chromedriver().setup();
     	driver=new ChromeDriver();
     	System.out.println("Chrome Lunched Successfuly");
     }
     else if(BROWSER.equalsIgnoreCase("firefox")) {
     	WebDriverManager.firefoxdriver().setup();
     	driver=new FirefoxDriver();
     	System.out.println("firefox Lunched Successfuly");
     }
     else if(BROWSER.equalsIgnoreCase("edge")) {
     	WebDriverManager.edgedriver().setup();
     	driver=new EdgeDriver();
     }
     else {
     	System.out.println("Invalid Driver name");
     }
	 wUtil.maximizeWindow(driver);
	    wUtil.waiForpageLoad(driver);
		driver.get(URL);
		
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws Throwable
	{
		String USERNAME = pUtil.readDataFrompropertyFile("username");
		String PASSWORD = pUtil.readDataFrompropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginApp(USERNAME, PASSWORD);
		
		System.out.println("=====lOGIN SuCCesful");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws Throwable
	{
		Homepage hp = new Homepage(driver);
		hp.logoutOfApp(driver);
		
		System.out.println("=====Logout Successful======");
	}
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("======Browser Closed=======");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("============Data Base Connection Closed============");
	}
}
