package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOutPage {
	
	public SignOutPage(WebDriver driver) 
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "img[src='themes/softed/images/user.PNG']")
	private WebElement profile;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOut;

	public WebElement getProfile() {
		return profile;
	}

	public WebElement getSignOut() {
		return SignOut;
	}
}
