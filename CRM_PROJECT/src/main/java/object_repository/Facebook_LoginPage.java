package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Facebook_LoginPage {
	
	public Facebook_LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "email")
	private WebElement username;
	
	
	@FindBy(id = "pass")
	private WebElement password;
	
	
	@FindBy(name = "login")
	private WebElement loginbtn;


	public WebElement getUsername() {
		return username;
	}


	public WebElement getPassword() {
		return password;
	}


	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	
}
