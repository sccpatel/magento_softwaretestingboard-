package com.magento.automation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.utils.WebUtil;


public class MyAccountPage {
    private WebUtil webUtil;

    public MyAccountPage(WebUtil webUtil) {
        this.webUtil = webUtil; // Assign WebUtil instance
        PageFactory.initElements(webUtil.getDriver(), this); // Initialize elements using PageFactory
    }

	@FindBy(xpath = "//div[text()='Thank you for registering with Main Website Store.']")
	private WebElement thankYouForRegis;
	
	@FindBy(xpath = "(//span[text()='Change'])[1]")
	private WebElement changeDropDown;
	
	@FindBy(xpath = "//main[@id='maincontent']/preceding::li[@class='authorization-link'][last()]")
	private WebElement signOut;

	public void verifyAccountCreated() {
		String actAcCreatedMessage=webUtil.getInnerText(thankYouForRegis, "Thank you for registering with Main Website Store");
		String expAcCreatedMessage="Thank you for registering with Main Website Store.".trim();
		boolean acCreatedStatus=actAcCreatedMessage.equalsIgnoreCase(expAcCreatedMessage);
		webUtil.verifyConditionTrue(acCreatedStatus,
				"Passed ! User is sign up successfully", 
				"Failed ! User is not sign up");
	}
	
	public void signOut() {
		webUtil.click(changeDropDown,"change Drop Down");
		webUtil.click(signOut,"sign Out");
	}

 
}
