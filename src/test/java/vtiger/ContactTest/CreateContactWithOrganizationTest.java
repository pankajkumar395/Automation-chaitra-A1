package vtiger.ContactTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.Homepage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.Oraganizationpage;
import vtiger.ObjectRepository.OrganizationinfoPage;

@Listeners(vtiger.GenericUtilities.ListenerImplementation.class)
public class CreateContactWithOrganizationTest extends BaseClass {
    
	@Test(groups = { "SmokeSuite"})
	public  void createContactWithOrganizationTest() throws Throwable {
		//Create Object Of utility Class
	   /* JavaUtility jUtil = new JavaUtility();
	    PropertyFileUtility pUtil= new PropertyFileUtility();
	    ExelFileUtility eUtil= new ExelFileUtility();
	    WebDriverUtility wUtil = new WebDriverUtility();*/
	    
	  //  WebDriver driver=null;
		//Step1:Read The Data Required
		
		/*Read Data From Property File*/
	       /* String	BROWSER=pUtil.readDataFrompropertyFile("browser");
	        String URL=pUtil.readDataFrompropertyFile("url");
	        String USERNAME=    pUtil.readDataFrompropertyFile("username");
	        String PASSWORD=  pUtil.readDataFrompropertyFile("password");*/
		/*Read Data From Excel File*/
		String ORGNAME = eUtil.readDataFromExelFile("Contacts", 4, 2)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExelFile("Contacts", 4, 3);
        
        //Step2:Launch the Browser-//run time polymorphism-driver
      /*  if(BROWSER.equalsIgnoreCase("chrome")) {
        	WebDriverManager.chromedriver().setup();
        	driver=new ChromeDriver();
        }
        else if(BROWSER.equalsIgnoreCase("firefox")) {
        	WebDriverManager.firefoxdriver().setup();
        	driver=new FirefoxDriver();
        }
        else if(BROWSER.equalsIgnoreCase("edge")) {
        	WebDriverManager.edgedriver().setup();
        	driver=new EdgeDriver();
        }
        else {
        	System.out.println("Invalid Driver name");
        }*/
     /*   wUtil.maximizeWindow(driver);
	    wUtil.waiForpageLoad(driver);
		driver.get(URL);
		
		//step2:Login To The Application
		LoginPage lp= new LoginPage(driver);
		lp.loginApp(USERNAME, PASSWORD);//login Operation */
		
	   // lp.getUserNameEdt().sendKeys(USERNAME);
		//lp.getPasswordEdt().sendKeys(PASSWORD);
		//lp.getLoginBtn().click();
		
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
		
		//step3:Navigate To Organization Link
		
		Homepage hp= new Homepage(driver);
		hp.clickOnOrganizationLink();
		
		//driver.findElement(By.linkText("Organizations")).click();
		
		//step4:Click On Create Organization Lookup
		 
		Oraganizationpage op= new Oraganizationpage(driver);
		op.clickOnOrganizationLookupImg();
		
		//Thread.sleep(4000);
		//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//step5:Create Organization With Mandatory Information
		
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
	    
		//Assert.fail();
		//driver.findElement(By.name("accountname")).sendKeys(OrgName);
		
		//step6:Select 'chemical' In Industry Drop down
	//WebElement dropdown = driver.findElement(By.name("industry"));
	//wUtil.handleDropdown(dropdown, INDUSTRYNAME);
	
		
		//step7:Save The Information
	//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
		//step8:Validate
		
		OrganizationinfoPage oip = new OrganizationinfoPage(driver);
				String org=oip.getOrgheader();
				
		Assert.assertTrue(org.contains(ORGNAME));	
		System.out.println(org);
		
	//String org = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	/*if(org.contains(ORGNAME)) {
		System.out.println("Organization Created");
		System.out.println(org);
	}
	else {
		System.out.println("fail");
	}*/
	//Step9: Click On Contacts Link
	hp.clickOnContactLink();
	
	//Step10: Click On Create Contact Look up Image
	ContactPage cp = new ContactPage(driver);
	cp.clickOnCreateContactLookupImage();
	
	//Step11:Create Contact Using The organization
	CreateNewContactPage cncp = new CreateNewContactPage(driver) ;
		cncp.createNewContact(LASTNAME, ORGNAME, driver);
		
	//step12: Validate for Contacts
		ContactInfoPage cip = new ContactInfoPage(driver);
		String ContactHeader = cip.getContactHeader();
		
		Assert.assertTrue(ContactHeader.contains(LASTNAME));
		System.out.println(ContactHeader);
		
	/*	if(ContactHeader.contains(LASTNAME)) {
			System.out.println("PASS");
			System.out.println(ContactHeader);
		}
		else {
			System.out.println("FAIL");
		}                                  */
		//Step13: Logout Of App
		//hp.logoutOfApp(driver);
		
		//Step 14: Close the Browser
		//driver.quit();
	
	}
	@Test
	public void demo()
	{
		System.out.println("demo");
	}
}
