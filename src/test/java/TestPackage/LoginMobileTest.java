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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginMobileTest extends baseClass {
	
	@Test(dataProvider="InputData")
	public void LoginWithMobileNumValidation(String MobileNum,String OTP) {
		
        ob=new ObjectRepository(driver);
		
		Reporter.log("Enter Email field");	
		ob.EnterTextAfterClear(ob.eltEmail, MobileNum);
		
		Reporter.log("Click on Next");	
		ob.ClickElement(ob.eltNext);	
		
		try {
			
		
		String validation=ob.getInnerText(ob.eltMobileNumValidation);
		Reporter.log("Entered Mobile number is Invalid Mobile Please register");
			
		Assert.assertEquals(validation, prop.getProperty("ExpectedMobilevalidation"));
		}
		catch(Exception ex)
		{
			ob.WaitForElementExists(ob.eltNewOTP);
			ob.EnterOTP(ob.eltNewOTP, OTP);
			ob.WaitForElementExists(ob.eltRoleSection);
			ob.WaitForElementExists(ob.eltRoleSection);
			String Details=ob.getInnerText(ob.eltRoleSection);
			Reporter.log("Entered Mobile number is Registered already");
			Assert.assertEquals(Details, prop.getProperty("DetailsPageMessage"));
			
			
		}
		
	}
	
	@DataProvider
	 public Object[][] InputData() throws Exception{

	         Object[][] testObjArray = ExcelUtils.getTableArray(".\\TestData\\TestData.xlsx","Sheet2");

	         return (testObjArray);
	        

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
