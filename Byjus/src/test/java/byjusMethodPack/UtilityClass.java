package byjusMethodPack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import byjusBasePack.BaseClass;

public class UtilityClass extends BaseClass
{
	private File src;
	private File dest;
	private String path;
	private FileInputStream file;
	private String data;
	private ExtentSparkReporter report;
	private ExtentReports extent;
	private ExtentTest test;
	private Actions a;
	private String scroll;
	
	public void captureSS(int a,String testcasename)
	{
		src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		if (a==1)
		{
			dest=new File("Byjus-SS"+File.separator+"Passed"+File.separator+testcasename+".jpg");
		}
		else
		{
			dest=new File("Byjus-SS"+File.separator+"Failed"+File.separator+testcasename+".jpg");
		}
		try
		{
			FileHandler.copy(src, dest);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public String getDataFromExcel(String sheetname,int rownum, int colnum)
	{
		path="src"+File.separator+"test"+File.separator+"resources"+File.separator+"Byjus.xlsx";
		try
		{
			file= new FileInputStream(path);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		try
		{
			data=WorkbookFactory.create(file).getSheet(sheetname).getRow(rownum).getCell(colnum).getStringCellValue();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}

	public void attachReport()
	{
		report=new ExtentSparkReporter("Report"+File.separator+"HomePageTest.html");
		extent=new ExtentReports();
		extent.attachReporter(report);
	}
	
	public void createTest(String Value)
	{
		test=extent.createTest(Value);	
	}
	
	public void testLog(String Value)
	{
		test.log(Status.INFO, Value);
	}
	
	public void testResult(String passvalue, String failvalue)
	{
		if (test.getStatus().toString().equalsIgnoreCase("Pass"))
		{
			test.pass(passvalue);
		}
		else if (test.getStatus().toString().equalsIgnoreCase("Fail"))
		{
			test.fail(failvalue);
		}
		else
		{
			System.out.println("Status of Test is "+test.getStatus().toString());
		}
	}
	
	public void extentFlush()
	{
		extent.flush();
	}
	
	public void elementPresentOrNot(WebElement element)
	{
		if (element.isDisplayed()==true)
		{
			System.out.println(element.getText()+ " is Present.");
		}
		else
		{
			System.out.println(element.getText()+ " is not Present.");
		}
	}

	public String getElementText(WebElement element)
	{
		return element.getText();
	}

	public void highlight(WebElement element)
	{
		JavascriptExecutor j=(JavascriptExecutor)driver;
//		j.executeScript("arguments[0].setAttribute('style','background:yellow')", element);
		j.executeScript("arguments[0].setAttribute('style','border:solid 4px red')",element);
	}
	
	public void unhighlight(WebElement element)
	{
		JavascriptExecutor j=(JavascriptExecutor)driver;
//		j.executeScript("arguments[0].removeAttribute('style','background: yellow')", element);
		j.executeScript("arguments[0].removeAttribute('style','border: solid 4px red')",element);
	}

	public void scrollIntoView(WebElement element)
	{
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("arguments[0].scrollIntoView(true);",element);
	}

	public void sendData(WebElement element, String value)
	{
		element.sendKeys(value);
	}

	public void clickElement(WebElement element)
	{
		element.click();
	}

	public void moveToElement(WebElement element)
	{
		a.moveToElement(element).build();
	}
}

