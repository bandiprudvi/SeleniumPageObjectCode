package Prudvi.Pageodbj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Prudvi.Abstractclass.AbstractComponents;

public class LandingPage  extends AbstractComponents {
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="name")
	WebElement outerBox;
	
	@FindBy(xpath="//h3[text()='Button1']")
	WebElement Textheader;
	
	By visibleElement = By.id("name");
	
	@FindBy(id="newWindowsBtn")
	WebElement thirdButton;
	
	public void loginPage(String Value1,String Value2) {
		
		outerBox.sendKeys(Value1);
		outerBox.sendKeys(Value2);
	}
	
	public String getFieldText() {
		
		String Text=Textheader.getText();
		
		
		return Text;
		
		}
	
public void window3() {
	
	thirdButton.click();
	
	}

public void clear() {
	
	outerBox.clear();
	
	}
public void goTo()  {
	driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
	driver.manage().window().maximize();
	elementVisiblity(visibleElement);
	
}



}
