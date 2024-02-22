package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationinfoPage {

	//Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;
	
	//Initialization
	public OrganizationinfoPage(WebDriver driver) {//Test Script
		PageFactory.initElements( driver,this);
	}
	//Utilization


	public WebElement getOrgInfoHdr() {
		return getOrgInfoHdr();
	}
	//Business Library
	/**
	 * This Method Will Return The Header Text
	 * @return
	 */
	public String getOrgheader() {
		return OrgHeaderText.getText();
	}
	
}
