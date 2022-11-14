package byjusMethodPack;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass extends UtilityClass implements ITestListener
{
	public void onTestSuccess(ITestResult result)
	{
		System.out.println(result.getName()+" Passed");
		captureSS(result.getStatus(), result.getName());
	}

	public void onTestFailure(ITestResult result)
	{
		System.out.println(result.getName()+" Failed");
		captureSS(result.getStatus(), result.getName());
	}

	public void onTestSkipped(ITestResult result)
	{
		System.out.println(result.getName()+" Skipped");
	}
	
	public void onStart(ITestContext context)
	{
		System.out.println(context.getName()+" Started");
	}
	
	public void onFinish(ITestContext context)
	{
		System.out.println(context.getName()+" Finished");
	}	
}
