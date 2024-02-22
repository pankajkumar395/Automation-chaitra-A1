package vtigerProject;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class CreateOrgnizationWithContactsUsingGenericUtility {
public static void main(String[] args) throws Throwable {
		//Create object Of Required Utility Class
	JavaUtility jUtil= new JavaUtility();
	PropertyFileUtility pUtil = new PropertyFileUtility();
	ExelFileUtility eUtil = new ExelFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	
	WebDriver driver= null;
	//Step1:Read The Data Required
	
			/*Read Data From Property File*/
	String BROWSER=pUtil.readDataFrompropertyFile("browser");
	String 	url=pUtil.readDataFrompropertyFile("url");
	String USERNAME=pUtil.readDataFrompropertyFile("username");
	String	PASSWORD=pUtil.readDataFrompropertyFile("password");
	/*read Data From Exel File*/
	String Firstname = eUtil.readDataFromExelFile("Contacts", 1, 1);
	String Lastname = eUtil.readDataFromExelFile("Contacts", 1, 2);
	//Step2:Launch The Browser
	 if(BROWSER.equalsIgnoreCase("chrome")) {
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
     }
	 wUtil.maximizeWindow(driver);
	 wUtil.waiForpageLoad(driver);
		
		//step3:Login To The Application
	     driver.get(url);
	     driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
		String parentwindow = driver.getWindowHandle();
		
		//step4:Navigate To The Contact Link
		driver.findElement(By.linkText("Contacts")).click();
		
		//step5:Click On the CreatContact Lookup Image 
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//step6:Create Contact With Select Organization Through Lookup
		//WebElement dropdown=driver.findElement(By.name("salutationtype"));
		//dropdown.click();
		//wUtil.handleDropdown(dropdown, parentwindow);
		driver.findElement(By.name("firstname")).sendKeys(Firstname);
		driver.findElement(By.name("lastname")).sendKeys(Lastname);
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();///input[@name='account_id']/following-sibling::img[@title='Select']
		Set<String> popupwindow = driver.getWindowHandles();
		for(String windowid:popupwindow) {
			driver.switchTo().window(windowid);
		if(!windowid.equals(parentwindow)) {
			driver.findElement(By.linkText("Pizza hut")).click();
			break;
		}
		}
		//step7:Switch The Control Back to Parent Window
		driver.switchTo().window(parentwindow);
		//step8:Save The Information
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//step9:Validate The Information
		String header=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(header.contains("Spider")) {
			System.out.println("pass");
			System.out.println(header);
		}
		else {
			System.out.println("Fail");
		}
		
		//step10:Logout From The Application
		WebElement Ad=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mousehoverAction(driver, Ad);
		Thread.sleep(4000);
		driver.findElement(By.linkText("Sign Out")).click();
		
		//step11:Close The Browser
		driver.quit();
	
	}


}
