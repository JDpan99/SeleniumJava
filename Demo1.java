package Demo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Stopwatch;
import com.google.common.io.Files;

public class Demo1 extends Thread{
	
	static WebDriver driver;
	Stopwatch watch;
	// ACC : cheayeow@rhbgroup.com
	private void LaunchFirefox(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://liferay02.proteg.space/");
		driver.manage().window().maximize();
	}
	
	private void EPLogin() throws InterruptedException {
		driver.findElement(By.id("button-login")).click();
		driver.findElement(By.id("_com_thebank_portal_liferay_custom_login_CustomLoginPortlet_input-email")).sendKeys("cheayeow@rhbgroup.com");
		Thread.sleep(20000);
		driver.findElement(By.id("_com_thebank_portal_liferay_custom_login_CustomLoginPortlet_button-next")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("_com_thebank_portal_liferay_custom_login_CustomLoginPortlet_input-password")));
		driver.findElement(By.id("_com_thebank_portal_liferay_custom_login_CustomLoginPortlet_input-password")).sendKeys("abcDEF123!!@#$$");
		
		wait.until(ExpectedConditions.elementToBeClickable
				(By.id("_com_thebank_portal_liferay_custom_login_CustomLoginPortlet_button-next")));
		driver.findElement(By.id("_com_thebank_portal_liferay_custom_login_CustomLoginPortlet_button-next")).click();
		wait.until(ExpectedConditions.elementToBeClickable
				(By.id("_com_thebank_portal_liferay_custom_login_CustomLoginPortlet_link-request-sms-otp")));
		driver.findElement(By.id("_com_thebank_portal_liferay_custom_login_CustomLoginPortlet_link-request-sms-otp")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//body/div[1]/div[3]/div[1]/div[2]/section[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/form[1]/div[4]/div[4]/div[4]/div[1]/input[1]")));
		driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[2]/section[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/form[1]/div[4]/div[4]/div[4]/div[1]/input[1]")).sendKeys("1");
		driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[2]/section[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/form[1]/div[4]/div[4]/div[4]/div[1]/input[2]")).sendKeys("2");
		driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[2]/section[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/form[1]/div[4]/div[4]/div[4]/div[1]/input[3]")).sendKeys("3");
		driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[2]/section[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/form[1]/div[4]/div[4]/div[4]/div[1]/input[4]")).sendKeys("4");
		driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[2]/section[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/form[1]/div[4]/div[4]/div[4]/div[1]/input[5]")).sendKeys("5");
		driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[2]/section[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/form[1]/div[4]/div[4]/div[4]/div[1]/input[6]")).sendKeys("6");
		wait.until(ExpectedConditions.elementToBeClickable
				(By.id("_com_thebank_portal_liferay_custom_login_CustomLoginPortlet_button-next")));
		driver.findElement(By.id("_com_thebank_portal_liferay_custom_login_CustomLoginPortlet_button-next")).click();	
	}
	
	private void ClickAvatar() throws InterruptedException, IOException {
		watch = Stopwatch.createStarted();
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//header/div[2]/div[1]/div[2]/ul[1]/li[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")));
		Thread.sleep(3000);
		WebElement Acc = driver.findElement(By.xpath("//header/div[2]/div[1]/div[2]/ul[1]/li[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]"));
		action.moveToElement(Acc);
		action.doubleClick(Acc);
		action.perform();
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(srcFile, new File("C:\\Users\\User\\Downloads\\TC\\Avatar.png"));
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//a[contains(text(),'Enquiries and Services')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Enquiries and Services')]")).click();
		System.out.println("Link to Enquire & Service.");
	}
	
	private void SimpleSearch()throws InterruptedException, IOException {
		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("_com_thebank_portal_liferay_enq_esc_EnqViewWebPortlet_redirect-view-service-desk")));
		File SDLink = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(SDLink, new File("C:\\Users\\User\\Downloads\\TC\\Servicedesk.png"));
		driver.findElement(By.id("_com_thebank_portal_liferay_enq_esc_EnqViewWebPortlet_redirect-view-service-desk")).click();
		System.out.println("Execution time is around " + watch.elapsed(TimeUnit.SECONDS) + " seconds");
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//button[contains(text(),'Search')]")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
		System.out.println("Search function success.");
		Thread.sleep(2000);
		System.out.println("Execution time of search function is around " + watch.elapsed(TimeUnit.SECONDS) + " seconds");
		File btnSearch = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(btnSearch, new File("C:\\Users\\User\\Downloads\\TC\\btnSearch.png"));

		WebElement MoreAction =driver.findElement(By.id("_com_thebank_portal_liferay_enq_scd_ServiceDeskWebPortlet_search-more-action-btn"));
		action.moveToElement(MoreAction);
		action.doubleClick(MoreAction).perform();
		System.out.println("More Action button success");
		System.out.println("Execution time of More Action button is around " + watch.elapsed(TimeUnit.SECONDS) + " seconds");
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//button[@id='_com_thebank_portal_liferay_enq_scd_ServiceDeskWebPortlet_download-btn']")));
		driver.findElement(By.xpath("//button[@id='_com_thebank_portal_liferay_enq_scd_ServiceDeskWebPortlet_download-btn']")).click();
		Thread.sleep(1000);
		File btnDownload = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(btnDownload, new File("C:\\Users\\User\\Downloads\\TC\\btnDownload.png"));
		
		driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
		System.out.println("Download & Cancel function success");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//button[contains(text(),'Reset')]")));
		driver.findElement(By.xpath("//button[contains(text(),'Reset')]")).click();
		System.out.println("Reset button success");
		System.out.println("Execution reset time is around" + watch.elapsed(TimeUnit.SECONDS) + "seconds");
		
		File btnReset = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(btnReset, new File("C:\\Users\\User\\Downloads\\TC\\Reset.png"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='_com_thebank_portal_liferay_enq_scd_ServiceDeskWebPortlet_serviceId']")).sendKeys("2022");
		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
		//Screenshot
		Thread.sleep(2000);
		System.out.println("Search ID success");
		System.out.println("Search ID execution time is around" + watch.elapsed(TimeUnit.SECONDS) + "seconds");
		File SearchID = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(SearchID, new File("C:\\Users\\User\\Downloads\\TC\\SearchID.png"));
		action.moveToElement(MoreAction);
		action.click(MoreAction);
		action.doubleClick(MoreAction).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("_com_thebank_portal_liferay_enq_scd_ServiceDeskWebPortlet_search-back-btn")));
		driver.findElement(By.id("_com_thebank_portal_liferay_enq_scd_ServiceDeskWebPortlet_search-back-btn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("_com_thebank_portal_liferay_enq_esc_EnqViewWebPortlet_redirect-view-service-desk")));
		File Final = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(Final, new File("C:\\Users\\User\\Downloads\\TC\\Final.png"));
		watch.stop();
		System.out.println("Total execution time is around" + watch.elapsed(TimeUnit.SECONDS) + "seconds");
	}
	
	public static void main(String[] args) {
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\User\\Desktop\\Selenium\\geckodriver-v0.33.0-win64\\geckodriver.exe");
		Demo1 st = new Demo1();
		st.LaunchFirefox();
		//Thread.sleep(2000);
		try {
			st.EPLogin();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			st.ClickAvatar();
		} catch (InterruptedException | IOException e) {
		}
		try {
			st.SimpleSearch();
		} catch (InterruptedException | IOException e) {

		}
		System.out.println("TC Success.");
		//st.QuitBrowser();
	}

}
