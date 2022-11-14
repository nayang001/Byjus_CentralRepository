package byjusTryPack;

import static org.testng.Assert.*;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TryAssertion 
{
	static WebDriver driver;
	public void openB()
	{
		System.setProperty("webdriver.chrome.driver", "src"+File.separator+"test"+File.separator+"resources"+File.separator+"chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://byjus.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public void closeB()
	{
		driver.quit();
		driver=null;
		System.gc();
	}
	
	public static void main(String[] args) 
	{
		TryAssertion t =new TryAssertion();		
		t.openB();
		
		//URL Assertion
		String expectedurl="https://b245yjus.com/";
		String actualurl=driver.getCurrentUrl();
		assertEquals(expectedurl, actualurl, "ABC");
		
		t.closeB();
	}

}
