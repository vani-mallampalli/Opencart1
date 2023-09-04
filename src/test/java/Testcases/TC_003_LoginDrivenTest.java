package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Paeobjects.HomePae;
import Paeobjects.LoginPage;
import Paeobjects.MyAccountPage;
import TestBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDrivenTest extends BaseClass
{
	@Test(dataProvider="Opencart_LoginData",dataProviderClass=DataProviders.class)
	public void test_Login(String email,String pwd,String expres)
	{
		//Pages to interact homepage,LoginPage,MyAccountPage
		
		//1 HomePage
		try
		{
		logger.info(" TC_003_LoginDrivenTest is started");
		HomePae hp=new HomePae(driver);
		hp.clickmyAccount();
		hp.clickLogin();
		
		//2.LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		
		
		//3.MyAccountPage
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		if (expres.equalsIgnoreCase("Valid")) 
		{
			if (targetPage == true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			} 
			else 
			{
				Assert.assertTrue(false);
			}
		}

		if (expres.equalsIgnoreCase("Invalid")) 
		{
			if (targetPage == true) 
			{
				MyAccountPage myaccpage = new MyAccountPage(driver);
				myaccpage.clickLogout();
				Assert.assertTrue(false);
			} 
			else 
			{
				Assert.assertTrue(true);
			}
		}
		
	
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info(" TC_003_LoginDrivenTest is finished");
		
	}

}
