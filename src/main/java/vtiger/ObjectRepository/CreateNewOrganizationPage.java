package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
  
	//Declaration
	@FindBy(name="accountname")
	private WebElement orgnameTxt;
	
	@FindBy(name="industry")
	private WebElement industryDrp;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
   //Initialization	
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	//Utilization

	public WebElement getAccountnameTxt() {
		return orgnameTxt;
	}

	public WebElement getIndustryDrp() {
		return industryDrp;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	//Business Library
	/**
	 * This Method Will Create Organization With Mandatory Field
	 * @param ORGNAME
	 */
	public void createNewOrganization(String ORGNAME) {
		orgnameTxt.sendKeys(ORGNAME);
		saveBtn.click();
	}
	/**
	 * This Method Will Create Organization With Industry
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createNewOrganization(String ORGNAME,String INDUSTRY) {
		orgnameTxt.sendKeys(ORGNAME);
		handleDropdown(industryDrp,INDUSTRY);
		saveBtn.click();
	}
	
	
}
