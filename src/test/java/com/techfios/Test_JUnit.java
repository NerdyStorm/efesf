package com.techfios;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Test_JUnit {
    
    WebDriver driver;

	@BeforeClass
	public static void beforeTest() {//this method should be static 
		System.out.println("before the class");
		//in all the methods here all the syso statements are only just to check how many times it runs 
	}
    @Before
	public void launchBrowser() {
		System.out.println("before ");
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\Kevadia\\QASeptember2021\\crm\\driver\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");

		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
         //this time unit will aply every time driver tries to find element it will apply 
		//for everything is here password,again username,again url,again for login
		//for driver to have enough time to identify the element it will wait until 10 seconds 
		//if its find befor 10 seconds over it wont use the whole 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://techfios.com/billing/?ng=login");           
	}

	@Test
	public void loginTest1() {
		System.out.println("test positive");

		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");// as soon we write By.id pop ups will come
																			// and we choose method id (string id)
		driver.findElement(By.id("password")).sendKeys("abc123");// sendkeys method comes with pop ups
																	// sendkeys(charsequnce means string and keys to
																	// send is value)
		driver.findElement(By.name("login")).click();
	}

	@Test
	public void loginTestNegetive() {
		System.out.println("test2");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");// we wrote username1 to fail the test but not as nagative test just to check exceptions
		driver.findElement(By.id("password")).sendKeys("abc123123");//wrong password for nagative test for this to run success fully we need to take off username1
		driver.findElement(By.name("login")).click();
}
    @After
	public void tearDown() {
		System.out.println("after");
		driver.close();
	}

	@AfterClass
	public static void afterTest() {
		System.out.println("after class");

	}
    
}
