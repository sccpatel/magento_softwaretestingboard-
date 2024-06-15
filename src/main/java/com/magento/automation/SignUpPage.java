package com.magento.automation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.utils.WebUtil;

public class SignUpPage {

	WebUtil webUtil;

	public SignUpPage(WebUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);

	}

	@FindBy(id = "firstname")
	private WebElement firstName;

	@FindBy(id = "lastname")
	private WebElement lastName;

	@FindBy(id = "email_address")
	private WebElement emailAddress;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "password-confirmation")
	private WebElement confirmPassword;

	@FindBy(xpath = "(//span[text()='Create an Account'])[1]")
	private WebElement createAccountButton;

	public void persionalInfo(String first_Name, String last_Name) {
		webUtil.sendKeys(firstName, first_Name,"first Name");
		webUtil.sendKeys(lastName, last_Name,"last Name");
	}

	public void signInInfo(String email_Name, String email_Password) {
		webUtil.sendKeys(emailAddress, email_Name,"email Address");
		webUtil.sendKeys(password, email_Password,"email Password");
		webUtil.sendKeys(confirmPassword, email_Password,"confirm Password");

	}

	public void createAccountButton() {
		webUtil.click(createAccountButton,"create Account Button");
	}

	public void scrollToSubmitButton() {
		webUtil.scrollingToElement(createAccountButton);

	}

	public void enterDetails(String first_Name, String last_Name, String email_Name, String email_Password) {
		persionalInfo(first_Name, last_Name);
		signInInfo(email_Name, email_Password);

	}

}
