package TestPackage;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class BusinessRoleUnitTest extends baseClass {
	
	@Test
	public void BusinessRoleAditionalDetails() {
		 ob=new ObjectRepository(driver);
			
			Reporter.log("Enter Email field");	
			ob.Sendtext(ob.eltEmail,prop.getProperty("Email3"));
			
			Reporter.log("Click on Next");	
			ob.ClickElement(ob.eltNext);		
			
			ob.WaitElementExists(ob.eltNewOTP);
			ob.EnterOTP(ob.eltNewOTP,  prop.getProperty("OTP"));
			
			try {
			ob.WaitForElementExists(ob.eltBusinessRole);
			Reporter.log("Select Business Role");
			ob.MouseClick(ob.eltBusinessRole);
			//ob.ClickElement(ob.eltBusinessRole);
			}
			catch(Exception ex) {
				Reporter.log("Select catch block Business Role");			
				ob.MouseClick(ob.eltBusinessRole);
				
			}		
			
			Reporter.log("Company Registration Confirmation");	
			ob.ClickElement(ob.eltCompanyRegConfirmationCheck);
			
			Reporter.log("What you are look for drop down selection ");	
		   
			ob.MouseMoveClick(ob.eltPlaceHolderValue,ob.eltPlaceholderSelection);
			
			Reporter.log("Click on Continue");
		   ob.ClickElement(ob.eltContinuebtn);
		   
		   Reporter.log("Business Registration Confirmation Wait....");
		   ob.WaitForElementExists(ob.eltLearnMore);
		   String LearnMoretext=ob.getInnerText(ob.eltLearnMore);
		   Assert.assertEquals(LearnMoretext, prop.getProperty("LearnMorebtntext"));
		
	}
	
	@AfterMethod 
	public void screenShot(ITestResult result){
	
	if(ITestResult.FAILURE==result.getStatus())
		{
			try{
				
				TakesScreenshot screenshot=(TakesScreenshot)driver;				
				File src=screenshot.getScreenshotAs(OutputType.FILE);				
				File path=new File(".//ScreenShots//Image.png");
				FileUtils.copyFile(src,path);
				Reporter.log("<a href='"+ path.getAbsolutePath() + "'> <img src='"+ path.getAbsolutePath() + "' height='100' width='100'/>Screenshot Link</a>");
				System.out.println("Successfully captured a screenshot");
			}catch (Exception e){
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
		}
		}
	 
	 @AfterTest
	 public void CleanTest()
	 {
		 driver.quit();
	 }

}
