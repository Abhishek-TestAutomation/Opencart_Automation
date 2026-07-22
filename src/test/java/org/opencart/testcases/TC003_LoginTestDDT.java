package org.opencart.testcases;

import org.opencart.base.BaseTest;
import org.opencart.pages.HomePage;
import org.opencart.pages.LoginPage;
import org.opencart.pages.MyAccountPage;
import org.opencart.utilities.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_LoginTestDDT extends BaseTest{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="dataDriven")
	public void verify_LoginDDT(String email, String password, String expectedResult) {
		HomePage homePage = new HomePage(driver);
		homePage.clickMyAccoutn();
		homePage.clickLogin();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
		
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		boolean targetPage = myAccountPage.isMyAccountPageExist();
		
		if(expectedResult.equalsIgnoreCase("Valid")) {
			if(targetPage) {
				myAccountPage.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(expectedResult.equalsIgnoreCase("Invalid")) {
			if(targetPage) {
				myAccountPage.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		
	}
}
