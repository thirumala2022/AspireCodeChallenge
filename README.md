# Project name : AspireCodeChallenge
## Pre-Requisites for project execution
- Eclipse IDE
- java version "11.0.12"
- Latest Chrome Driver  98.0.4758.82

## Running Examples
- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one).
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
###### Approach 1 :
  - Run the below command in Command Prompt, change the below file path to a locally saved project file path
```
cd C:\AspireQACodeChallenge1202\AspireQACodeChallenge
mvn clean install
```
###### Approach 2 :
- Open Eclipse 
   - File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
   - Select the right project
- Choose the AspireQACodeChallenge file
- Right Click on the file and Run as Maven test
###### Approach 3 :
- Right-click on Run.bat file and click on Edit -> change the file path to locally saved Project file path then Save and Close
- Run the Run.bat 

## 01 - Automation Framework design Approach

###### IDE & Language
   - Eclipse IDE & Java Language
###### Automation Tool
   - Selenium WebDriver
###### Project Type
   - Maven
###### Design Pattern
   - Page Object Model (POM)
###### DataDriven
   - Apache POI (Excel)
###### Browsers
   - Chrome Driver

## 02 - Test Scenarios

 - Scenario 01 - Verify users can able to Register with Mobile Num or Email Id or not
    1.	 Launch the Application 
    2.	Click on the Register button
    3.	 Enter all mandatory data and click on continue
    4.	Enter OTP and Verify user can Navigate to User role selection page or not by using the Assert function

 - Scenario 02 - Verify users can able to Register with Mobile Num or not
      1.	Launch the Application
      2.	Enter the Invalid Mobile number in the “Registered email or phone” text box
      3.	Click on the “Next” button
      4.	It will give you validation that “The entered phone number is invalid.”
      5.	If the mobile number has already registered Mobile Number then It ask for OTP
      6.	After Successful OTP entry 
      7.	Verify user can Navigate to User role selection page or not by using the Assert function
     
 - Scenario 03 - Verify user can able to select Business Role and provide the Additional details or not
      1.	Launch the Application 
      2.	Login by using  Mobile/Email and click on the Next button
      3.	After Successful entry of OTP the user navigated the Role selection page
      4.	User can select the relevant business Role 
      5.	User can give few Additional Details
      6.	After Entering all Personal details Click on the Continue button
      7.	Verify whether user navigate to Incorporate page or not
       
 - Scenario 04 - Verify users can able to Register with EmailId or not
      1.	Launch the Application
      2.	Enter the Invalid Email Id in the “Registered email or phone” text box
      3.	Click on the “Next” button
      4.	It will give you validation that “The entered email address is invalid.”
      5.	If the EmailId has already registered  then it ask for OTP
      6.	After Successful OTP entry 
      7.	Verify user can able to Navigate to User role selection page or not by using the Assert function
      
 - Scenario 05 - Verify user can Navigate to the Business Details page and enter the required information or not
    1.	Launch the Application 
    2.	Login by using  Mobile/Email and click on the Next button
    3.	After Successful entry of OTP the user navigated the Role selection page
    4.	User can select the relevant business Role 
    5.	User can give few Additional Details
    6.	After Entering all Personal details Click on the Continue button
    7.	User can Navigate to Business Details section and Enter Director Details->Select a Package->Additional Details
    8.	Click on the Continue button 
    9.	Verify user can view the incorporation success message or not
    10.	Click on Logout button

## 03 - Un-Scoped Test Scenario
 - Scenario 06 - Onboarding NPS 
      -Unable validate this feature in the given application
 
 ## 03 - Brief Description about class files
  - Reports and Logs are maintaining using TestNg and ScreenShots captured for failed scenarios
       - .\\test-output\\emailable-report.html
  - Java class file files Information :
 ```
 baseClass.java  => Static browser instance creation
 
 ObjectRepository.java => instantiated All Web Elements and Created Common Methods
 
ExcelUtil.java => created Excel Read Method

 RegisterTest.java => Email/Mobile registration Test Method
 
LoginEmailTest.java => Email Validation test method
                         Validated with Valid and Invalid Email entries this can be achieved by  Data-Driven Approach  
                         
LoginMobileTest.java => Mobile Login Validation 
                                       Validated with Valid and Invalid Mobile Numbers entries this can be achieved by  Data-Driven Approach 
              
BusinessDetailsTest.java => Business Role Selection and Business Details Test Methods

 ```
