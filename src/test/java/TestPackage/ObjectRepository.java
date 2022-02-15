package TestPackage;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	public By eltNewOTP=By.xpath("//div[@class='digit-input__input flex flex-center text-weight-medium cursor-pointer digit-input__input--highlight digit-input__input--blinking']");
	
	//Business Role
	public By eltBusinessRole=By.xpath("//div[contains(text(),'I am a non-registered')]");
	public By eltCompanyRegConfirmationCheck=By.xpath("//div[@class='q-checkbox__bg absolute']");
    public By eltPlaceHolderValue=By.xpath("//div[@class='business-role-step-additional-details__product-requests--multiple-placeholder']");
    public By eltPlaceholderSelection=By.xpath("//div[@class='q-item__label ellipsis']");
    public By eltFreelancerRole=By.xpath("//img[@src='img/auth/freelancer.svg']");
    public By eltRoleProcessValidation=By.xpath("//div[@class='text-weight-bold q-pb-xs']");
    public By eltRoleSection=By.xpath("//div[text()='Tell us more about yourself']");
    public By eltLearnMore=By.xpath("//span[text()='Learn more']");
    
    //Business details
    public By eltGetStartedbtn=By.xpath("//span[text()='Get Started']");
    public By eltCountry=By.xpath("//input[@icon-url='img/kyc/nationality.svg']");
    public By eltRemoteStartUp=By.xpath("//div[text()='Remote Startup']");
    
    public By eltDesiredBusinessName=By.xpath("//div[text()='Remote Startup']");
    public By eltBusinessURL=By.xpath("//input[@placeholder='Enter your business website URL']");
    public By eltNumShareHolder=By.xpath("//input[contains(@placeholder,'number of shareholders')]");       
    public By eltFinYearEnd=By.xpath("//input[@icon-url='img/common/labels/calendar.svg']");
    public By eltBusineessConfirmation=By.xpath("//div[@class='q-mb-lg']");
    public By eltLagOut=By.xpath("//span[text()='Log Out']");
    public By eltDeatilsSubmitCheck=By.xpath("//div[@class='q-checkbox__label q-anchor--skip']/div[1]");
    //Login  Validations
    
    public By eltMobileNumValidation=By.xpath("//div[text()='The entered phone number is invalid.']");
    public By eltEmailNumValidation=By.xpath("//div[text()='The entered email address is invalid.']");
    public By eltSuccessReg=By.xpath("//div[@class='aspire-cta-screen__content']");
    
    
	JavascriptExecutor js=(JavascriptExecutor)_driver;
	
	/* Select Drop Down value*/
	public void SelectValue(By elt,String text)
	{
	Select sel=new Select(WaitElementExists(elt));
	sel.selectByVisibleText(text);
			
	}
	
	/* Element Click*/
   public void ClickElement(By elt) {
		
		WaitElementExists(elt).click();
		
	}
   
	/* getInnerText of web element*/
   public String getInnerText(By elt) {
	   
	   return WaitElementExists(elt).getText();
   }

   /* Enter OTP in OPT WebElement*/
  public void EnterOTP(By elt,String str) {
	  Actions act = new Actions(_driver);
	String[] StrArray=str.split("");
	
	for(String s: StrArray)
	{
	act.sendKeys(s).build().perform();
     }
	}
  
  /* Whether Element is Displayed or not*/
	public boolean IsDisplayed(By elt) {		
		
		return WaitElementExists(elt).isDisplayed();
	}
	
	/*Text entry in TextBox field*/
	public void Sendtext(By elt,String text) {
		
		WaitElementExists(elt).clear();
		WaitElementExists(elt).sendKeys(text);
		
	}
    public void EnterTextAfterClear(By elt,String text) {
		
		WaitElementExists(elt).sendKeys(Keys.CONTROL + "a");
		WaitElementExists(elt).sendKeys(Keys.DELETE);
		WaitElementExists(elt).sendKeys(text);
		
	}
    
    public void comboBoxSelection(By elt,String text) {
    	
    	Sendtext(elt, text);
    	WaitElementExists(elt).sendKeys(Keys.ARROW_DOWN);
    	WaitElementExists(elt).sendKeys(Keys.ENTER);
    }
	
	public void MouseMoveClick(By elt,By elt2) {
		
		Actions act=new Actions(_driver);
		try {
			act.moveToElement(WaitElementExists(elt)).click();
			
			act.perform();
			act.moveToElement(WaitElementExists(elt2)).click();
			
			act.perform();
			
			
		}
		catch(Exception ex) {
			
			
			new WebDriverWait(_driver, 20).until((d-> 
			d.findElement(elt2))).click();
		}
	}
	List<WebElement> getAllElements(By elt)
	{
		WebDriverWait wait = new WebDriverWait(_driver,10);
		return wait.until(ExpectedConditions.visibilityOfAllElements(_driver.findElements(elt)));
	}
	public WebElement WaitElementExists(By elt) {
		
		WebDriverWait wait = new WebDriverWait(_driver,5);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(elt));
		
		 return element;
	}
	public WebElement WaitForElementExists(By elt) {
		try {
			WebDriverWait wait = new WebDriverWait(_driver,10);
			WebElement element=wait.until(ExpectedConditions.elementToBeClickable(elt));
			return element;
			}
			catch(Exception ex) {return null;}
			
			 
	}
	
	public void MouseClick(By elt) {
		
		Actions act=new Actions(_driver);
		act.moveToElement(WaitElementExists(elt)).click();
		act.perform();
	}
	public void clickHiddenElement(By elt) 
	{
		js.executeScript("arguments[0].click();", WaitElementExists(elt));
	}
 //Rondom number generator//
	public String RandomGen() {
		int min = 100000;  
		int max = 9999999;  
		return String.valueOf((int)(Math.random()*(max-min+1)+min)); 
	}
	
	public ObjectRepository(WebDriver driver) {
		this._driver=driver;
	}


}
