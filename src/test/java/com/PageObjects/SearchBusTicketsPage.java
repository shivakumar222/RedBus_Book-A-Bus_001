package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseUsage.SuperScript;

public class SearchBusTicketsPage
{
	@FindBy(xpath="//div[text()='View Seats']")
	private WebElement viewSeatsbutton;

	@FindBy(className="pointer")
	private WebElement selectseat;

	@FindBy(className="radio-unchecked")
	private WebElement boardingPointbutton;

	@FindBy(className="radio-unchecked")
	private WebElement  droppingPointbutton;

	@FindBy(xpath="//button[text()='Proceed to book']")
	private WebElement proccedtobookButton;

	public SearchBusTicketsPage()
	{
		PageFactory.initElements(SuperScript.driver,this);   
	}
	public void clickOnViewSeatsbutton()
	{
		viewSeatsbutton.click();
	}
	public void clickOnSelctSeat()
	{
		selectseat.click();
	}
	public void clickOnBoardingPoint()
	{
		boardingPointbutton.click();
	}
	public void clickOnDroppingPoint()
	{
		droppingPointbutton.click();
	}
	public void clickOnproccedtobookButton()
	{
		proccedtobookButton.click();
	}
}








