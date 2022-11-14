package byjusPomPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage 
{
	
	@FindBy(xpath = "//a[@class='navbar-brand']")
	private WebElement branding;
	public WebElement getBrandingElement()
	{
		return branding;
	}
	
	@FindBy(xpath = "//a[text()='Study Materials']")
	private WebElement studymaterial;
	public WebElement getStudyMaterialElement()
	{
		return studymaterial;
	}
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
