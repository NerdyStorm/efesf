package com.techfios;
    import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	
	static WebDriver driver;//we call static so all the static methods can be able to use it

	public static void main(String[] args) {
		launchBrowser();
		loginTest();
        tearDown();
        // we calling both methods twice because we have to tests positive and negative
        launchBrowser();
		loginTestNegetive();
        tearDown();
	}
	public static void launchBrowser() {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\Kevadia\\QASeptember2021\\crm\\driver\\chromedriver.exe");
        // System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
        // System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");

		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver(); // we removed the local declaration of WebDriver
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://techfios.com/billing/?ng=login");
}
     public static void loginTest() {
        driver.findElement(By.id("username")).sendKeys("demo@techfios.com");//as soon we write By.id pop ups will come and we choose method id (string id)
		driver.findElement(By.id("password")).sendKeys("abc123");//sendkeys method comes with pop ups sendkeys(charsequnce means string and keys to send  is value)
		driver.findElement(By.name("login")).click();
		
	}
	public static void loginTestNegetive() {
        driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123123");
		driver.findElement(By.name("login")).click();
	
	}
	public static void tearDown() {
		driver.close();
	}

	

	}


