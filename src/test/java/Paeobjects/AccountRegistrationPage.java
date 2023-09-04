


package Paeobjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage

{
	WebDriver driver;

	//Constructor
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Create elements Locators

@FindBy(xpath="//input[@id='input-firstname']") WebElement txt_firstname;
@FindBy(xpath="//input[@id='input-lastname']") WebElement txt_lastname;
@FindBy(xpath="//input[@id='input-email']") WebElement txt_email;
@FindBy(xpath="//input[@id='input-telephone']") WebElement txt_telepone;
@FindBy(xpath="//input[@id='input-password']") WebElement txt_pwd;
@FindBy(xpath="//input[@id='input-confirm']") WebElement txt_confpwd;
@FindBy(xpath="//input[@name='agree']") WebElement che_policy;
@FindBy(xpath="//input[@value='Continue']") WebElement btn_continue;
@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;


//ActioinMethods
public void setFirstName(String fname) 
{
	txt_firstname.sendKeys(fname);

}

public void setLastName(String lname) 
{
	txt_lastname.sendKeys(lname);

}

public void setEmail(String email) 
{
	txt_email.sendKeys(email);

}

public void setTelephone(String tel) 
{
	txt_telepone.sendKeys(tel);

}

public void setPassword(String pwd) 
{
	txt_pwd.sendKeys(pwd);

}

public void setConfirmPassword(String pwd) 
{
	txt_confpwd.sendKeys(pwd);

}

public void setPrivacyPolicy() 
{
	che_policy.click();

}
public void clickContinue() 
{
	//sol1 
	btn_continue.click();
	
	//sol2 
	//btnContinue.submit();
	
	//sol3
	//Actions act=new Actions(driver);
	//act.moveToElement(btnContinue).click().perform();
				
	//sol4
	//JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("arguments[0].click();", btnContinue);
	
	//Sol 5
	//btnContinue.sendKeys(Keys.RETURN);
	
	//Sol6  
	//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	
}
public String getConfirmationMsg() 
{
	try 
	{
		return (msgConfirmation.getText());
	} 
	catch (Exception e)
	{
		return (e.getMessage());

	}


}
}
