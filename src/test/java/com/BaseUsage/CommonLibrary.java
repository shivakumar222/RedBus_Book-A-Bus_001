package com.BaseUsage;

import java.io.File;
import java.io.IOException;
// import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonLibrary 
{

	
	//code for dropdown
	public static void  selectDropDownByIndex(WebElement dropdownAddres,int indexNum)
	{
		Select s1=new Select(dropdownAddres);
		s1.selectByIndex(indexNum);
	}

	public static void  selectDropDownByVisibleText(WebElement dropdownAddres,String visibleText)
	{
		Select s1=new Select(dropdownAddres);
		s1.selectByVisibleText(visibleText);
	}
	public static void  selectDropDownByValue(WebElement dropdownAddres,String value)
	{
		Select s1=new Select(dropdownAddres);
		s1.selectByValue(value);
	}


	//code for PopUp
	public static void clickOnOkButtonInThePopUp()
	{
		Alert a1 = SuperScript.driver.switchTo().alert();
		a1.accept();
	}

	public static void clickOnCancelButtonInThePopUp()
	{
		Alert a2 = SuperScript.driver.switchTo().alert();
		a2.dismiss();
	}
	public static String retriveTextFromPopUp()
	{
		Alert a3 = SuperScript.driver.switchTo().alert();
		return a3.getText();
	}
//code for wait statemenets
	public static void waitStatements(WebDriver driver,long time,String loactor,String waits)
	{
		String presence=null;
		WebDriverWait w1=new WebDriverWait(driver,time); 
		
		if(waits==presence)
		{
			w1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loactor)));
		}
		else 
		{
			w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loactor)));
		}
	 	
	}
	
	public static void takeScreenshot(String ScreenshotName) throws IOException
	{
		EventFiringWebDriver efw=new EventFiringWebDriver(SuperScript.driver);
		File f1=efw.getScreenshotAs(OutputType.FILE);
		File f2=new File(".//src//resources//failureScreenshots"+ScreenshotName+".jpg");
		//FileUtils.moveFile(f1,f2);

	}
}


