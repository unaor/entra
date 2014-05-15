package com.datasol.entra.unit.selenium;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicIndexTest {

	private WebDriver driver;
	private String baseUrl = "http://localhost:8080/entra/";
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void getHomePage() {
		driver.get(baseUrl);
		String projectName = driver.findElement(By.className("navbar-brand"))
				.getText();
		assertEquals(projectName, "Project name");
		// WebElement searchField = driver.findElement(By.id("sted"));
		// searchField.clear();
		// searchField.sendKeys("Stockholm");
		// searchField.submit();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}
