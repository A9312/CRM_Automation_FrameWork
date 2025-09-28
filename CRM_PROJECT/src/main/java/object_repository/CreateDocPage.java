package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateDocPage {

	public CreateDocPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText ="Documents")
	private WebElement Documents;
	
	@FindBy(xpath = "//img[@title='Create Document...']")
	private WebElement createdocbtn;
	
	@FindBy(name = "notes_title")
	private WebElement Title;
	
	@FindBy(xpath = "//input[@value='T']")
	private WebElement groupradiobtn;
	
	public WebElement getDocuments() {
		return Documents;
	}

	public WebElement getCreatedocbtn() {
		return createdocbtn;
	}

	public WebElement getTitle() {
		return Title;
	}

	public WebElement getGroupradiobtn() {
		return groupradiobtn;
	}

	public WebElement getAssignedTo() {
		return AssignedTo;
	}

	public WebElement getDescriptionframe() {
		return descriptionframe;
	}

	public WebElement getNotes() {
		return notes;
	}

	public WebElement getVersion() {
		return version;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	@FindBy(name = "assigned_group_id")
	private WebElement AssignedTo;
	
	@FindBy(tagName = "iframe")
	private WebElement descriptionframe;
	
	@FindBy(tagName = "body")
	private WebElement notes;
	
	@FindBy(name = "fileversion")
	private WebElement version;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	
	
	
	
	
	
	
}
