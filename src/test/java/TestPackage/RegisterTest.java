package TestPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.jcommander.ResourceBundle;
import com.google.common.collect.Table.Cell;

public class RegisterTest extends baseClass {
	
	@Test
	public void RegisterNewEmailTest() 
	{
        ob=new ObjectRepository(driver);		
		LoginEmailMobileInitialization();
		Reporter.log("Click on Register Link ");
	    ob.ClickElement(ob.eltRegLink);
	    
	    Reporter.log("Entered Full name of User");
     	ob.Sendtext(ob.eltfullName, prop.getProperty("FullName"));
     	
     	Reporter.log("Entered Full name of User");
		ob.Sendtext(ob.eltPreferredname, prop.getProperty("PreferredName"));
		
		Reporter.log("Entered NewEmail  "+Email);
		ob.Sendtext(ob.eltNewEmail,  Email);
		
		Reporter.log("Entered Phone "+ MobileNum);
		ob.Sendtext(ob.eltPhone, MobileNum);//
		//ob.WaitElementExists(ob.eltPhone).sendKeys(Keys.TAB);
		
		Reporter.log("Entered Hear about us");		
		ob.Sendtext(ob.eltHearUs,  prop.getProperty("HearUs"));
		
		Reporter.log("Entered PrivacyCheck");		
		ob.ClickElement(ob.eltPrivacyCheck);
		
		Reporter.log("Click on Continue btn");
		ob.ClickElement(ob.eltContinuebtn);
		
		ob.WaitForElementExists(ob.eltNewOTP);
		Reporter.log("Enter Mobile OTP");
		ob.EnterOTP(ob.eltNewOTP, prop.getProperty("OTP"));
		
		
		Reporter.log("Mobile Registraton success");
		ob.WaitForElementExists(ob.eltSuccessReg);
		String successMsg=ob.getInnerText(ob.eltSuccessReg);
		Assert.assertEquals(successMsg, prop.getProperty("MobileRegSuccess"));
					
	}
	
		
public void LoginEmailMobileInitialization()
{
	Email="QA"+ob.RandomGen()+"@gmail.com";
	MobileNum=ob.RandomGen();	
}
	
@AfterMethod 
public void screenShot(ITestResult result){

	
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
 
 @AfterTest
 public void CleanTest()
 {
	 driver.quit();
 }
}
