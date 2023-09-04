package Testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import Paeobjects.AccountRegistrationPage;
import Paeobjects.HomePae;
import TestBase.BaseClass;

public class TC_001_AccountRegistratioin extends BaseClass
{
	@Test(groups= {"master","regression"})
	public void test_account_registration()
	{
		logger.info("......Started TC_001_AccountRegistratioin  test case.....");
		HomePae hp=new HomePae(driver);
		logger.info("Clicking MyAccount link");
		hp.clickmyAccount();
		logger.info("Clicking Registration link");
		hp.clickRegister();
		logger.info("Providing customers information");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomeString());
		
		String password=randomeString();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		String confmsg=regpage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
		logger.info("Registration successful...");
		Assert.assertTrue(true);
		}
		else
		{
			logger.error("Registration failed");
				Assert.fail();
		}
		
		
		logger.info("......Finished TC_001_AccountRegistratioin  test case.....");
				
		
	}
	
	
	

}
