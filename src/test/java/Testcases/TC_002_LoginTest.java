package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Paeobjects.HomePae;
import Paeobjects.LoginPage;
import Paeobjects.MyAccountPage;
import TestBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	@Test(groups= {"sanity","master"})
	public void test_Login()
	{
		//Pages to interact homepage,LoginPage,MyAccountPage
		
		//1 HomePage
		try
		{
		logger.info("Test TC_002_LoginTest is started");
		HomePae hp=new HomePae(driver);
		hp.clickmyAccount();
		hp.clickLogin();
		
		//2.LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		lp.clickLogin();
		
		
		
		//3.MyAccountPage
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		Assert.assertEquals(targetPage, true);
		
		logger.info("Test TC_002_LoginTest is finished");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
		
	}

}
