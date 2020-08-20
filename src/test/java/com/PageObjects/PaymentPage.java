package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseUsage.SuperScript;

public class PaymentPage 
{
	@FindBy(className="custom-checkbox-rnd")
	private WebElement phonepebutton;

	@FindBy(id="makepayment")
	private WebElement PayButton;
	public	PaymentPage()
	{
		PageFactory.initElements(SuperScript.driver, this);
	}

	public void clickOnPhoenPeButton()
	{
		phonepebutton.click();
	}
	public void clickOnPayButton()
	{
		PayButton.click();
	}
}


