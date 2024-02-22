package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//Rule1:Create A Seprate Pom Class For Every Web page
	
	//Rule2:Identifying The Web Element By Using Annotation @FindBy,@FindAll,@FindBys
	//Declaration
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//Rule3:Create A Constructor to Initialize The WebElement
	//Initialization
	public LoginPage(WebDriver driver)
	{
     PageFactory.initElements(driver, this);
}
	//Rule4:Provide Getters For Accessing The Web Elements
	//Utilization
	public WebElement getUserNameEdt() {
		return userNameEdt;
		
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
		
	}
	public WebElement getLoginBtn() {
		return loginBtn;
		
	}
	
	//Rule5:Provide Business Library-Framework Developers Idea
	   //-Is A Generic Method Created Using Web Elements Present Only In Current Page
	
	public void loginApp(String USERNAME, String PASSWORD) {
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
}