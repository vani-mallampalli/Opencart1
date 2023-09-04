package Paeobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePae extends BasePage
{
WebDriver driver;

	//Constructor
	public HomePae(WebDriver driver)
	{
		super(driver);
	}
	
	//Elements
	//My Account ,Register ,login

@FindBy(xpath="//a[@title='My Account']") WebElement myAccountlink;
@FindBy(xpath="//a[normalize-space()='Register']") WebElement registerlink;
@FindBy(xpath="//a[normalize-space()='Login']") WebElement loginlink;

//ActionMetods

public void clickmyAccount()
{
	myAccountlink.click();
}
public void clickRegister()
{
	registerlink.click();
}
public void clickLogin()
{
	loginlink.click();
}
	

}
