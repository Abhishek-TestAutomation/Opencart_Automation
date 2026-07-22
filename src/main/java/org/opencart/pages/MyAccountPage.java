package org.opencart.pages;

import org.opencart.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']")
	private WebElement myAccountPageHeader;
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	private WebElement logoutLink;
	
	public boolean isMyAccountPageExist() {
		try {
			return myAccountPageHeader.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
		
	}
	
	public void clickLogout() {
		logoutLink.click();
	}

}
