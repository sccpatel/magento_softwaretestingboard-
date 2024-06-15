package com.magento.automation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.utils.WebUtil;

public class SignInPage {

	private WebUtil webUtil;

	public SignInPage(WebUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}
	
	@FindBy(id = "email")
	private WebElement email;

	@FindBy(xpath = "//input[@title='Password']")
	private WebElement password;

	@FindBy(xpath = "//button[@class='action login primary']//span")
	private WebElement signInButton;

	@FindBy(xpath = "//div[@class='panel header']//span[@class='logged-in']")
	private WebElement loggedIn;
	
	public void signIn(String userName) {
		webUtil.sendKeys(email,userName,"email name");
		webUtil.sendKeys(password, "Password@123","password");
	}
	
	public void submitSignBtn() {
		webUtil.click(signInButton,"sign In Button");
	}

	public void verifyRegisteredCustomers() {
		String actAcCreatedMessage=webUtil.getInnerText(loggedIn, "Welcome, Man Singh!");
		String expAcCreatedMessage="Welcome, Man Singh!".trim();
		boolean acCreatedStatus=actAcCreatedMessage.equalsIgnoreCase(expAcCreatedMessage);
		webUtil.verifyConditionTrue(acCreatedStatus, 
				"Passed ! User is able to login with valid credentials successfully",
				"Failed ! User is not able to login with valid credentials");
	}
 
}
