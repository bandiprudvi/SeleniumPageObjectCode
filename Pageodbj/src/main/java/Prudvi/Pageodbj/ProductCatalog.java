package Prudvi.Pageodbj;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Prudvi.Abstractclass.AbstractComponents;

public class ProductCatalog  extends AbstractComponents{
	
	WebDriver driver;
	
	public  ProductCatalog(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		//for webelements insilization for driver access
		
	}
	
	

	


	@FindBy(xpath="//input[@maxlength='10']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@maxlength='15']")
	WebElement lastName;
	
	@FindBy(xpath="//label[text()='Email']//following-sibling::input")
	WebElement email;
	
	@FindBy(xpath="(//input[@type='password'])[1]")
	WebElement password;
	
	@FindBy(xpath="//label[text()='Repeat Password']//following-sibling::input")
	WebElement repeatPassword;
	
	@FindBy(xpath="//button[text()='Register']")
	WebElement submitRegister;
	
	public BasicDetails formDetais(String firstNameValue, String lastNameValue ,String emailValue,String passwordValue,String repeatPasswordValue) throws Exception {
		
		Thread.sleep(2000);
		firstName.sendKeys(firstNameValue);
		lastName.sendKeys(lastNameValue);
		email.sendKeys(emailValue);
		password.sendKeys(passwordValue);
		repeatPassword.sendKeys(repeatPasswordValue);
		//WebElement Element1 = driver.findElement(By.xpath("//button[text()='Register']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView();",submitRegister);
		submitRegister.click();
		
		BasicDetails basicDetails = new BasicDetails(driver);
		
		return basicDetails;
		
		
	}
	
	

}
