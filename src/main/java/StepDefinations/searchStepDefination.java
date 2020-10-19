package StepDefinations;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.ClickAction;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class searchStepDefination {

	WebDriver driver;

	@Given("^User is on search page$")
	public void user_is_on_search_page() {
		System.setProperty("webdriver.chrome.driver", "C://kalpana123//vinisha//ClearLabs//chromedriver.exe");
		driver = new ChromeDriver();

		/*
		 * String browserName = "chrome"; System.out.println(browserName); if
		 * (browserName.equals("chrome")) {
		 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
		 * + "\\driver\\chromedriver.exe"); driver = new ChromeDriver(); } else if
		 * (browserName.equals("firefox")) {
		 * System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
		 * "\\driver\\geckodriver.exe"); driver = new FirefoxDriver(); } else if
		 * (browserName.equalsIgnoreCase("ie")) {
		 * System.setProperty("webdriver.ie.driver", (System.getProperty("user.dir") +
		 * "\\drivers\\IEDriverServer.exe")); driver = new InternetExplorerDriver(); }
		 * else if (browserName.equalsIgnoreCase("edge")) {
		 * System.setProperty("webdriver.edge.driver", (System.getProperty("user.dir") +
		 * "\\drivers\\MicrosoftWebDriver.exe")); driver = new EdgeDriver(); }
		 */
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.expedia.com/");
	}

	@When("^Title of search page is expedia$")
	public void title_of_search_page_is_expedia() {
//		String title = driver.getTitle();
//		System.out.println(title);
//		Assert.assertEquals("Expedia Travel: Vacation Homes, Hotels, Car Rentals, Flights &amp",title);

	}

	@Then("^User enters search details$")
	public void user_enters_search_details() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"location-field-destination-menu\"]/div[1]/button")).sendKeys("Denver");
		driver.findElement(By.cssSelector(".uitk-typeahead-result-item:nth-child(2) .is-subText")).click();
		driver.findElement(By.id("d1-btn")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='d1-btn']"));

		WebElement table = driver.findElement(By.className("uitk-new-date-picker-weeks"));
		System.out.println("Expedia Calendar Dates");
		// store the date to pick..
		String sdate1 = "Nov 16, 2020";
		String ddate = "Nov 24, 2020";
		List<WebElement> cell = table.findElements(By.xpath("//tbody/tr/td/button"));
	//	System.out.println(cell.size());
		for (int i = 0; i < cell.size(); i++) {
		//	System.out.println(cell.get(i).getTagName());// Text())
			WebElement button = cell.get(i);// getTagName() ;
		//	System.out.println(button.getAttribute("aria-label"));
			;
			//source date selecting
			if (button.getAttribute("aria-label").equals(sdate1)) {
				button.click();
						}
			//destination date selecting

			if(button.getAttribute("aria-label").equals(ddate)) {
				button.click();
			}
		}
		driver.findElement(By.xpath("//span[contains(text(),'Done')]")).click();
		searchStepDefination sd = new searchStepDefination();
		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
		//assertion
		String assertion1= driver.findElement(By.xpath("//p[contains(text(),'Colorado may have travel restrictions in place due')]")).getText();
		System.out.println(assertion1);
		Assert.assertEquals("Colorado may have travel restrictions in place due to COVID-19.", assertion1);
        //place assertion
		String assertion2= driver.findElement(By.xpath("//span[contains(text(),'Denver, CO (DEN-Denver Intl.)')]")).getText();
		Assert.assertEquals("Denver, CO (DEN-Denver Intl.)", assertion2);
		driver.close();
		driver.quit();
        
	}
	
	
}
