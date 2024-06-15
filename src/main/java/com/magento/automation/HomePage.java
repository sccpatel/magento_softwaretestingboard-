package com.magento.automation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.utils.WebUtil;

public class HomePage {

	private WebUtil webUtil;

	public HomePage(WebUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	@FindBy(xpath = "//main[@id='maincontent']/preceding::a[text()='Create an Account'][last()]")
	private WebElement createAccountLink;
	
	@FindBy(xpath = "(//li[@class='authorization-link'])[1]")
	private WebElement signInLink;
	
	
	public void openSignUpPage() {
		webUtil.click(createAccountLink,"create Account Link");
	}
	
	public void openSignInPage() {
		webUtil.click(signInLink,"sign In Link");
	}

}
