package com.amazon.testpage;

import org.testng.annotations.Test;

import com.amazon.pages.WishListPage;
import com.util.JiraPolicy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class CreateWishList
{
	
	
	static String url = "https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F_encoding%3DUTF8%26ref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&";
	WebDriver driver;
	com.amazon.pages.WishListPage WP;
	String explistname1 = "Private!!!";
	String explistname2 = "Public";
	String explistname3 = "Private";
	String explistname4 = "Private";
	String explistname5 = "Apple iPhone 11 Pro Max (256GB) - Gold";
	String Del = "Delete";
	@BeforeClass
	public void beforeClass() throws InterruptedException
	{
		/*
		  System.out.println("====================");
				Email email = new SimpleEmail();
				email.setHostName("smtp.gmail.com");
				email.setSmtpPort(465);
				email.setAuthenticator(new DefaultAuthenticator("g.gaurav2812@gmail.com", "garje@2812$"));
				email.setSSLOnConnect(true);
				email.setFrom("g.gaurav2812@gmail.com");
				email.setSubject("Selenium TestMail");
				email.setMsg("This is a test mail ... :-)");
				email.addTo("g.gaurav1992@gmail.com");
				email.send();
				System.out.println("Email Sent");
			*/
		System.setProperty("webdriver.chrome.driver","C:\\Training\\Drivers\\chromedriver.exe");
		
		//WebDriverManager.getInstance(CHROME).setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Entering credentials to login to amazon
		driver.findElement(By.id("ap_email")).sendKeys("7058408881");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("Muk$45la");
		driver.findElement(By.id("signInSubmit")).click();

		//To handle Captcha if Captcha appears
		  String captchaText = "To better protect your account, please re-enter your password and then enter the characters as they are shown in the image below.";
		  try {
			  WebElement CaptchaHeadTxt = driver.findElement(By.xpath("//span[@class= 'a-list-item']")); // Captcha msg
		   while(captchaText.equals(CaptchaHeadTxt.getText())) { 
		    
		      //logger.trace("We are on captcha page");
		      // prompt user to enter captcha
		      String captchaVal1 = JOptionPane.showInputDialog("Please enter the captcha value : ");
		      WebElement CaptchaTextbox = driver.findElement(By.id("auth-captcha-guess"));
		      CaptchaTextbox.sendKeys(captchaVal1);
		      WebElement Password = driver.findElement(By.id("ap_password"));
		      Password.sendKeys("Muk$45la");
		      WebElement Loginbutton = driver.findElement(By.id("signInSubmit"));
		      Loginbutton.click();
		    		    }
		  } catch (Exception e) {
		   System.out.println("Captcha didn't appear..");
		  }
		  
	
		  //WP = new WishListPage(driver);
		  //WP.ChkAndDel();  
		  
		
	}

	@JiraPolicy(logTicketReady = true)
	@Test(priority = 1) // -------------------------------------- Default Shopping List
	public void FirstTest() throws InterruptedException
	{
		WP = new WishListPage(driver);
		WP.HoverAndClickOnCreateList("Create");
		WP.CreateBackGroundList();	
		String DefValue = WP.AssertDefaultList();
		Assert.assertEquals(DefValue, explistname1);

	}

	/*
	@Test(dependsOnMethods = "FirstTest") // --------------------------------------Electronics
	public void SecondTest() throws InterruptedException
	{
		
		WP.CreateElectroList();
		String ElecValue  = WP.AssertElecList();
		Assert.assertEquals(ElecValue, explistname2);
	}

	
	@Test(dependsOnMethods = "SecondTest") // -------------------------------------------Grocery
	public void ThirdTest() throws InterruptedException
	{
		WP.CreateGroceryList();
		String GrocValue  = WP.AssertGroceryList();
		Assert.assertEquals(GrocValue, explistname3);
	}

	@Test(dependsOnMethods = "ThirdTest") // ------------------------------------------------Phones
	public void FourthTest() throws InterruptedException
	{
		WP.CreateProductWish();
		WP.ClickAfterPhone();
		String PhonesVal = WP.AssertPhones();
		Assert.assertEquals(PhonesVal, explistname4);
	}

	@Test(dependsOnMethods = "FourthTest") // ---------------------------------------------------Phones2
	public void FifthTest() throws InterruptedException
	{
		WP.CreateProductTwo();		
		WP.ClickAfterItoElec();
		String AssertInElec = WP.AssertInElecList();
		Assert.assertEquals(AssertInElec, explistname5);
	
	}
	*/
	@BeforeMethod
	public void beforeMethod()
	{

	}

	@AfterMethod
	public void afterMethod() throws InterruptedException
	{

	}

	@AfterClass
	public void afterClass() throws InterruptedException
	{
		try 
		{ 
		while (driver.findElements(By.xpath("//*[@id='overflow-menu-popover-trigger']/div[2]")).size() > 0)
			{
				Thread.sleep(2000);
				WP.DeleteLists();
			}
		} 
		catch (Exception e)	// switching to another tab
		{ }
		driver.quit();
		
		
	}

}
