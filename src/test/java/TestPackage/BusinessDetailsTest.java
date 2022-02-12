package TestPackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BusinessDetailsTest {

	@Test(dataProvider="InputData")
	public void BusinessDetailsData(String[] Inputs) {
		System.out.println("************"+Inputs.length);
		
	}
	 @DataProvider

	 public Object[][] InputData() throws Exception{

	         Object[][] testObjArray = ExcelUtils.getTableArray("C:\\AspireQACodeChallenge1202\\AspireQACodeChallenge\\TestData\\TestData.xlsx","Sheet1");

	         return (testObjArray);

			}
}
