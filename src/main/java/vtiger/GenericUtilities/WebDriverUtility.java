package vtiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * this Class Consist of All reusable Method of WebDriver
 * @author Pankaj
 */
public class WebDriverUtility {
	
	/**
	 * This Method Will Maximize The Window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * this Method Will Minimize the Window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	/**
	 * This Method Will FullScreen the Window
	 * @param driver
	 */
	public void fullScreenWindow(WebDriver driver) {
		driver.manage().window().fullscreen();
	}
	
	/**
	 * This Method Will Wait 10 Second For All Web Element To Load
	 * @param driver
	 */
	public void waiForpageLoad(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This Method Will Wait 10 Second For All Web Element To visible
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementToVisible(WebDriver driver, WebElement element ) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**   
	 * This Method Will Wait 10 Second For All Web Element To Clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This Method Will Handle The Drop down Using Index
	 * Method overloading Concept is Also Used In Below Methods
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * This Method Will Handle The Drop down Using Value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, String value) {
		Select sel =new Select(element);
		sel.selectByValue(value);
		
	}
	/**
	 * This Method Will Handle The Drop down Using Visible Text
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text, WebElement element) {
		Select sel= new Select (element);
		sel.selectByVisibleText(text);
	}
	/**
	 * This Method Will Perform Mouse hover Action on Element
	 * @param driver
	 * @param element
	 */
	public void mousehoverAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This Method Will perform the Right Click On target Element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions act= new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * this Method Will Perform Double Click Action On Target Element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act= new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This Method WillDrag And Drop The Particular Element
	 * @param driver
	 * @param srs
	 * @param target
	 */
	public void dragAndDropAction(WebDriver driver, WebElement srs, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(srs, target).perform();
	}
	/**
	 * This Method Will Perform Move the Cursor And Click To particular Element
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void moveTheCursorAndClick(WebDriver driver,int x, int y) {
		Actions act=new Actions(driver);
		act.moveByOffset(x, y).click().perform();;
	}
	/**
	 * This Method Will Scroll Down 500 Units
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.ScrollBy(0, 500);", "");
		
	}
	/**
	 * This Method Will Scroll Down Until A Particular Web Element
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("argument[0].ScrollIntoView();", element);
		
	}
	/**
	 * This Method will Accept The Alert Pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * This Method Will Dismiss The Alert Pop up
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This Method Will return The Text From the Pop up
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
    /**
     * This Method Will Handle The Frame using index
     * @param driver
     * @param index
     */
	public void handleFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This Method Will Handle Frame Using Name Or ID
	 * @param driver
	 * @param nameorID
	 */
	public void handleFrame(WebDriver driver, String nameorID) {
		driver.switchTo().frame(nameorID);
	}
	/**
	 * This method Will handle The frame Using Element
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * This Method Will Help to Switch to Parent Frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	/**
	 * This Method Will help To Switch To The Default frame
	 * @param driver
	 */
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	public void switchToWindow(WebDriver driver, String partialWindowTitle) {
		//Step1: Capture all the Window IDs
		Set<String> allWinIDs = driver.getWindowHandles();
		//Step2: Navigate through Each Window
		for(String id:allWinIDs) {
			
			//Step3: Switch to Each And Capture the title
			String actTitle= driver.switchTo().window(id).getTitle();
			
			//Step4: Compare the Title With required
           if(actTitle.contains(partialWindowTitle))//true
           {
        	   break;
           }

		}
		
		
	}
	/**
	 * This Method Will Take Screenshot And Store It In Required Folder
	 * @param driver
	 * @param screenshotName
	 * @return 
	 * @throws IOException
	 */
          public String captureScreenShot(WebDriver driver, String screenshotName) throws IOException {
        	  TakesScreenshot ts =(TakesScreenshot)driver;
        	  File src = ts.getScreenshotAs(OutputType.FILE);
        	File dst = new File(".\\Screenshots\\"+screenshotName+".png");
        	Files.copy(src, dst);
        	
        	return dst.getAbsolutePath();//used for extent reporting
          }
}
