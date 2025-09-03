package Prudvi.Pageodbj;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Prudvi.basetest.Baseclass;
import Prudvi.basetest.Retry;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAlonetest extends Baseclass {
	@Test(dataProvider="getData",groups="Basicdetails",retryAnalyzer=Retry.class)
	public void Window(HashMap<String,String> input) throws Exception {
		// TODO Auto-generated method stub
		//initializerDriver();
		
		browserLaunch();
		//thu argument we will sent driver to other page class
		LandingPage landingpage= new LandingPage(driver);
		landingpage.goTo();
		Thread.sleep(1000);
		landingpage.loginPage("ONE","TWO");
		String Parentwindow=driver.getWindowHandle();
		//driver.findElement(By.id("newWindowsBtn")).click();
		landingpage.window3();
		Set<String> windowsList= driver.getWindowHandles();
		 for (String childWindow : windowsList){
			if(!childWindow.equals(Parentwindow)) {
				driver.switchTo().window(childWindow);
				driver.manage().window().maximize();
				Thread.sleep(2000);
				String windowtitle =driver.getCurrentUrl();
				if(windowtitle.contains("padding-to-containers")) {
					ProductCatalog productcatalog = new ProductCatalog(driver);
						productcatalog.formDetais(input.get("Firtsname"),input.get("Lastname"),input.get("email"),input.get("password"),input.get("repassword"));
					
					
				}else if(windowtitle.contains("basic-controls")) {
					BasicDetails basicDetails = new BasicDetails(driver);
						basicDetails.basicDetails(input.get("Firtsname"),input.get("Lastname"),input.get("email"),input.get("password"));
					
				
				}else {
					System.out.println("test case fail");
				}
				
			}
			
			
			
		}
}
	
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		//"C:\\Users\\user\\eclipse-workspace\\Pageodbj
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Prudvi\\data\\Basicdetail.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	
	}
	
	/*
	@DataProvider
	public Object[][] getData() {
		
		HashMap<String,String> map = new HashMap<String,String> ();
		map.put("Firtsname", "First Name");
		map.put("Lastname", "lastNameValue");
		map.put("email", "emailValue@gmail.com");
		map.put("password", "passwordValue");
		map.put("repassword", "repeatPasswordValue");
		
		HashMap<String,String> map1 = new HashMap<String,String> ();
		map1.put("Firtsname", "First Name");
		map1.put("Lastname", "lastNameValue");
		map1.put("email", "emailValue@gmail.com");
		map1.put("password", "passwordValue");
		map1.put("repassword", "repeatPasswordValue");
		return new Object[][] {{map},{map1}};
		
	//dataprovider	//return new Object[][] {{"First Name","lastNameValue","emailValue@gmail.com","passwordValue","repeatPasswordValue"},{"First Name1","lastNameValue1","emailValue1@gmail.com","passwordValue1","repeatPasswordValue1"}};
		
	}
	/*
	@DataProvider
	public Object[][] getData() {
		
		
		
return new Object[][] {{"First Name","lastNameValue","emailValue@gmail.com","passwordValue","repeatPasswordValue"},{"First Name1","lastNameValue1","emailValue1@gmail.com","passwordValue1","repeatPasswordValue1"}};
		
	}
	*/

}
