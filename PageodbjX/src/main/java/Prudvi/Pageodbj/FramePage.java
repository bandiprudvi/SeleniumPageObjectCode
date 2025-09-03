package Prudvi.Pageodbj;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Prudvi.Abstractclass.AbstractComponents;

public class FramePage extends AbstractComponents{
	
	WebDriver driver;
	
	JavascriptExecutor Jsexecutor;
	
	public FramePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		this.Jsexecutor = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="name")
	WebElement outerBox;
	
	@FindBy(id="frm1")
	WebElement frame1;
	
	@FindBy(id="frm2")
	WebElement frame2;
	
	@FindBy(id="frm3")
	WebElement frame3;
	
	@FindBy(id="navigateHome")
	WebElement navigateHome;
	
	@FindBy(id="selectnav1")
	WebElement frameOneSelectList;
	

	@FindBy(id="firstName")
	WebElement firstName;
	

	@FindBy(name="lName")
	WebElement lName;
	

	@FindBy(id="femalerb")
	WebElement femalerb;
	

	@FindBy(id="englishchbx")
	WebElement englishchbx;
	

	@FindBy(id="hindichbx")
	WebElement hindichbx;
	
	@FindBy(id="chinesechbx")
	WebElement chinesechbx;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="msg")
	WebElement msg;
	
	@FindBy(id="clearbtn")
	WebElement clearbtn;
	
	@FindBy(id="registerbtn")
	WebElement registerbtn;
	
	@FindBy(id="name")
	WebElement innerText;
	
public void outerText(String outerText) throws InterruptedException {
	 Jsexecutor.executeScript("arguments[0].scrollIntoView();",outerBox);
	outerBox.clear();
	outerBox.sendKeys(outerText);
	System.out.println(outerBox.getText());
	Thread.sleep(3000);
	
}

public void frameOne() throws InterruptedException {
	
	 Jsexecutor.executeScript("arguments[0].scrollIntoView();",frame1);
	 driver.switchTo().frame(frame1);
	 Thread.sleep(3000);
	
}

public void frameTwo() throws InterruptedException {
	
	Jsexecutor.executeScript("arguments[0].scrollIntoView();",frame2);
	driver.switchTo().frame(frame2);
	Thread.sleep(3000);
	//jsExecutor.executeScript("window.scrollBy(0,500)");
}

public void frameThree() throws InterruptedException {
	//frame 3
		driver.switchTo().frame(frame3);
		 Thread.sleep(3000);
	}

public void selectedDropdown(String visibleText, int index) throws InterruptedException {
	Select select = new Select(frameOneSelectList);
	Thread.sleep(3000);
	select.selectByVisibleText(visibleText);
	select.selectByValue("https://www.hyrtutorials.com/search/label/SQL");
	select.selectByIndex(index);
	Thread.sleep(3000);
}

public void defaultContent() {
	driver.switchTo().defaultContent();
}

public void parentFrame() throws InterruptedException {
	 driver.switchTo().parentFrame();
	 Thread.sleep(3000);
}

public String basicFormDetails(String firstNameText, String secondNameText,String emailText,String passwordText) throws InterruptedException {
	Jsexecutor.executeScript("arguments[0].scrollIntoView();",navigateHome);
	Thread.sleep(3000);
	firstName.sendKeys(firstNameText);
	lName.sendKeys(secondNameText);
	
	Jsexecutor.executeScript("arguments[0].scrollIntoView();",navigateHome);
	femalerb.click();
	englishchbx.click();
	hindichbx.click();
	if(hindichbx.isSelected()) {
		hindichbx.click();
	}
	chinesechbx.click();
	email.sendKeys(emailText);
	password.sendKeys(passwordText);
	registerbtn.click();
	String Text =msg.getText();
	System.out.println(Text);
	clearbtn.click();
	return Text;
}





public void innerText(String innerTextValue) {
	 Jsexecutor.executeScript("arguments[0].scrollIntoView();",innerText);
	 innerText.sendKeys(innerTextValue);
}



public void goTo()  {
	
	driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
	driver.manage().window().maximize();

	
	
}

	
}
