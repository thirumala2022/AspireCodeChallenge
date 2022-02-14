package TestPackage;

import org.apache.poi.util.SystemOutLogger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BusinessDetailsTest extends baseClass{

	@Test
	public void BusinessRoleTest() {
		
		Reporter.log("Business Role Selection and Aditional details Entry : Process");
		BuisunessRole();
	}
	
	@Test
	public void BusinessDetailsTest() {
		
		Reporter.log("Business Registration Process--->");
		
		BusinessDetails();
		
	}
	
	public void BusinessDetails() {
		
		BuisunessRole();
		
		Reporter.log("Learn More Button Click");	
		ob.ClickElement(ob.eltLearnMore);
		
		Reporter.log("Get Started Button Click");	
		ob.ClickElement(ob.eltGetStartedbtn);
		
		Reporter.log("Continue Button Click");	
		ob.ClickElement(ob.eltContinuebtn);
		
		Reporter.log("Package Selection Remort StartUp");	
		ob.ClickElement(ob.eltRemoteStartUp);
		
	}
	
	public void BuisunessRole() {
         ob=new ObjectRepository(driver);
		
		Reporter.log("Enter Email field");	
		ob.Sendtext(ob.eltEmail, "check123@gmail.com");
		
		Reporter.log("Click on Next");	
		ob.ClickElement(ob.eltNext);		
		
		ob.WaitElementExists(ob.eltNewOTP);
		ob.EnterOTP(ob.eltNewOTP, "1234");
		
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

	 public void InputData() throws Exception{

	         Object[][] testObjArray = ExcelUtils.getTableArray(".\\TestData\\TestData.xlsx","Sheet2");

	        // return (testObjArray);
	         for(Object[] S : testObjArray) {
	        	 for(Object s : S)
	        	 System.out.print(s+" ");
	        	 System.out.println();
	         }

			}
	 
	 @AfterTest
	 public void CleanTest()
	 {
		 driver.quit();
	 }
}
