package vtigerProject;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithSelectOrganizationfromLookup {
	
	public static void main(String[] args) throws InterruptedException {
		
		//step1:Launch The Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//step2:Navigate The Application
		driver.get("http://localhost:8888");
		
		//step3:Login To The Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String parentwindow = driver.getWindowHandle();
		
		//step4:Navigate To The Contact Link
		driver.findElement(By.linkText("Contacts")).click();
		
		//step5:Click On the CreatContact Lookup Image 
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//step6:Create Contact With Select Organization Through Lookup
		WebElement dropdown=driver.findElement(By.name("salutationtype"));
		dropdown.click();
		Select sc=new Select(dropdown);
		sc.selectByValue("Mr.");
		driver.findElement(By.name("firstname")).sendKeys("pank");
		driver.findElement(By.name("lastname")).sendKeys("kumar");
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
		if(header.contains("pank")) {
			System.out.println("pass");
			System.out.println(header);
		}
		else {
			System.out.println("Fail");
		}
		
		//step10:Logout From The Application
		WebElement Ad=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions mousehover=new Actions(driver);
		mousehover.moveToElement(Ad).perform();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Sign Out")).click();
		
		//step11:Close The Browser
		driver.quit();
	
	}

}
