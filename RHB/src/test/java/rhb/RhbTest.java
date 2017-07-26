package rhb;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class RhbTest {
	static RemoteWebDriver driver;

	@SuppressWarnings("rawtypes")
	@BeforeClass
	public void launchChrome() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "GT-I9300");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");

		capabilities.setCapability("chromedriverExecutable", "D://Abinash//RHB//Driver//chromedriver.exe");
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}

	@Test(priority = 1)

	public void launchApplication() throws InterruptedException {

		System.out.println("Application Launched");
		//System.out.println("we are doing continuous integration");
	

		Thread.sleep(3000);
		driver.get("https://www.rhbgroup.com/");

	}

	@Test(priority = 2)

	public void homeLoanCalculator() throws InterruptedException {
		driver.findElementByXPath("//button[@class='btn btn-menu-toggle'][@id='btn-menu-toggle']").isDisplayed();
		System.out.println("Application Launched Successfully");
		driver.findElementByXPath("//button[@class='btn btn-menu-toggle'][@id='btn-menu-toggle']").click();

		System.out.println("Click on Menu Button");
		Thread.sleep(2000);
		driver.findElementByXPath("//a[@id='rhbheaderplaceholder_0_menuListView_menuLink_2']").click();
		System.out.println("Click on Products & services");
		Thread.sleep(2000);
		driver.findElementByXPath("//a[@id='rhbheaderplaceholder_0_menuListView_menuListView2_2_menuLink2_0']").click();
		System.out.println("Click on  Personal");
		Thread.sleep(2000);
		driver.findElementByXPath(
				"//a[@id='rhbheaderplaceholder_0_menuListView_menuListView2_2_menuListView3_0_menuLink3_3']").click();
		System.out.println("Click on Loans");
		Thread.sleep(2000);
		driver.findElementByXPath(
				"//a[@id='rhbheaderplaceholder_0_menuListView_menuListView2_2_menuListView3_0_menuListView4_3_menuLink4_0']")
				.click();
		System.out.println("Click on Home Loans");
		Thread.sleep(7000);
		driver.findElementByXPath("//a[@id='rhbcontentplaceholder_0_productComponent_RHBEasy_detailLink_0']").click();
		System.out.println("Click on Home Loans");
		Thread.sleep(3000);
		driver.findElementByXPath(
				"//a[@id='rhbcontentplaceholder_0_productComponent_RHBEasy_productMenuList_0_productMenuLink_0']")
				.click();
		System.out.println("Click on My Full Flexi Home Loan");
		Thread.sleep(7000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement scroll = driver.findElement(By.xpath(
				"//a[@id='rhbcontentplaceholder_0_rhbdetailothersection_3_calculatorListView_modalPopupLink_0']"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		jse.executeScript("arguments[0].scrollIntoView(true);", scroll);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		scroll.click();
		System.out.println("Click on HOME LOAN CALCULATOR");
		Thread.sleep(3000);

		driver.findElementByXPath("//input[@id='txtLoanAmt']").sendKeys("100000");
		System.out.println("Enter Loan Amount");
		// driver.getKeyboard().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@id='txtInterestRate']").sendKeys("50000");
		System.out.println("Enter Interest Rate");
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@id='txtTerm']").sendKeys("10");
		System.out.println("Enter Term");
		Thread.sleep(3000);
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		WebElement scroll1 = driver.findElement(By.xpath("//input[@type='button'][@value='Calculate']"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		jse.executeScript("arguments[0].scrollIntoView(true);", scroll1);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		scroll1.click();
		System.out.println("Click on Calculate");

		driver.navigate().back();

	}

	@Test(priority = 3)

	public void homeAffordabilityCalculator() throws InterruptedException {
		driver.findElementByXPath("//a[@id='rhbcontentplaceholder_0_productComponent_RHBEasy_detailLink_0']").click();
		System.out.println("Click on Home Loans");
		Thread.sleep(3000);
		driver.findElementByXPath(
				"//a[@id='rhbcontentplaceholder_0_productComponent_RHBEasy_productMenuList_0_productMenuLink_0']")
				.click();
		Thread.sleep(7000);
		JavascriptExecutor jse0 = (JavascriptExecutor) driver;
		WebElement scroll0 = driver.findElement(By.xpath(
				"//a[@id='rhbcontentplaceholder_0_rhbdetailothersection_3_calculatorListView_modalPopupLink_1']"));
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		jse0.executeScript("arguments[0].scrollIntoView(true);", scroll0);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		scroll0.click();
		System.out.println("Click on HOME AFFORDABILITY CALCULATOR");
		Thread.sleep(3000);

		driver.findElementByXPath("//input[@id='txtincome']").sendKeys("100000");
		System.out.println("Enter Monthly Income");
		// driver.getKeyboard().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@id='txtdebts']").sendKeys("50000");
		System.out.println("Enter Total  Monthly Debt Payments");
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@id='txtrate']").sendKeys("50000");
		System.out.println("Enter Loan Interest Rate ");
		new Actions(driver).moveByOffset(608, 400).click().build().perform();
		Thread.sleep(5000);
		driver.findElementByXPath("//input[@id='txtterm']").sendKeys("10");
		Thread.sleep(3000);
		System.out.println("EnterTerm of the Loan");
		driver.findElementByXPath("//input[@id='txtpercentdown']").sendKeys("34");
		System.out.println("Enter Percent of Down Payment");
		new Actions(driver).moveByOffset(608, 400).click().build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='calculateHomeAffordability']")).click();
		System.out.println("Click on Calculate");
		driver.navigate().back();
		Thread.sleep(5000);

	}

	@Test(priority = 4)
	public void investment() throws InterruptedException {
		driver.findElementByXPath("//button[@class='btn btn-menu-toggle'][@id='btn-menu-toggle']").click();
		System.out.println("Click on Menu Button");
		Thread.sleep(2000);
		driver.findElementByXPath("//a[@id='rhbheaderplaceholder_0_menuListView_menuLink_2']").click();
		System.out.println("Click on Products & Services");
		Thread.sleep(2000);
		driver.findElementByXPath("//a[@id='rhbheaderplaceholder_0_menuListView_menuListView2_2_menuLink2_0']").click();
		System.out.println("Click on Personal");
		Thread.sleep(2000);
		driver.findElementByXPath(
				"//a[@id='rhbheaderplaceholder_0_menuListView_menuListView2_2_menuListView3_0_menuLink3_14']").click();
		System.out.println("Click on Investment");
		Thread.sleep(2000);
		driver.findElementByXPath(
				"//a[@id='rhbheaderplaceholder_0_menuListView_menuListView2_2_menuListView3_0_menuListView4_14_menuLink4_0']")
				.click();
		System.out.println("Click on ShareTrading");
		System.out.println("Click on ShareTrading");
		System.out.println("we are doing continuous integration");



	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		System.out.println("Application closed");

	}
}
