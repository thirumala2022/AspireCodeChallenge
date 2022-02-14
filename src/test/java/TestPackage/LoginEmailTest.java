package TestPackage;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginEmailTest extends baseClass {
	
	@Test(dataProvider="InputData")
	public void LoginWithMobileValidation(String Email,String OTP) {
        ob=new ObjectRepository(driver);
		
		Reporter.log("Enter Email field");	
		ob.EnterTextAfterClear(ob.eltEmail, Email);
		
		Reporter.log("Click on Next");	
		ob.ClickElement(ob.eltNext);	
		
		try {			
		
		String validation=ob.getInnerText(ob.eltEmailNumValidation);
		Reporter.log("Entered Email ID is Invalid Please register");
			
		Assert.assertEquals(validation, prop.getProperty("ExpectedEmailvalidation"));
		}
		catch(Exception ex)
		{
			ob.WaitForElementExists(ob.eltNewOTP);
			ob.EnterOTP(ob.eltNewOTP, OTP);
			ob.WaitForElementExists(ob.eltRoleSection);
			ob.WaitForElementExists(ob.eltRoleSection);
			String Details=ob.getInnerText(ob.eltRoleSection);
			Reporter.log("Entered Email Id is Registered already");
			Assert.assertEquals(Details, prop.getProperty("DetailsPageMessage"));
			
			
		}
	}
	
	@DataProvider
	 public Object[][] InputData() throws Exception{

	         Object[][] testObjArray = ExcelUtils.getTableArray(".\\TestData\\TestData.xlsx","Sheet3");

	         return (testObjArray);
	        

			}

	 @AfterTest
	 public void CleanTest()
	 {
		 driver.quit();
	 }
}
