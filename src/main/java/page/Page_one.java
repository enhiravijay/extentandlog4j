package page;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;





//there are two types of listner one is testng listner and other is selenium webdriver listner.
//on class level you have to define testng listner here on suite level in testng.xml
//@Listeners(page.TestNgListener.class)
public class Page_one {
	//https://github.com/LearnByBhanuPratap/seleniumBasic.git
	//public static Logger log = Logger.getLogger(Page_one.class);
	
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static ExtentTest test;
	
	
	public WebDriver dr;
	public WebEventListener eventListener;
	public EventFiringWebDriver driver;
	
	@BeforeTest
	public void startReport(String OS, String browser) {
    	// initialize the HtmlReporter
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"//test-output//testReport.html");
        
        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
         
        //To add system or environment info by using the setSystemInfo method.
        extent.setSystemInfo("OS", OS);
        extent.setSystemInfo("Browser", browser);
        
        //configuration items to change the look and feel
        //add content, manage tests etc
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Extent Report Demo");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }
	@Test
	private void firstMethod() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("This is first Method");
		//log.info("this is log message printed");
		

		System.setProperty("webdriver.chrome.driver", "C://Users//ADMIN//Downloads//Selenium//eclipse-jee-mars-2-win32//eclipse//chromedriver.exe");
		dr = new ChromeDriver();
		
		test = extent.createTest("firstMethod", "PASSED test case");
		driver = new EventFiringWebDriver(dr);
		eventListener = new WebEventListener();  
		driver.register(eventListener);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String vUrl = "https://www.google.com/?gws_rd=ssl";
		driver.navigate().to(vUrl);
		driver.findElement(By.xpath("//div/a[@class='gb_e']")).click();
		driver.get(vUrl);
		Assert.assertTrue(true);
		
	}
	
	@Test
    public void testCase2() {
        test = extent.createTest("Test Case 2", "PASSED test case");
        Assert.assertTrue(false);
    }
	
	@AfterTest
    public void tearDown() {
    	//to write or update test information to reporter
        extent.flush();
    }

}
