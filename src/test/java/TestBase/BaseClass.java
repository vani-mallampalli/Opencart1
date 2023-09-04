package TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	public ResourceBundle rb;
    public Logger logger;
    public static WebDriver driver;
@BeforeClass(groups= {"sanity","regression","master"})
@Parameters({"browser"})
public void setup(String br)

{
	rb=ResourceBundle.getBundle("config");
	logger=LogManager.getLogger(this.getClass());
	if(br.equals("chrome"))
	{
	driver=new ChromeDriver();
	}
	else if(br.equals("edge"))
	{
		driver=new EdgeDriver();
	}
	else
	{
		driver=new ChromeDriver();
	}
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(rb.getString("appURL"));
	//driver.get("https://tutorialsninja.com/demo");
	driver.manage().window().maximize();
	
}
@AfterClass(groups= {"sanity","regression","master"})
public void teardown()
{
	driver.close();
}
public String randomeString()
{
	String generatedString=RandomStringUtils.randomAlphabetic(5);
	return generatedString;
}
public String randomeNumber()
{
	String generatedString=RandomStringUtils.randomAlphabetic(5);
	return generatedString;
}
public String randomAlphaNumeric()
{
	String str=RandomStringUtils.randomAlphabetic(3);
	String num=RandomStringUtils.randomNumeric(3);
	
	return (str+"@"+num);
}
public String captureScreen(String tname) throws IOException {

	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
	String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

	try {
		FileUtils.copyFile(source, new File(destination));
	} catch (Exception e) {
		e.getMessage();
	}
	return destination;

}


}
