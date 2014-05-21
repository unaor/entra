package com.datasol.entra.unit.selenium;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
	}
	
	@Test
	public void checkLogin(){
		driver.get(baseUrl);
		String annonimousUser = driver.findElement(By.className("username-details")).getText();
		assertTrue(annonimousUser.contains("guest"));
		assertFalse(annonimousUser.contains("juan"));
		driver.findElement(By.partialLinkText("login")).click();
		 WebElement userName = driver.findElement(By.id("userName"));
		 userName.sendKeys("juan");
		 WebElement password = driver.findElement(By.id("userPassword"));
		 password.sendKeys("p@ssword");
		 driver.findElement(By.id("loginBtn")).click();
		 try{
			 driver.findElement(By.className("close")).click();
		 }catch(UnhandledAlertException ex){
			 System.out.print("catched modal exception");
		 }
		 
		 driver.navigate().refresh();
		 String juan = driver.findElement(By.className("username-details")).getText();
		 assertTrue(juan.contains("juan"));
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
