package project.interview.selenium;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.base.Function;

/**
 * Handled Ajax page using, Thread.sleep(), Implicit Wait, WebDriverWait and
 * FluentWait.
 * 
 * This test will run in parallel on cross browsers such as, PhantomJS, Chrome,
 * InternetExplorer and Firefox.
 * 
 * @throws Exception
 * @author karthick.arunachalam
 *
 */
public class SeleniumWaits {
	WebDriver driver = null;

	String ajaxPages = "[href*='#page']";
	String ajaxContents = "#pageContent";
	String hrefUrl = "#pageContent>a";

	// Website.com
	String username = "#username";
	String password = ".loginPasswordField #password";
	String loginButton = "#signin-submit2";
	String header = "#manageSites>h1";
	String logout = ".mzFn>a";

	@Test(enabled = false)
	public void testCookiesHandling() throws Exception {
		String url = "https://www.website.com/sign-in/";
		driver.get(url);
		getElement(username).sendKeys("karthicksoftyster");
		getElement(password).sendKeys("Website@123");
		getElement(loginButton).click();
		Assert.assertEquals(getElement(header).getText(), "My Website");
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("Cookies collected...");
		System.out.println("Before adding cookies");
		for (Cookie cookie : cookies) {
			System.out.println(cookie);
		}
		System.out.println("==========================================================");
		Assert.assertTrue(getElement(logout).isDisplayed(), "Logout is not  displayed in the dom");
		driver.manage().deleteAllCookies();
		System.out.println("Deleted all cookies...");
		System.out.println("Cookies after deleting cookies");
		for (Cookie cookie : driver.manage().getCookies()) {
			System.out.println(cookie);
		}
		System.out.println("==========================================================");
		driver.navigate().refresh();
		Assert.assertNull(getElement(logout), "Still logout present in the dom");

		for (Cookie cookie : cookies) {
			if (!cookie.getDomain().contains("google.com")) {
				driver.manage().addCookie(cookie);
			}
		}
		System.out.println("==========================================================");
		System.out.println("Again added previous session's cookies");
		driver.navigate().refresh();
		System.out.println("After adding cookies");
		for (Cookie cookie : driver.manage().getCookies()) {
			System.out.println(cookie);
		}
		//Assert.assertNotNull(getElement(logout), "Logout is not displayed in the dom");
	}

	@Test
	public void testHandleAjaxPageUsingDifferentWaits() throws Exception {
		String url = "http://demo.tutorialzine.com/2009/09/simple-ajax-website-jquery/demo.html";
		driver.get(url);
		waitForPageToLoad();
		List<WebElement> pages = getElements(ajaxPages);

		pages.get(0).click();
		_getImplicitWait(5);
		Assert.assertTrue(getElement(ajaxContents).isDisplayed(), "Content is not displayed");

		pages.get(1).click();
		_getWebDriverWait(5, ajaxContents);
		/*
		 * hrefUrl won't present in the DOM. Remove comment in the below line to
		 * check how WebDriverWait works
		 */
		// _getWebDriverWait(5, hrefUrl);

		pages.get(2).click();
		_getFluentWait(6, ajaxContents);
		/*
		 * hrefUrl won't present in the DOM. Remove comment in the below line to
		 * check how FluentWait works
		 */
		// _getFluentWait(6, hrefUrl);

		pages.get(3).click();
		Thread.sleep(3000L);
		Assert.assertTrue(getElement(ajaxContents).isDisplayed(), "Content is not displayed");
	}

	public WebElement getElement(String locator) throws Exception {
		Object obj = getElement(locator, 30);
		if(obj != null) 
			return (WebElement) obj;
		else
			return null;
	}

	public WebElement getElement(String locator, int timeUnit) throws Exception {
		return _getWebDriverWait(timeUnit, locator);
	}

	public List<WebElement> getElements(String locator) throws Exception {
		return driver.findElements(By.cssSelector(locator));
	}

	public void waitForPageToLoad() throws Exception {
		((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
	}

	public void _getImplicitWait(int timeUnit) throws Exception {
		driver.manage().timeouts().implicitlyWait(timeUnit, TimeUnit.SECONDS);
	}

	public WebElement _getWebDriverWait(int timeUnit, String locator) throws Exception {
		try {
		WebDriverWait wait = new WebDriverWait(driver, timeUnit);
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
		}
		catch(TimeoutException e) {
			return null;
		}
	}

	public WebElement _getFluentWait(int timeUnit, final String locator) throws Exception {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeUnit, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		return wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.cssSelector(locator));
			}
		});
	}

	@BeforeTest
	@Parameters(value = { "browser", "exec" })
	public void initializeBrowser(String value, String executionFlag) throws Exception {
		DesiredCapabilities caps = null;
		if (value.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\MyDrivers\\chromedriver.exe");
			if (executionFlag.equals("local")) {
				System.out.println("Local Chrome constructed");
				driver = new ChromeDriver();
			} else {
				System.out.println("Remote Webdriver Constructed");
				caps = DesiredCapabilities.chrome();
				caps.setBrowserName("chrome");
				caps.setVersion("45.0");
				caps.setJavascriptEnabled(true);
				caps.setCapability("os.version", Platform.WINDOWS);
				driver = new RemoteWebDriver(new URL("http://192.168.128.219:8080/wd/hub"), caps);
			}
			driver.manage().window().maximize();
		} else if (value.equals("firefox")) {
			if (executionFlag.equals("local")) {
				System.out.println("Local Firefox constructed");
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\MyDrivers\\geckodriver.exe");
				//FirefoxProfile prof =  new FirefoxProfile();
				//FirefoxBinary bin = new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
				driver = new FirefoxDriver();
			} else {
				System.out.println("Remote Webdriver Constructed");
				caps = DesiredCapabilities.firefox();
				caps.setBrowserName("firefox");
				caps.setVersion("41.0");
				caps.setJavascriptEnabled(true);
				caps.setCapability("os.version", Platform.WINDOWS);
				driver = new RemoteWebDriver(new URL("http://192.168.128.219:8080/wd/hub"), caps);
			}
			driver.manage().window().maximize();
		} else if (value.equals("ie")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\MyDrivers\\IEDriverServer.exe");
			if (executionFlag.equals("local")) {
				System.out.println("Local IE constructed");
				driver = new InternetExplorerDriver();
			} else {
				System.out.println("Remote Webdriver Constructed");
				caps = DesiredCapabilities.internetExplorer();
				caps.setBrowserName("internet explorer");
				caps.setVersion("11");
				caps.setJavascriptEnabled(true);
				caps.setCapability("os.version", Platform.WINDOWS);
				driver = new RemoteWebDriver(new URL("http://192.168.128.219:8080/wd/hub"), caps);
			}
			driver.manage().window().maximize();
		} else if (value.equals("phantom")) {
			System.out.println("Local Phantom constructed");
			File file = new File(System.getProperty("user.dir")
					+ "\\MyDrivers\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
			System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
			driver = new PhantomJSDriver();
			driver.manage().window().maximize();
		} else {
			Assert.assertTrue(false, "Invalid browser");
		}
	}

	@AfterTest
	public void shutdown() throws Exception {
		driver.quit();
	}

}
