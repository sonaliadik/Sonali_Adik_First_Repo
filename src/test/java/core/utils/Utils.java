package core.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class Utils {
	public static WebDriver InvokeBrowser(String browser, String url) {
		try {
			WebDriver driver = null;
			// Browser Configured and Invoked
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver","C:\\Sonali\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "C:\\Sonali\\chromedriver.exe");
				// driver=new FirefoxDriver();
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
			driver.get(url);
			Utils.WriteLogs("pass", "Browser Chrome Invoked with URL as : " + url);
			return driver;
		} catch (Exception e) {
			Utils.WriteLogs("fail", "Unable to Invoke Browser. Type:" + browser + " URL:" + url);
			return null;
		}

	}

	public static void WriteLogs(String logType, String msg) {

		Reporter.log(logType + "-" + msg + "<br>", true);

	}

}
