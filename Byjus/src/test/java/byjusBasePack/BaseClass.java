package byjusBasePack;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass 
{
	public static WebDriver driver;
	public void openB()
	{
		System.setProperty("webdriver.chrome.driver", "src"+File.separator+"test"+File.separator+"resources"+File.separator+"chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void closeB()
	{
		driver.quit();
		driver=null;
		System.gc();
	}

}
