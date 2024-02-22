package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {

	//Declaration
	@FindBy(name="lastname")
	private WebElement lastnameTxt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::Img[@title='Select']")
	private WebElement OrgLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement OrgSearchEdt;
	
	@FindBy(name="search")
	private WebElement OrgSearchBtn;
	
	//Initialization
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	//Utilization

	public WebElement getLastnameTxt() {
		return lastnameTxt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}
	
	public WebElement getOrgSearchEdt() {
		return OrgSearchEdt;
	}
	
	public WebElement getOrgSearchBtn() {
		return OrgSearchBtn;
	}
	
	//Business Library
	/**
	 * This Method Will Create Contact Without Using Organization
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME) {
		lastnameTxt.sendKeys(LASTNAME);
		saveBtn.click();
	}
	/**
	 * This Method Will Create Contact Using Organization
	 * @param LASTNAME
	 * @param ORGNAME
	 * @param driver
	 */
	
	public void createNewContact(String LASTNAME, String ORGNAME, WebDriver driver) {
		lastnameTxt.sendKeys(LASTNAME);
		OrgLookUpImg.click();
		switchToWindow(driver,"Accounts");
		OrgSearchEdt.sendKeys(ORGNAME);
		OrgSearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();//dynamic xpath of link
		//driver.findElement(By.linkText(ORGNAME))//dynamic xpath of linktext()
		//a[text()='ch399']-Regular xpath For reference
		//a[text()='"+ORGNAME+"']---Dynamic xpath
		
		switchToWindow(driver,"Contacts");
		saveBtn.click();
		
	}
	
}
