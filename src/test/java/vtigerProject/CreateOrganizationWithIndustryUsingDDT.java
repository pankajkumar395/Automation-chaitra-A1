package vtigerProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithIndustryUsingDDT {

	public static void main(String[] args) throws IOException, Throwable {
		
		Random r=new Random();
		int random = r.nextInt(100);
		
		WebDriver driver = null;
		//Step1:Read The Data Required
		
		/*Read Data From Property File*/
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fisp);
		String BROWSER = p.getProperty("browser");//Chrome
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		/*Read Data From Excel File*/
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
       Sheet sh = wb.getSheet("Organization");
        String ORGNAME= sh.getRow(4).getCell(2).getStringCellValue()+random;
        String INDUSTRY = sh.getRow(4).getCell(3).getStringCellValue();
        
        //Step2:Launch the Browser-//run time polymorphism-driver
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
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		//step2:Login To The Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();		
		//step3:Navigate To Organization Link
		driver.findElement(By.linkText("Organizations")).click();
		//step4:Click On Create Organization Lookup
		Thread.sleep(4000);
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//step5:Create Organization With Mandatory Information
	    
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//step6:Select 'chemical' In Industry Drop down
	WebElement dropdown = driver.findElement(By.name("industry"));
	Select sc=new Select(dropdown);
	dropdown.click();
	sc.selectByValue(INDUSTRY);
	
		
		//step7:Save The Information
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
		//step8:Validate
	String org = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(org.contains(ORGNAME)) {
		System.out.println("pass");
		System.out.println(org);
	}
	else {
		System.out.println("fail");
	}
		
		//step9:Logout from The Application

	WebElement Ad = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions mousehover=new Actions(driver);
	mousehover.moveToElement(Ad).perform();
	Thread.sleep(4000);
	driver.findElement(By.linkText("Sign Out")).click();	
		
		//step10:Close The Browser
	driver.quit();
	}

		
		}
