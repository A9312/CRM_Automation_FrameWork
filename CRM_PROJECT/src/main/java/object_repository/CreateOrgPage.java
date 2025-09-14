package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPage {

	public CreateOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText ="Organizations")
	private WebElement Organisations;
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement plusicon;
	
	@FindBy(name = "accountname")
	private WebElement orgField;
	
	@FindBy(id ="phone")
	private WebElement phoneField;
	
	@FindBy(name = "industry")
	private WebElement IndustryDD;
	
	@FindBy(id ="employees")
	private WebElement Employees;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]'][1]")
	private WebElement saveBtn;

	public WebElement getOrganisations() {
		return Organisations;
	}

	public WebElement getPlusicon() {
		return plusicon;
	}

	public WebElement getOrgField() {
		return orgField;
	}

	public WebElement getPhoneField() {
		return phoneField;
	}

	public WebElement getIndustryDD() {
		return IndustryDD;
	}

	public WebElement getEmployees() {
		return Employees;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
}
