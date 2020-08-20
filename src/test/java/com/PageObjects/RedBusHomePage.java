package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseUsage.SuperScript;

public class RedBusHomePage 
{
	@FindBy(id="src")
	private WebElement FromFiled;

	@FindBy(xpath="//li[text()='Vizag']")
	private WebElement selectFromfiled;

	@FindBy(id="dest")
	private WebElement ToFiled;

	@FindBy(xpath="//li[text()='Vijayawada (All Locations)']")
	private WebElement selectTofiled;
	@FindBy(id="onward_cal")
	private WebElement DateFiled;

	@FindBy(xpath="//td[text()='21']")
	private WebElement DatePicker;

	@FindBy(id="search_btn")
	private WebElement SearchBusesButton;

	public  RedBusHomePage()
	{
		PageFactory.initElements(SuperScript.driver,this);   
	}

	public void enterFromPlace(String fromplace) 
	{
		FromFiled.sendKeys(fromplace);
	}
	public void clickOnEnterFromFiled()
	{
		selectFromfiled.click();
	}
	public void enterToPlace(String toplace) 
	{
		ToFiled.sendKeys(toplace);
	}
	public void clickOnEnterToFiled()
	{
		selectTofiled.click();
	}
	public void clickOnDateFiled()
	{
		DateFiled.click();
	}
	public void clickOnDate()
	{
		DatePicker.click();
	}
	public void clickOnSearchBusesButton()
	{
		SearchBusesButton.click();
	}
}
