package com.TestCases;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.BaseUsage.CommonLibrary;
import com.BaseUsage.SuperScript;
import com.PageObjects.RedBusHomePage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class RedBus_TC_001 extends SuperScript
{
	public ExtentTest test;
	@Test
	public void bookABus() throws InterruptedException
	{

		test = extent.createTest("MyFirstTest", "opened chromebrowser and my website");	
		log.info("*************   starting test case ***************");
		log.info("****** Open RedBus Home Page **************");

		RedBusHomePage rhp=new RedBusHomePage();	
		rhp.enterFromPlace("vizag");
		rhp.clickOnEnterFromFiled();
		rhp.enterToPlace("vijayawada");
		rhp.clickOnEnterToFiled();
		rhp.clickOnDateFiled();
		rhp.clickOnDate();
		CommonLibrary.waitStatements(driver, 30,"//button[@id='search_btn']","presence" );
		rhp.clickOnSearchBusesButton();
		log.info("************* OPEN SEARCH BUSES TICKETS PAGE **************");
		Thread.sleep(3000);
		driver.findElement(By.className("icon icon-close")).click();//code to close popup
		

		log.info("************* END Test case **************");

	}
	@AfterMethod
	public void result(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL,"Test Case FAILED IS"+result.getName());//to add name in extent report
			test.log(Status.FAIL,"Test Case FAILED IS"+result.getThrowable());//to add error/exception in extent report	
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, "Test case skipped is"+result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test case PASSED is"+result.getName());
		}
	}
}

