package Prudvi.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Prudvi.Pageodbj.LandingPage;
import Prudvi.basetest.Baseclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination extends Baseclass{
	WebDriver driver;
	public LandingPage landingpage;
	@Given("Launch the browser")
	public void Launch_the_browser() throws Exception {
		
		driver=browserLaunch();
		 landingpage= new LandingPage(driver);
		landingpage.goTo();
		Thread.sleep(1000);
		
	
	}
	
	@When("^Entering the Text (.+) and (.+)$")
	public void entering_the_Text(String tex,String tex1) throws InterruptedException {
		landingpage.loginPage(tex,tex1);
		Thread.sleep(1000);
		
	}
	@Then("comparing the text")
	public void comparing_the_text() throws Exception {
		String Text=landingpage.getFieldText();
		System.out.println("Text"+Text);
		Assert.assertEquals("Button1", Text);
		
	
	}
	
	@Then("Reenter the Text")
	public void Reenter_the_Text() throws Exception {
		landingpage.clear();
		Thread.sleep(1000);
		landingpage.loginPage("thh","TWO");
		Thread.sleep(1000);
	}

}
