package TestPackage;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ObjectRepository {
WebDriver _driver;
	//New User Regetsration

   public By eltRegLink=By.xpath("//span[text()='Register']");//
   public By eltfullName=By.xpath("//input[@name='full_name']");
   public By eltPreferredname=By.xpath("//input[@name='preferred_name']");
   public By eltNewEmail=By.xpath("//input[@name='email']");  
   public By eltPhone=By.xpath("//input[@name='phone']");
   public By eltHearUs=By.xpath("//input[@class='q-field__input q-placeholder col']");	
   public By eltplaceholder=By.xpath("//input[contains(@placeholder,'Enter the referral')]");
   public By eltPrivacyCheck=By.xpath("//div[contains(@class,'q-checkbox__inner relative-position non-selectable q-checkbox__inner')]");
   public By eltContinuebtn=By.xpath("//span[text()='Continue']");
 
   //Email Validation
	public By eltEmail=By.xpath("//input[@name='username']");	
	public By eltNext=By.xpath("//span[text()='Next']");
	public By eltOTP=By.xpath("//div[@class='digit-input__input-mask flex justify-between no-wrap']");
	

	
	JavascriptExecutor js=(JavascriptExecutor)_driver;
	
	
	public void SelectValue(By elt,String text)
	{
	Select sel=new Select(WaitElementExists(elt));
	sel.selectByVisibleText(text);
			
	}
   public void ClickElement(By elt) {
		
		WaitElementExists(elt).click();
		
	}

  public void EnterOTP(By elt,String str) {
	String[] StrArray=str.split("");
	
	
  WebElement NewElement=WaitElementExists(By.xpath("//div[@class='digit-input__input flex flex-center text-weight-medium cursor-pointer digit-input__input--highlight digit-input__input--blinking']"));
  
  NewElement.sendKeys(StrArray[2]);
	System.out.print("bbbbbbbbbbbbbbbbbbbb"+StrArray[2]+" "+StrArray[3]);
	//List<WebElement> lst=_driver.findElements(elt);//getAllElements(elt);
	
	
//	int i=0;
//	for(WebElement lstelt: lst) {
//		lstelt.sendKeys(StrArray[i]);
//		System.out.println(lstelt.getText());
//		i++;
//	}
	}
	public boolean IsDisplayed(By elt) {		
		
		return WaitElementExists(elt).isDisplayed();
	}
	public void Sendtext(By elt,String text) {
		
		WaitElementExists(elt).clear();
		WaitElementExists(elt).sendKeys(text);
		
	}
	
	
	List<WebElement> getAllElements(By elt)
	{
		WebDriverWait wait = new WebDriverWait(_driver,30);
		return wait.until(ExpectedConditions.visibilityOfAllElements(_driver.findElements(elt)));
	}
	public WebElement WaitElementExists(By elt) {
		
		WebDriverWait wait = new WebDriverWait(_driver,40);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(elt));
		
		 return element;
	}
	
	public void clickHiddenElement(By elt) 
	{
		js.executeScript("arguments[0].click();", WaitElementExists(elt));
	}
	
	public ObjectRepository(WebDriver driver) {
		this._driver=driver;
	}


}
