package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseUsage.SuperScript;

public class PassengerDetailsPage
{
	@FindBy(name="Name_0")
	private WebElement passengerName;
	@FindBy(name="Age_0")
	private WebElement passengerAge;
	@FindBy(xpath="//label[text()='Male']")
	private WebElement passengerGender;
	@FindBy(xpath="//input[@value='Proceed to pay']")
	private WebElement proccedToPay;

	public  PassengerDetailsPage()
	{
		PageFactory.initElements(SuperScript.driver, this);
	}

	public void EnterPassengerName(String passName)
	{
		passengerName.sendKeys(passName);
	}
	public void EnterPaseengerAge(String passAge)
	{
		passengerAge.sendKeys(passAge);
	}

	public void clickOnGender()
	{
		passengerGender.click();
	}
	public void clickOnProccedToPay()
	{
		proccedToPay.click();
	}
}

