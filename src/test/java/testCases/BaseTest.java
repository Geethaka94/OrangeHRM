package testCases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {

	static WebDriver driver;
	Logger logger;

	@BeforeClass(groups= {"Regression","Smoke"})
	@Parameters("browser")
	public void setUp(String br) {
		//logger = LogManager.getLogger(this.getClass());

		switch (br.toLowerCase()) {

		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid Browser");
			return;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@AfterClass(alwaysRun = true, groups= {"Regression","Smoke"})
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}
	}
	
	public String captureScreen(String tname)
	{
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot takesscreenshot=(TakesScreenshot) driver;
		File sourceFile=takesscreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"/Screenshots/"+tname+"_"+timeStamp+".png";
		File tagetfile=new File(targetFilePath);
		sourceFile.renameTo(tagetfile);
		return targetFilePath;		
	}

}
