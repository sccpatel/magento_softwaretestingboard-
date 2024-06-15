package com.magento.stepdefinitions;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import com.magento.PicoFactory;
import com.magento.automation.MyAccountPage;
import com.magento.utils.WebUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	private WebUtil webUtil;
	private MyAccountPage myAcPage;

	@Before(order = 0)
	public void initializeWebUtil() {
		webUtil = PicoFactory.getStaticInstance(WebUtil.class); // Use PicoFactory to get WebUtil instance
		if (webUtil != null) {
			webUtil.launchBrowser();
			webUtil.openUrl("https://magento.softwaretestingboard.com/");
		} else {
			System.out.println("Failed to initialize WebUtil");
		}
	}

	@After(order = 2)
	public void tearDownDatabaseConnection() throws SQLException {
		WebUtil webUtil = PicoFactory.getStaticInstance(WebUtil.class); // Use PicoFactory to get WebUtil instance
			webUtil.quit(); // Close the browser after test execution
	}

	@After(order = 1)
	public void finalizeExtentReport() {
		Desktop desk = Desktop.getDesktop();
		String filePath = "target/reporting.html";
		File reportFile = new File(filePath);
		try {
			if (reportFile.exists()) {
				desk.open(reportFile);
			} else {
				System.out.println("File does not exist: " + filePath);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public WebUtil getWebUtil() {
		return webUtil;
	}

	public void setWebUtil(WebUtil webUtil) {
		this.webUtil = webUtil;
	}
}
