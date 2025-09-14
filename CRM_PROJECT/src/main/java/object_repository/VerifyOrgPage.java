package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import object_repository.*;

public class VerifyOrgPage {
	
	public VerifyOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(id = "dtlview_Organization Name")
	private WebElement outputOrg;
	
	@FindBy(id = "dtlview_Phone")
	private WebElement outputPhone;
	
	public WebElement getOutputOrg() {
		return outputOrg;
	}

	public WebElement getOutputPhone() {
		return outputPhone;
	}

	public WebElement getOutputEMPno() {
		return outputEMPno;
	}

	public WebElement getOutputIndustry() {
		return outputIndustry;
	}

	@FindBy(id = "dtlview_Employees")
	private WebElement outputEMPno;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement outputIndustry;
	
	public void OrgVerify(String outputOrg, String inputOrg)
	{	
		if(outputOrg.equals(inputOrg))
		{
			System.out.println("Organisation name is correct");
		}
		else
		{
			System.out.println("Organisation name is not correct");
		}
	}
	
	public void PhoneVerify(String outputPhone, String phoneNumber)
	{
		if(outputPhone.equals(phoneNumber))
		{
			System.out.println("Phone number is correct");
		}
		else
		{
			System.out.println("Phone number is not correct");
		}
	}
	
	public void IndustryVerify(String outputIndustry, String inputIndustry)
	{
		if(outputIndustry.equals(inputIndustry))
		{
				System.out.println("Industry is correct");
		}
		else
		{
				System.out.println("Industry is not correct");
		}
	}
	
	public void EMPNOVerify(String outputEMPno, String inputEMPno)
	{
		if(outputEMPno.equals(inputEMPno))
		{
				System.out.println("EMPNO. is correct");
		}
		else
		{
				System.out.println("EMPNO. is not correct");
		}	
	}
}
