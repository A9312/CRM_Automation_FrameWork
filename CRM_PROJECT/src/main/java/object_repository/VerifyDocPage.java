package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyDocPage {

	public VerifyDocPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "dtlview_Title")
	private WebElement outputTitle;

	@FindBy(id = "dtlview_Assigned To")
	private WebElement outputGroup;

	@FindBy(xpath = "(//td[@class='dvtCellInfo'])[7]")
	private WebElement outputNotes;

	@FindBy(id = "dtlview_Version")
	private WebElement outputVersion;

	// Getters
	public WebElement getOutputTitle() {
		return outputTitle;
	}

	public WebElement getOutputGroup() {
		return outputGroup;
	}

	public WebElement getOutputNotes() {
		return outputNotes;
	}

	public WebElement getOutputVersion() {
		return outputVersion;
	}

	
	public void DocTitleVerify(String outputTitle, String inputTitle) {
		if (outputTitle.equals(inputTitle)) {
			System.out.println("Document title is correct");
		} else {
			System.out.println("Document title is not correct");
		}
	}

	public void GroupVerify(String outputGroup, String inputGroup) {
		if (outputGroup.equals(inputGroup)) {
			System.out.println("Assigned group is correct");
		} else {
			System.out.println("Assigned group is not correct");
		}
	}

	public void NotesVerify(String outputNotes, String inputnotes) {
		if (outputNotes.equals(inputnotes)) {
			System.out.println("Notes are correct");
		} else {
			System.out.println("Notes are not correct");
		}
	}

	public void VersionVerify(String outputVersion, String inputverison) {
		if (outputVersion.equals(inputverison)) {
			System.out.println("Version is correct");
		} else {
			System.out.println("Version is not correct");
		}
	}
}
