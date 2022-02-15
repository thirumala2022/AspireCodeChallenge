package TestPackage;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

public class BusinessDetailsTest extends baseClass{

	@Test
	public void BusinessRoleTest()
	{
		
		Reporter.log("Business Role Selection and Aditional details Entry : Process");
		String EmailValue=prop.getProperty("Email2");
		BuisunessRole(EmailValue);
	}
	@Test
    public void BusinessDetailsTest1() {
		
		Reporter.log("Business Registration Process--->");
		String EmailValue=prop.getProperty("Email1");
		BusinessDetails(EmailValue);		
	}
	
	
	public void BusinessDetails(String Emaiid) {
		
		 BuisunessRole(Emaiid);
		
		Reporter.log("Learn More Button Click");	
		ob.ClickElement(ob.eltLearnMore);
		
		Reporter.log("Get Started Button Click");	
		ob.ClickElement(ob.eltGetStartedbtn);
		
		Reporter.log("Country Selection");	
		ob.comboBoxSelection(ob.eltCountry, prop.getProperty("country"));
		
		Reporter.log("Continue Button Click");	
		ob.ClickElement(ob.eltContinuebtn);
		
		ob.WaitForElementExists(ob.eltRemoteStartUp);
		Reporter.log("Package Selection Remort StartUp");	
		ob.ClickElement(ob.eltRemoteStartUp);
		
		Reporter.log("Enter desired Business Name");	
		ob.Sendtext(ob.eltDesiredBusinessName, prop.getProperty("DesiredBusinessName"));
		
		Reporter.log("Enter Live Business Website");
		ob.Sendtext(ob.eltBusinessURL, prop.getProperty("BusinessURL"));
		
		Reporter.log("Expected Number of Shareholders");
		ob.Sendtext(ob.eltNumShareHolder,  prop.getProperty("ShareHoldersNum"));
		
		Reporter.log("Set Financial Year End Date");
		ob.Sendtext(ob.eltFinYearEnd,  prop.getProperty("FinancialYearEnd"));
		
		
		Reporter.log("Submitting this information to incorporate an entity in Singapore : Check Box ");
		ob.ClickElement(ob.eltBusineessConfirmation);
		
		Reporter.log("Click on Continue button");
		ob.ClickElement(ob.eltContinuebtn);
		
		ob.WaitForElementExists(ob.eltDeatilsSubmitCheck);
		String SubmitConfirMsg=ob.getInnerText(ob.eltDeatilsSubmitCheck);
	}
	
	public void BuisunessRole(String EmailId) {
         ob=new ObjectRepository(driver);
		
		Reporter.log("Enter Email field");	
		ob.Sendtext(ob.eltEmail, EmailId);
		
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
