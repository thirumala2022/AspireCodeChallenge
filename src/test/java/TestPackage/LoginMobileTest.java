package TestPackage;

import org.testng.Assert;
import org.testng.Reporter;
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
	 @AfterTest
	 public void CleanTest()
	 {
		 driver.quit();
	 }

}
