package test.sneha;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class DriverManager {
	public static WebDriver driver;

	public DriverManager() {
		PageFactory.initElements(driver, this);
	}

	public void openBrowser() throws IOException {
		Properties properties = new Properties();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/config.properties");
		properties.load(file);
		properties.getProperty("browser");
		switch (properties.getProperty("browser")) {
		case "chrome":
			ChromeDriverManager.getInstance().setup();
			driver = new ChromeDriver();
			break;
		case "ie":
			InternetExplorerDriverManager.getInstance().setup();
			driver = new InternetExplorerDriver();
		default:
			driver = new FirefoxDriver();
			break;
		}

		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void closeBrowser() {
		driver.quit();
	}

}
