package com.BaseUsage;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import com.Utility.ReadConfigurations;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


@Listeners(FrameWorkListner.class)
abstract public class SuperScript
{
	ReadConfigurations rcf=new ReadConfigurations();
	public	String Browser=rcf.getBrowser();
	public String url=rcf.getApplicationURL();
	
	public 	ExtentHtmlReporter htmlReporter;
	public ExtentReports extent ; 
	
	public Logger log = Logger.getLogger(SuperScript.class);
	
	public  static WebDriver driver;
	
	@BeforeSuite
	public void extentReport()//extent report 
	{
		htmlReporter = new ExtentHtmlReporter("extent.html");
		htmlReporter.config().setDocumentTitle("Automation report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter); 
		extent.setSystemInfo("hostname", "localhost");
		extent.setSystemInfo("OS", "windows10");
		extent.setSystemInfo("Tester name", "shiva kumar");
		extent.setSystemInfo("Browser", "Chrome");

	}

	@BeforeTest
	public void preConfig()
	{
		/*	String url = ExcelOperations.readData("preconfig", 1,0);
		String Browser=ExcelOperations.readData("preconfig",1,1);
		System.out.println(url);
		System.out.println(Browser);*/


		if(Browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", ".//Driver//geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("ChromeDriver"))
		{
			log.info("****************************** Starting chrome browser  *****************************************");
			System.setProperty("webdriver.chrome.driver", ".//Driver//chromedriver.exe");
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("invalid Browser");
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterTest(enabled=false)
	public void postConfig()
	{
		driver.quit();
	}
	@AfterSuite
	public void tearDown()//extent report close
	{
		extent.flush();
	}
}


