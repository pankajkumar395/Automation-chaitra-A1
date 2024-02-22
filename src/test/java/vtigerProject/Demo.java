package vtigerProject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	
	public static void main(String[] args) {
		  // System.setProperty("webdriver.chrome.driver", "C://Users//Pankaj//Desktop//AllDriver");
		WebDriverManager.chromedriver().setup();
		//WebDriver driver=new FirefoxDriver();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://localhost:8888");
		
	WebElement username=driver.findElement(By.name("user_name"));
	username.sendKeys("admin");
	
	WebElement password=driver.findElement(By.name("user_password"));
	password.sendKeys("admin"); 
	
	WebElement login=driver.findElement(By.id("submitButton"));
	login.click();
	}

}
