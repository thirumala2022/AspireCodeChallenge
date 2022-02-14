package TestPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.jcommander.ResourceBundle;
import com.google.common.collect.Table.Cell;

public class RegisterTest extends baseClass {
	
	@Test 
	public void ResterEmail() 
	{
	
		ob=new ObjectRepository(driver);	
		Reporter.log("Click on Register Link ");
	    ob.ClickElement(ob.eltRegLink);
	    
	    Reporter.log("Entered Full name of User");
     	ob.Sendtext(ob.eltfullName, prop.getProperty("FullName"));
     	
     	Reporter.log("Entered Full name of User");
		ob.Sendtext(ob.eltPreferredname, prop.getProperty("PreferredName"));
		
		Reporter.log("Entered NewEmail");
		ob.Sendtext(ob.eltNewEmail,  prop.getProperty("Email"));
		
		Reporter.log("Entered Phone");
		ob.Sendtext(ob.eltPhone, prop.getProperty("Mobile"));//
		ob.WaitElementExists(ob.eltPhone).sendKeys(Keys.TAB);
		
		Reporter.log("Entered Hear about us");		
		ob.Sendtext(ob.eltHearUs,  prop.getProperty("HearUs"));
		
		Reporter.log("Entered PrivacyCheck");		
		ob.ClickElement(ob.eltPrivacyCheck);
		
		Reporter.log("Click on Continue btn");
		ob.ClickElement(ob.eltContinuebtn);
		
		ob.WaitForElementExists(ob.eltNewOTP);
		Reporter.log("Enter Mobile OTP");
		ob.EnterOTP(ob.eltNewOTP, "1234");
		
		ob.WaitForElementExists(ob.eltRoleSection);
		String Details=ob.getInnerText(ob.eltRoleSection);
		Assert.assertEquals(Details, prop.getProperty("DetailsPageMessage"));
		
	}
	
	
	@AfterTest
	public void TestCleanUp() {
		//driver.quit();
	}
}
