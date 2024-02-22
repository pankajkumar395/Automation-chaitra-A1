package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Oraganizationpage {

	//Declaration-
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement organizationlookupImg;


    //Initialization
    public Oraganizationpage(WebDriver driver) {
    	PageFactory.initElements( driver,this);
    	
    }
    //Utilization


	public WebElement getOrganizationlookupImg() {
		return organizationlookupImg;
	}
	//Business library
	/*
	 * This Method Will Click On Organization Look Up image
	 */
	public void clickOnOrganizationLookupImg() {
		organizationlookupImg.click();
	}
    }