package Prudvi.Pageodbj;

import org.testng.annotations.Test;

import Prudvi.basetest.Baseclass;

public class FrameHandle extends Baseclass  {
	
	
	String outerTextValue="outerText";
	@Test(groups="FrameHandles")
	public void framesOneOperation() throws Exception {
		
		driver= browserLaunch();
		FramePage framePageObj = new FramePage(driver);
		framePageObj.goTo();
		framePageObj.outerText(outerTextValue);
		framePageObj.frameOne();
		framePageObj.selectedDropdown("Tech News", 1);
		Thread.sleep(3000);
		framePageObj.defaultContent();
		
	}
	
	@Test(groups="FrameHandles")
	public void framesTwoOperation() throws Exception {
		
		driver= browserLaunch();
		FramePage framePageObj = new FramePage(driver);
		framePageObj.goTo();
		framePageObj.outerText(outerTextValue);
		framePageObj.frameTwo();
		framePageObj.basicFormDetails("secoutput1", "output1", "output", "outerTextValue");
		//framePageObj.basicFormDetails(secoutput1, output1, output, outerTextValue);
		Thread.sleep(3000);
		framePageObj.defaultContent();
	}
	
	@Test(groups="FrameHandles")
	public void framesThreeOperation() throws Exception {
		
		driver= browserLaunch();
		FramePage framePageObj = new FramePage(driver);
		framePageObj.goTo();
		framePageObj.outerText(outerTextValue);
		framePageObj.frameThree();
		framePageObj.innerText("Text");
		 Thread.sleep(3000);
		framePageObj.frameOne();
		framePageObj.selectedDropdown("Tech News", 1);
		 Thread.sleep(3000);
		framePageObj.parentFrame();
		framePageObj.frameTwo();
		framePageObj.basicFormDetails("secoutput1", "output1", "output", "outerTextValue");
		 Thread.sleep(3000);
		//framePageObj.basicFormDetails(secoutput1, output1, output, outerTextValue);
		Thread.sleep(3000);
		framePageObj.defaultContent();
		 Thread.sleep(3000);
		framePageObj.outerText("OUTERLOOP DONE");
		
		 Thread.sleep(3000);
		
	}
	
	public void Ramam() {
		
	}
	

	
}
