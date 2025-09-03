package Prudvi.Pageodbj;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Prudvi.Abstractclass.AbstractComponents;

public class BasicDetails extends AbstractComponents {
	WebDriver driver;
	public  BasicDetails(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	

	



	@FindBy(id="firstName")
	WebElement firstName;
	
	@FindBy(id="lastName")
	WebElement lastName;
	
	@FindBy(id="femalerb")
	WebElement female;
	
	@FindBy(id="englishchbx")
	WebElement englishBox;
	
	@FindBy(id="hindichbx")
	WebElement hindiBox;
	
	@FindBy(id="chinesechbx")
	WebElement chineseBox;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="registerbtn")
	WebElement submitRegister;
	
	@FindBy(id="msg")
	WebElement textMessage;
	
	@FindBy(id="clearbtn")
	WebElement clearButton;
	
	@FindBy(id="navigateHome")
	WebElement navigateHome;
	
	
	
	
	public void basicDetails(String firstNameValue, String lastNameValue ,String emailValue,String passwordValue) throws Exception {
		
		Thread.sleep(2000);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		//jsExecutor.executeScript("window.scrollBy(0,500)");
		jsExecutor.executeScript("arguments[0].scrollIntoView();",navigateHome);
		 Thread.sleep(3000);
		firstName.sendKeys(firstNameValue);
		lastName.sendKeys(lastNameValue);
		female.click();
		Thread.sleep(1000);
		englishBox.click();
		hindiBox.click();
		chineseBox.click();
		Thread.sleep(1000);
		email.sendKeys(emailValue);
		password.sendKeys(passwordValue);
		submitRegister.click();
		System.out.println(textMessage.getText());
		clearButton.click();
	
		
	}
	
	

}
