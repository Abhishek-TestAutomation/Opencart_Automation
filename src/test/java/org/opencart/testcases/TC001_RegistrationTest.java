package org.opencart.testcases;

import org.opencart.base.BaseTest;
import org.opencart.pages.HomePage;
import org.opencart.pages.RegistrationPage;
import org.opencart.utilities.RandomDataGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_RegistrationTest extends BaseTest{
	
	@Test(groups={"Regression", "Master"})
	public void verify_account_Registration() {
		HomePage homePage = new HomePage(driver);
		homePage.clickMyAccoutn();
		homePage.clickRegister();
		
		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.enterFirstName(RandomDataGenerator.randomString().toUpperCase());
		registrationPage.enterLastName(RandomDataGenerator.randomString().toUpperCase());
		registrationPage.enterEmail(RandomDataGenerator.randomEmail());
		registrationPage.enterTelephone(RandomDataGenerator.randomNumber());
		
		String password = RandomDataGenerator.randomPassword();
		
		registrationPage.enterPassword(password);
		registrationPage.enterConfirmPassword(password);
		registrationPage.clickPrivacyPolicy();
		registrationPage.clickContinuBtn();
		String confMsg = registrationPage.getConfirmationMsg();
		Assert.assertEquals(confMsg, "Your Account Has Been Created!", "Registration Failed");
	}

}
