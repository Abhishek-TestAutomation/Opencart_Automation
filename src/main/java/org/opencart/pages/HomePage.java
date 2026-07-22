package org.opencart.pages;

import org.opencart.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[contains(text(), 'My Account')]")
	private WebElement myAccountLink;
	
	@FindBy(xpath="//a[contains(text(), 'Register')]")
	private WebElement registerLink;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginLink;
	
	public void clickMyAccoutn() {
		myAccountLink.click();
	}
	
	public void clickRegister() {
		registerLink.click();
	}
	
	public void clickLogin() {
		loginLink.click();
	}

}
