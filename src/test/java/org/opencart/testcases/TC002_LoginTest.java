package org.opencart.testcases;

import org.opencart.base.BaseTest;
import org.opencart.pages.HomePage;
import org.opencart.pages.LoginPage;
import org.opencart.pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_LoginTest extends BaseTest{
	
	@Test(groups= {"Sanity", "Master"})
	public void verifyLogin() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickMyAccoutn();
		homePage.clickLogin();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(p.getProperty("email"));
		loginPage.enterPassword(p.getProperty("password"));
		loginPage.clickLoginBtn();
		
		MyAccountPage myAccount = new MyAccountPage(driver);
		boolean targetPage = myAccount.isMyAccountPageExist();
		
		Assert.assertTrue(targetPage, "Login Failed");
		
	}

}
