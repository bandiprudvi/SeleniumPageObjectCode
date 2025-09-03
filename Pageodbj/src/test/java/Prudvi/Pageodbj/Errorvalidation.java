package Prudvi.Pageodbj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Prudvi.basetest.Baseclass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Errorvalidation extends Baseclass {
	@Test
	public void Error() throws Exception {
		// TODO Auto-generated method stub
		//initializerDriver();
		extent.createTest("Error");
		browserLaunch();
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
		tearDown();
		extent.flush();
	}
	
	

}
