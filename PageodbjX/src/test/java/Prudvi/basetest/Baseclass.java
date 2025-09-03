package Prudvi.basetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Prudvi.Pageodbj.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	private static final String StandardCharset = null;
	public WebDriver driver;
	public LandingPage landingpage;
	public ExtentReports extent;
	//http://localhost:8080/
	public  WebDriver initializerDriver() throws Exception {
		/*
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		*/
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Prudvi\\resource\\GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");//for running test cases from terminal(need to give perferance to terminal) if user give specific browser to run like firefox
		//String browserName = prop.getProperty("browser");// for normal useage
		if(browserName.contains("chrome")){
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless")) {
			options.addArguments("headless");
			}
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver(options);
			 //driver.manage().window().setSize(new Dimension(1440,900));
			
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			//firefox
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			//edge
		}
		
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public List<HashMap<String,String>> getJsonDataToMap(String filePath) throws IOException 
	{
		//read json to string											///		encoding format: StandardCharsets.UTF_8
	String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
	//string to HashMap-jackson Datbind in mvn repository
	
	ObjectMapper mapper = new ObjectMapper();//for access readvalue method in ObjectMapper class
	List<HashMap<String,String>> data=	mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
	//map,map1
	return data;
	
	
	}
	
/*	
@BeforeTest(alwaysRun=true)
	
	public void config()  {
		
	String path = System.getProperty("user.dir")+"\\report\\index.html";
	ExtentSparkReporter repoter = new ExtentSparkReporter(path);
	repoter.config().setReportName("Web Automation Result");
	repoter.config().setDocumentTitle("Test Result");
	
	 extent = new ExtentReports();
	extent.attachReporter(repoter);
	extent.setSystemInfo("Tester", "Prudvi");
		
			
		}
		*/
	
	@BeforeMethod(alwaysRun=true)
	
	public WebDriver browserLaunch() throws Exception {
		
		driver=initializerDriver();
		
	return driver;
		
			
		}
		
	
	
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() throws Exception {
		
		driver.quit();
		
	}
	
	//@BeforeMethod
	public LandingPage launchApplication() throws Exception {
		
		driver=initializerDriver();
		LandingPage landingpage= new LandingPage(driver);
		landingpage.goTo();
		return landingpage;
		
	}
	
	public String getScreenShot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=	(TakesScreenshot)driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//report//"+testCaseName+".png");
		FileUtils.copyFile(Source, file);
		return System.getProperty("user.dir")+"//report//"+testCaseName+".png";
		
		
	}
	
	
}
