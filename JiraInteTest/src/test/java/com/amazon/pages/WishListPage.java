package com.amazon.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
	
	private WebDriver driver;
	public WishListPage(WebDriver driver) { 
		 // initializing instance variable with local variable
		 this.driver = driver;
		 // This initElements method will create all WebElemnts
		 PageFactory.initElements(driver, this);
		 }

	
	@FindBy(id="nav-link-accountList") 
	private WebElement AfterloginList; // Hello Test
	
	@FindBy (xpath="//span[text()='Create a Wish List' and @class='nav-text']")
	private WebElement CreateWishListbtn;
	
	@FindBy (xpath = "//span[text()='Shopping List' and @class='nav-text']")
	private WebElement ShopListExist;
	public void HoverAndClickOnCreateList(String AC) throws InterruptedException {
		
		//Hovering over the 'Sign in'  
		Actions move2actnlist = new Actions(driver);
		//WebElement AfterloginList = driver.findElement(By.id("nav-link-accountList")); // Hello Test
		//Thread.sleep(3000);
		move2actnlist.moveToElement(AfterloginList).build().perform(); //hover to get "Create a list" option
		//ClickOnCreateList();
		/*
		String add = "Create";
		String del = "Delete";
		if (AC.equals(add)) {
			ClickOnCreateList();	
		} else if(AC.equals(del)) {
			ClickOnExistShop();
		}
		*/
		
		
		
		if(CreateWishListbtn.isDisplayed()) {
		}else {
		try {
			AfterloginList.click();
		} catch (Exception e) {}
		}
		Thread.sleep(2000);
		CreateWishListbtn.click(); // clicking "create list option wish
		
	}

	public void ClickOnCreateList() throws InterruptedException {
		if(CreateWishListbtn.isDisplayed()) {
		}else {
		try {
			AfterloginList.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		}
		Thread.sleep(2000);
		CreateWishListbtn.click(); // clicking "create list option wish
	}
	
	
	// This is to click on Existing Shopping list for deleting
	public void ClickOnExistShop() throws InterruptedException {
		if(ShopListExist.isDisplayed()) {
			Thread.sleep(2000);
			ShopListExist.click(); // clicking "create list option wish
			DeleteLists();
		}else {
		try {
			AfterloginList.click();
			if(ShopListExist.isDisplayed()) {
				Thread.sleep(2000);
				ShopListExist.click(); // clicking "create list option wish
				DeleteLists();
			}
		} catch (Exception e) {}
		}
	}
	
	public void ChkAndDel() throws InterruptedException {
		Actions move2actnlist = new Actions(driver);
		move2actnlist.moveToElement(AfterloginList).build().perform(); //hover to get "Create a list" option
		if(ShopListExist.isDisplayed()) {
			try {
				Thread.sleep(2000);
				ShopListExist.click(); // clicking "create list option wish
				DeleteLists();
			} catch (Exception e) {}
			
		}else {
		try {
			AfterloginList.click();
			if(ShopListExist.isDisplayed()) {
				Thread.sleep(2000);
				ShopListExist.click(); // clicking "create list option wish
				DeleteLists();
			}
		} catch (Exception e) {}
		}
	}	
		

	
	
	
	@FindBy (xpath = "//span[@id='createList']/span/a") 
	private WebElement BackGrndCreateBtn;
	@FindBy (xpath = "//span[@class='a-button a-button-primary']") 
	private WebElement Createbtn;
	
	public void CreateBackGroundList() throws InterruptedException {
		try
		{
			BackGrndCreateBtn.click(); //GG clicking "create list" option when there is no list
			//driver.findElement(By.xpath("//span[@id='createList']/span/a")).click(); //VR clicking "create list" option when there is no list
		} 
		catch (Exception e) 
		{
			System.out.println("Create list background button did not appear");
		}

		Thread.sleep(2000);
		//WebElement Createbtn = driver.findElement(By.xpath("//span[@class='a-button a-button-primary']")); // clicking "Create a List" option
		Createbtn.click();
		
	}

	
	
	@FindBy (xpath = "//span[@class = 'a-color-base hover-as-link a-text-normal' and contains(text(),'Private')]")
	private WebElement TypeDefList;
	//driver.findElement(By.xpath("//span[@class = 'a-color-base hover-as-link a-text-normal' and contains(text(),'Private')]")).getText()
	public String AssertDefaultList() {
		String DefListName = TypeDefList.getText();
		return DefListName;
		// TODO Auto-generated method stub
		
	}

	@FindBy (xpath = "//a[@id = 'createList' and @class ='a-link-normal createListTrigger' ]") 
	private WebElement CreateList; // create list at top right corner
	@FindBy (xpath = "//input[@type='text' and @value = 'Shopping List 1' ]") 
	private WebElement Defaultlstname; // list name
	@FindBy (xpath = "//input[@class = 'a-button-input a-declarative' and @type= 'submit' and @aria-labelledby = 'WLNEW_privacy_public-announce']") 
	private WebElement PublicBtn;
	@FindBy (xpath = "//span[@data-action='reg-create-submit']//input[@type='submit']") 
	private WebElement SubmitBtn;
	
	
	public void CreateElectroList() {
		//WebElement CreateList = driver.findElement(By.xpath("//a[@id = 'createList' and @class ='a-link-normal createListTrigger' ]")); // create list at top right corner
		CreateList.click();
		//WebElement Defaultlstname = driver.findElement(By.xpath("//input[@type='text' and @value = 'Shopping List 1' ]")); // list name
		Defaultlstname.clear();
		Defaultlstname.sendKeys("Electronics");
		PublicBtn.click();
		//driver.findElement(By.xpath("//input[@class = 'a-button-input a-declarative' and @type= 'submit' and @aria-labelledby = 'WLNEW_privacy_public-announce']")).click(); // Public Button in Create a List
		SubmitBtn.click();
		//driver.findElement(By.xpath("//span[@data-action='reg-create-submit']//input[@type='submit']")).click();
		
	}

	@FindBy (xpath = "//span[contains(text(),'Electronics')]/ancestor::a//div//span[contains(text(),'Public')]") 
	private WebElement AssertElecBtn;
	
	public String AssertElecList() {
		String ElecValue = AssertElecBtn.getText();
		return ElecValue;
		
		
	}

	@FindBy (xpath = "//a[@id = 'createList' and @class ='a-link-normal createListTrigger' ]") 
	private WebElement CreateList1;
	@FindBy (xpath = "//input[@type='text' and @value = 'Shopping List 1' ]") 
	private WebElement Defaultlstname2;
	
	public void CreateGroceryList() throws InterruptedException {
		Thread.sleep(2000);
		//WebElement CreateList1 = driver.findElement(By.xpath("//a[@id = 'createList' and @class ='a-link-normal createListTrigger' ]"));
		CreateList1.click();
		//WebElement Defaultlstname2 = driver.findElement(By.xpath("//input[@type='text' and @value = 'Shopping List 1' ]"));
		Defaultlstname2.clear();
		Defaultlstname2.sendKeys("Grocery");
		SubmitBtn.click();
		//driver.findElement(By.xpath("//span[@data-action='reg-create-submit']//input[@type='submit']")).click();
		
	}

	@FindBy (xpath = "//span[contains(text(),'Grocery')]/ancestor::a//div//span[contains(text(),'Private')]") 
	private WebElement AsssertGrocBtn;
	
	public String AssertGroceryList() {
		String GrocValue = AsssertGrocBtn.getText();
		return GrocValue;
	}

	@FindBy (id = "twotabsearchtextbox")
	private WebElement SearchBox;
	@FindBy (xpath = "//span[text() = 'Apple iPhone 11 Pro Max (256GB) - Gold']//parent::a")
	private WebElement IphoneProduct;
	@FindBy (xpath = "//input[@id = 'add-to-wishlist-button']")
	private WebElement AddWishProdBtn;
	@FindBy (xpath = "//a[@id = 'atwl-dd-create-list']")
	private WebElement AddtoList;
	
	@FindBy (xpath = "//input[@type='text' and @value = 'Shopping List 1' ]")
	private WebElement Defaultlstname3;
	
	@FindBy (xpath = "//button[@type='button' and text()='Continue shopping']") 
	private WebElement ContinueShpBtn;
	
	public void CreateProductWish() throws InterruptedException {
		Thread.sleep(2000);
		SearchBox.sendKeys("iphone 11 pro max 256gb" + Keys.ENTER);
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 11 pro max 256gb" + Keys.ENTER);
		IphoneProduct.click();
		//driver.findElement(By.xpath("//span[text() = 'Apple iPhone 11 Pro Max (512GB) - Space Grey']")).click();
		Thread.sleep(2000);
		String MainWindow = driver.getWindowHandle();	// switching to another tab
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext())
		{
		String ChildWindow = i1.next();

		if (!MainWindow.equalsIgnoreCase(ChildWindow))
			{
			driver.switchTo().window(ChildWindow);
			
			AddWishProdBtn.click();
			//driver.findElement(By.xpath("//input[@id = 'add-to-wishlist-button']")).click();
			
			AddtoList.click();
			//driver.findElement(By.xpath("//a[@id = 'atwl-dd-create-list']")).click();
			//WebElement Defaultlstname3 = driver.findElement(By.xpath("//input[@type='text' and @value = 'Shopping List 1' ]"));
			Defaultlstname3.clear();
			Defaultlstname3.sendKeys("Phones");

			SubmitBtn.click();
			//driver.findElement(By.xpath("//span[@data-action='reg-create-submit']//input[@type='submit']")).click();
			ContinueShpBtn.click();
			//driver.findElement(By.xpath("//button[@type='button' and text()='Continue shopping']")).click();
			driver.close();
			}
		}
		
		driver.switchTo().window(MainWindow);

		
	}

	@FindBy (xpath = "//span[@class='nav-text' and text()='Phones']") 
	private WebElement PhonesList;
	public void ClickAfterPhone() throws InterruptedException {
		Actions move3actnlist = new Actions(driver);
		//WebElement AfterPhoneList = driver.findElement(By.id("nav-link-accountList"));
		Thread.sleep(2000);
		move3actnlist.moveToElement(AfterloginList).build().perform();
		
		if(PhonesList.isDisplayed()) {
		}else {
		try {
			Thread.sleep(2000);
			AfterloginList.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		}
		Thread.sleep(2000);
		//AfterPhoneList.click();
		PhonesList.click(); // clicking Phones after hover
		
	}
	
	@FindBy (xpath = "//span[contains(text(),'Phones')]/ancestor::a//div//span[contains(text(),'Private')]")
	private WebElement AssertPhonesBtn ;
	public String AssertPhones() {
		//driver.findElement(By.xpath("//span[contains(text(),'Phones')]/ancestor::a//div//span[contains(text(),'Private')]")).getText()
		String PhonesBtnVal = AssertPhonesBtn.getText();
		return PhonesBtnVal;
		
	}
	
	
	@FindBy (xpath = "//li[@class=\"a-dropdown-item\"]//span[contains(text(),'Electronics')]")
	private WebElement ElectronicsWishLis;
	
	public void CreateProductTwo() throws InterruptedException {
		Thread.sleep(3000);
		SearchBox.sendKeys("iphone 11 pro max 256gb" + Keys.ENTER);
		IphoneProduct.click();
		String MainWindow1 = driver.getWindowHandle();	// switching to another tab
		Set<String> s2 = driver.getWindowHandles();
		Iterator<String> i2 = s2.iterator();
		Thread.sleep(3000);
		
		while (i2.hasNext())
		{
			String ChildWindow1 = i2.next();
			if (!MainWindow1.equalsIgnoreCase(ChildWindow1))
			{
				driver.switchTo().window(ChildWindow1);
				AddWishProdBtn.click();
				ElectronicsWishLis.click();
				//WebElement Defaultlstname4 = driver.findElement(By.xpath("//input[@type='text' and @value = 'Shopping List 1' ]"));
				//Defaultlstname4.clear();
				//Defaultlstname4.sendKeys("Phones2");
				//driver.findElement(By.xpath("//input[@class = 'a-button-input a-declarative' and @type= 'submit' and @aria-labelledby = 'WLNEW_privacy_public-announce']")).click(); // Public Button in Create a List
				//driver.findElement(By.xpath("//span[@data-action='reg-create-submit']//input[@type='submit']")).click(); // clicking on Create List on Popup Box
				//ContinueShpBtn.click();
				driver.close();
			}

		}

		driver.switchTo().window(MainWindow1);

		
	}

	
	@FindBy (xpath = "//span[@class='nav-text' and text()='Electronics']")
	private WebElement InElecWishLis;
	public void ClickAfterItoElec() throws InterruptedException {
		Actions move5actnlist = new Actions(driver);
		//WebElement AfterPhone2List = driver.findElement(By.id("nav-link-accountList"));
		Thread.sleep(2000);
		move5actnlist.moveToElement(AfterloginList).build().perform();

		if(InElecWishLis.isDisplayed()) {
		}else {
		try {
			Thread.sleep(2000);
			AfterloginList.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		}
		Thread.sleep(2000);
		//AfterPhone2List.click();
		InElecWishLis.click(); // clicking Phones after hover

		
	}
	
	@FindBy (xpath = "//a[contains(text(),'Apple iPhone 11 Pro Max (256GB) - Gold')]")
	private WebElement AssertInElec;
	public String AssertInElecList() {
		String InElecBtnVal = AssertInElec.getText();
		return InElecBtnVal;
		
	}
	
	@FindBy (xpath = "//*[@id='overflow-menu-popover-trigger']/div[2]")
	private WebElement MoreOption; // More Element
	@FindBy (xpath = "//a[@id = 'editYourList']")
	private WebElement EditList; // manage list element
	@FindBy (xpath = "//*[@id='list-settings-container']/span/span/span/input") 
	private WebElement Element;
	@FindBy (xpath = "//input[@name='submit.save' and @type='submit']")
	private WebElement ElementYESbutton;
	
	
	
	public void DeleteLists() throws InterruptedException {
		int MoreOptions = driver.findElements(By.xpath("//*[@id='overflow-menu-popover-trigger']/div[2]")).size();
		try 
		{ 
		while (MoreOptions > 0)
			{
				Thread.sleep(2000);
				//WP.DeleteLists();
				
		Actions moredropdown = new Actions(driver);
		//WebElement MoreOption = driver.findElement(By.xpath("//*[@id=\"overflow-menu-popover-trigger\"]/div[2]")); // More Element
		moredropdown.moveToElement(MoreOption).build().perform();
		EditList.click(); // manage list element
		//WebElement Element = driver.findElement(By.xpath("//*[@id=\"list-settings-container\"]/span/span/span/input"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Element.click();
		Thread.sleep(2000);
		//WebElement ElementYESbutton = driver.findElement(By.xpath("//input[@name='submit.save' and @type=\"submit\"]"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;				
		js1.executeScript("arguments[0].click();", ElementYESbutton);
		System.out.println("CLicking on Delete button");
			}
		} 
		catch (Exception e)	// switching to another tab
		{ 
		}
		//driver.quit();
		
	}

	
	
	

	

}
