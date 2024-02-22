package vtigerProject;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganigationWithIndustry {
	
	public static void main(String[] args) throws InterruptedException {
		Random random=new Random();
		random.nextInt(1000);
		//step1:Launch The Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		//step2:Login To The Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();		
		//step3:Navigate To Organization Link
		driver.findElement(By.linkText("Organizations")).click();
		//step4:Click On Create Organization Lookup
		Thread.sleep(4000);
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//step5:Create Organization With Mandatory Information
	     String orgname="pitter"+random;
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		
		//step6:Select 'chemical' In Industry Dropdown
	WebElement dropdown = driver.findElement(By.name("industry"));
	dropdown.click();
	Select sc=new Select(dropdown);
	sc.selectByValue("Chemicals");
	
		
		//step7:Save The Information
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
		//step8:Validate
	String org = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(org.contains(orgname)) {
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
