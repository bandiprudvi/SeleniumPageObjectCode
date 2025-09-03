package Prudvi.Pageodbj;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//driver.findElement(By.id("name")).sendKeys("OUTPUT");
		//thu argument we will sent driver to other page class
	
		
		String Parentwindow=driver.getWindowHandle();
		driver.findElement(By.id("newWindowsBtn")).click();
		
		Set<String> windowsList= driver.getWindowHandles();
		 for (String childWindow : windowsList){
			
			if(!childWindow.equals(Parentwindow)) {
				driver.switchTo().window(childWindow);
				driver.manage().window().maximize();
				Thread.sleep(2000);
				String windowtitle =driver.getCurrentUrl();
				if(windowtitle.contains("padding-to-containers")) {
				//if(isElementPresents(driver,By.xpath("//input[@maxlength='10']"))) {
					Thread.sleep(2000);
					driver.findElement(By.xpath("//input[@maxlength='10']")).sendKeys("First Name");
					driver.findElement(By.xpath("//input[@maxlength='15']")).sendKeys("Last Name");
					driver.findElement(By.xpath("//label[text()='Email']//following-sibling::input")).sendKeys("RAJU@GMAIL.COM");
					//label[text()='Repeat Password']//following-sibling::input
					//(//input[@type="password"])[1]
					driver.findElement(By.xpath("(//input[@type=\"password\"])[1]")).sendKeys("Password");
					driver.findElement(By.xpath("//label[text()='Repeat Password']//following-sibling::input")).sendKeys("Password");
					JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
					WebElement Element1 = driver.findElement(By.xpath("//button[text()='Register']"));
					jsExecutor.executeScript("arguments[0].scrollIntoView();",Element1);
					driver.findElement(By.xpath("//button[text()='Register']")).click();
					
				}else if(windowtitle.contains("basic-controls")) {
				//else if (isElementPresents(driver,By.id("firstName"))) {
					Thread.sleep(2000);
					JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
					//jsExecutor.executeScript("window.scrollBy(0,500)");
					WebElement Element1 = driver.findElement(By.id("navigateHome"));
					jsExecutor.executeScript("arguments[0].scrollIntoView();",Element1);
					 Thread.sleep(3000);
					driver.findElement(By.id("firstName")).sendKeys("RAMU");
					driver.findElement(By.name("lName")).sendKeys("RAJU");
					jsExecutor.executeScript("arguments[0].scrollIntoView();",Element1);
					 Thread.sleep(1000);
					driver.findElement(By.id("femalerb")).click();
					Thread.sleep(3000);
					driver.findElement(By.id("englishchbx")).click();
					driver.findElement(By.id("hindichbx")).click();
					driver.findElement(By.id("chinesechbx")).click();
					Thread.sleep(3000);
					driver.findElement(By.id("email")).sendKeys("Raju@gmail.com");
					driver.findElement(By.id("password")).sendKeys("password@123");
					driver.findElement(By.id("registerbtn")).click();
					String output= driver.findElement(By.id("msg")).getText();
					System.out.println(output);
					driver.findElement(By.id("clearbtn")).click();
				}else {
					System.out.println("test case fail");
				}
				
			}
			
		}
		
	
		

	}
	
	/*
	 
	// TODO Auto-generated method stub
		//initializerDriver();
		
		browserLaunch();
		
		LandingPage landingpage= new LandingPage(driver);
		landingpage.goTo();
		Thread.sleep(1000);
	
		
		//driver.findElement(By.id("name")).sendKeys("OUTPUT");
		//thu argument we will sent driver to other page class
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
						productcatalog.formDetais("First Name", "lastNameValue" ,"emailValue@gmail.com","passwordValue","repeatPasswordValue");
					
					
				}else if(windowtitle.contains("basic-controls")) {
					BasicDetails basicDetails = new BasicDetails(driver);
						basicDetails.basicDetails("First Name", "lastNameValue" ,"emailValue@gmail.com","passwordValue");
					
				
				}else {
					System.out.println("test case fail");
				}
				
			}
	 */

}
