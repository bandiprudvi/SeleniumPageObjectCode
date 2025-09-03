package Prudvi.Pageodbj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtendReportClass {
	ExtentReports extent;
	WebDriver driver;
	
	@Test
	public void Error() throws Exception {
		// TODO Auto-generated method stub
		//initializerDriver();
		ExtentTest test=	extent.createTest("Error");
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		LandingPage landingpage= new LandingPage(driver);
		landingpage.goTo();
		Thread.sleep(1000);
		//driver.findElement(By.id("name")).sendKeys("OUTPUT");
		//thu argument we will sent driver to other page class
		landingpage.loginPage("ONE","TWO");
		Thread.sleep(1000);
		String Text=landingpage.getFieldText();
		System.out.println("Text"+Text);
		Assert.assertEquals("Button1", Text);
		test.fail("text");
		extent.flush();
	}
	
	@BeforeTest()
	public void config()  {
		
	String path = System.getProperty("user.dir")+"\\report\\pra.html";
	ExtentSparkReporter repoter = new ExtentSparkReporter(path);
	repoter.config().setReportName("Web Automation Result");
	repoter.config().setDocumentTitle("Test Result");
	
	 extent = new ExtentReports();
	extent.attachReporter(repoter);
	extent.setSystemInfo("Tester", "Prudvi");
		
			
		}

}
