package Prudvi.Pageodbj;

import org.testng.Assert;
import org.testng.annotations.Test;

import Prudvi.basetest.Baseclass;
import Prudvi.basetest.Retry;

public class Alerts extends Baseclass {
	
	@Test(groups= {"Alerts"},retryAnalyzer=Retry.class)
	public void AlertChecks() throws Exception {
		// TODO Auto-generated method stub
		//initializerDriver();
		
		driver=browserLaunch();
		Alertspage alertObj= new Alertspage(driver);
		Thread.sleep(2000);
		alertObj.goTo();
		Thread.sleep(2000);
		driver.navigate().refresh();
		alertObj.AlertBox();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		alertObj.ConfirmBox();
		driver.navigate().refresh();
		Thread.sleep(2000);
		String text="WELCOME";
		String acceptText=alertObj.promptBoxAccept(text);
		Assert.assertEquals(acceptText.contains(text), true);
		driver.navigate().refresh();
		Thread.sleep(2000);
		tearDown();
	}
	
	@Test(dependsOnMethods= {"AlertChecks"},groups= {"Alerts"})
	public void AlertDismiss() throws Exception {
		// TODO Auto-generated method stub
		initializerDriver();
		
		browserLaunch();
		Alertspage alertObj= new Alertspage(driver);
		Thread.sleep(2000);
		alertObj.goTo();
		Thread.sleep(2000);
		String text="Cancel";
		String acceptText=alertObj.promptBoxDismiss(text);
		Assert.assertEquals(acceptText.contains(text), true);
		tearDown();
	}

}
