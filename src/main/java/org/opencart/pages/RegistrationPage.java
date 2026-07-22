package org.opencart.pages;

import org.opencart.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstNameFiled;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement lastNameField;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement telephoneField;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement policyCheckbox;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement continueBtn;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	private WebElement confirmationMsg;
	
	public void enterFirstName(String fName) {
		firstNameFiled.sendKeys(fName);
	}
	
	public void enterLastName(String lName) {
		lastNameField.sendKeys(lName);
	}
	
	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}
	
	public void enterTelephone(String telephone) {
		telephoneField.sendKeys(telephone);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void enterConfirmPassword(String password) {
		confirmPasswordField.sendKeys(password);
	}
	
	public void clickPrivacyPolicy() {
		policyCheckbox.click();
	}
	
	public void clickContinuBtn() {
		continueBtn.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return confirmationMsg.getText();
		}
		catch(Exception e) {
			return e.getMessage();
		}

	}
	
}
