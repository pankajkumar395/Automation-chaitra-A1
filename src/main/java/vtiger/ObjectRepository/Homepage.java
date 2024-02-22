package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class Homepage extends WebDriverUtility {
	
	//Declaration- Drop downs,frames,window,textfields,popups
	@FindBy(linkText = "Organizations")
	private WebElement orgnizationLnk;
	
	@FindBy(linkText= "Contacts")
	private WebElement contactLnk;
	
	@FindBy(linkText="Products")
	private WebElement productLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLnk;
	
	//Initialization
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getOrgnizationLnk() {
		return orgnizationLnk;
	}

	public WebElement getContactLnk() {
		return contactLnk;
	}

	public WebElement getProductLnk() {
		return productLnk;
	}

	public WebElement getAdminstratorImg() {
		return adminstratorImg;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}
	
	//Business library
	/**
	 * This Method Will Logout Of the Application
	 * @param driver
	 * @throws InterruptedException
	 */
	public void logoutOfApp(WebDriver driver) throws InterruptedException {
		mousehoverAction(driver, adminstratorImg);
		Thread.sleep(1000);
		signoutLnk.click();
	}
	/**
	 * This method Will Click On Organization link
	 * @return 
	 */
	public void clickOnOrganizationLink() {
		 orgnizationLnk.click();
	}
	/**
	 * This Method Will Click On COntact Link
	 */
	public void clickOnContactLink() {
	contactLnk.click();
	}
	
	
	 
	

}
