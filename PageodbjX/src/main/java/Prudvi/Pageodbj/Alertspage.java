package Prudvi.Pageodbj;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Prudvi.Abstractclass.AbstractComponents;

public class Alertspage  extends AbstractComponents {
	
	WebDriver driver;
	Alert navigatingToAlert; 
	
	public Alertspage(WebDriver driver) 
	{
		super(driver);
		this.driver= driver;	
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(id="alertBox")
	WebElement alertBox;
	
	@FindBy(id="output")
	WebElement alertText;
	
	@FindBy(id="confirmBox")
	WebElement confirmBox;
	
	@FindBy(id="promptBox")
	WebElement promptBox;
	
	public void AlertBox() throws Exception 
	{
		
		
		System.out.println("Empty message"+alertText.getText());
		alertBox.click();
		Alert();
		System.out.println(navigatingToAlert.getText());
		Thread.sleep(1000);
		navigatingToAlert.accept();
		System.out.println("AlertBox message"+alertText.getText());
	}
	
	public void Alert()
	{
		navigatingToAlert =driver.switchTo().alert();
	}
	
	public void ConfirmBox() throws Exception
	{
		System.out.println("Empty message"+alertText.getText());
		confirmBox.click();
		Alert();
		System.out.println(navigatingToAlert.getText());
		Thread.sleep(1000);
		navigatingToAlert.accept();
		System.out.println("ConfirmBox Accept message"+alertText.getText());
		
		
		confirmBox.click();
		Alert();
		System.out.println(navigatingToAlert.getText());
		Thread.sleep(1000);
		navigatingToAlert.dismiss();
		System.out.println("ConfirmBox Dismiss message"+alertText.getText());
		
		}
	
	public String promptBoxDismiss(String cancel) throws Exception
	{
		
	promptBox.click();
	Alert();
	System.out.println(navigatingToAlert.getText());
	Thread.sleep(1000);
	navigatingToAlert.sendKeys(cancel);
	navigatingToAlert.dismiss();
	String Text = alertText.getText();
	System.out.println("ConfirmBox Dismiss message"+Text);
	return Text;
	
	}
	public String promptBoxAccept(String accept) throws Exception
	{
		
	System.out.println("Empty message"+alertText.getText());
	promptBox.click();
	Alert();
	System.out.println(navigatingToAlert.getText());
	Thread.sleep(1000);
	navigatingToAlert.sendKeys(accept);
	navigatingToAlert.accept();
	String Text = alertText.getText();
	System.out.println("PromptBox Accept message"+Text);
	Thread.sleep(1000);
	return Text;
	
	
	}

	public void goTo()  {
		
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		driver.manage().window().maximize();

		
		
	}
			
		
			
		
}
