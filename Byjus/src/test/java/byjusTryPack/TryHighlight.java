package byjusTryPack;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TryHighlight 
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
	
	public static void main(String[] args) throws InterruptedException 
	{
		TryHighlight t=new TryHighlight();
		t.openB();
		
		WebElement branding=driver.findElement(By.xpath("//a[@class='navbar-brand']"));
		JavascriptExecutor j=(JavascriptExecutor)driver;
//		j.executeScript("arguments[0].setAttribute('style','background:yellow')", branding);
		j.executeScript("arguments[0].setAttribute('style','border:solid 4px red')",branding);
		
		Thread.sleep(5000);
		t.closeB();

	}

}
