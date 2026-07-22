package org.opencart.base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	protected static WebDriver driver;
	public Properties p;
	
	@BeforeClass(groups= {"Sanity", "Master"})
	@Parameters({"browser", "os"})
	public void setUp(String br, String os) throws IOException {
		
		//Loading confing.properties file
		try (FileReader file = new FileReader("./src//test//resources//config.properties")){
			p = new Properties();
			p.load(file);
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			if(br.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}
			else if(br.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
			else if(br.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}
			else {
				throw new IllegalArgumentException("Invalid Browser " + br);
			}
		}
		else if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			String hubUrl = p.getProperty("hubUrl");
			
			if(br.equalsIgnoreCase("chrome")) {
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setPlatformName(os);
				driver = new RemoteWebDriver(new URL(hubUrl), chromeOptions);
			}
			else if(br.equalsIgnoreCase("edge")) {
				EdgeOptions edgeOptions = new EdgeOptions();
				edgeOptions.setPlatformName(os);
				driver = new RemoteWebDriver(new URL(hubUrl), edgeOptions);
			}
			else if(br.equalsIgnoreCase("firefox")) {
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setPlatformName(os);
				driver = new RemoteWebDriver(new URL(hubUrl), firefoxOptions);
			}
			else {
				 throw new IllegalArgumentException("Invalid Browser " + br);
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(p.getProperty("appUrl"));
	}
	
	public String captureScreenshot(String tName) throws IOException {
		/*
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date date = new Date();
		String currentDateTimeStamp = dateFormat.format(date);
		*/
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot takesScreeshot = (TakesScreenshot)driver;
		File srcFile = takesScreeshot.getScreenshotAs(OutputType.FILE);
		
		String destFilePath = ".//screenshots//" + tName + "_" + timeStamp + ".png";
		File destFile = new File(destFilePath);
		
		FileUtils.copyFile(srcFile, destFile);
		
		return destFilePath;
	}
	
	@AfterClass(groups= {"Sanity", "Master"})
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
}
