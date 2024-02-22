package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
 
	//Declaration
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createcontactlookupImg;
	
	//Initialization
	public ContactPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	//Utilization

	public WebElement getCreatecontactlookupImg() {
		return createcontactlookupImg;
	}
	
	//Business Library
	public void clickOnCreateContactLookupImage() {
		createcontactlookupImg.click();
	}
}
