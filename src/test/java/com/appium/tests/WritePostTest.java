package com.appium.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.appium.config.Utils;
import com.appium.pages.LoginPage;
import com.appium.pages.PostPage;
import com.appium.pages.WelcomePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class WritePostTest {
	public AppiumDriver<MobileElement> driver;
	LoginPage loginPage;

	@BeforeClass(alwaysRun = true)
	public void startDriver() throws IOException {
		driver = Utils.getDriver();
	}

	@Test(priority = 1)
	public void writePost() {
		loginPage = new LoginPage(driver);
		WelcomePage postpage = loginPage.enterValidCredentails(driver).waitForWelcomePage(driver);

	}

	@Test(enabled = false)
	public void deleteTheCreatedPost() {
		loginPage = new LoginPage(driver);
		PostPage postpage = loginPage.enterValidCredentails(driver).waitForWelcomePage(driver).clickPostPage(driver)
				.deletePost(driver);
		Assert.assertTrue(postpage.verifyPostIsDeleted(driver));

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

}
