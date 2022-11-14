package byjusTestPack;

import java.time.Duration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import byjusMethodPack.ConstantClass;
import byjusMethodPack.UtilityClass;
import byjusPomPack.HomePage;

@Listeners(byjusMethodPack.ListenerClass.class)

public class HomePageTest extends UtilityClass
{
	HomePage home;
	SoftAssert sa;
	

	@BeforeTest
	public void openBroswer()
	{
		openB();
		driver.get(ConstantClass.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		attachReport();
	}
	
	@AfterTest
	public void closeBrowser()
	{
		extentFlush();
		closeB();	
	}
	
	@BeforeClass
	public void createObjects()
	{
		home= new HomePage(driver);
		sa=new SoftAssert();
	}
	
	@AfterClass
	public void destroyObjects()
	{	
		
		home=null;
		sa=null;
	}
	
	@BeforeMethod
	public void A()
	{
		System.out.println();
	}
	
	@AfterMethod
	public void B()
	{
		System.out.println();
	}
	
	@Test
	public void TC001()
	{
		createTest("TC001=Check whether Expected URL is same as actul url or not?");
		testLog("Start the test.");
		String expectedurl="https://byjus.com/";
		sa.assertEquals(driver.getCurrentUrl(), expectedurl);
		testResult("Url is same.","Url is not same");
	}
	
	@Test
	public void TC002()
	{
		createTest("TC002=Check whether Branding present Or Not?");
		testLog("Start the test.");
		elementPresentOrNot(home.getBrandingElement());
//		sa.assertEquals(getElementText(home.getBrandingElement()), getDataFromExcel("Sheet1", 0, 0));
		highlight(home.getBrandingElement());
		testResult("Branding is Present", "Branding is not Present");
	}
	
	@Test
	public void TC003()
	{
		createTest("TC003=Check whether Study Material Text present Or Not?");
		testLog("Start the test.");
		unhighlight(home.getBrandingElement());
		elementPresentOrNot(home.getStudyMaterialElement());
		sa.assertEquals(getElementText(home.getStudyMaterialElement()), getDataFromExcel("Sheet1", 0, 1));	
		highlight(home.getStudyMaterialElement());
		testResult("Study Material Text is present", "Study Material Text is not present");	
	}
	
	@Test(priority=0)
	public void assertAll()
	{
		sa.assertAll();	
	}
}
