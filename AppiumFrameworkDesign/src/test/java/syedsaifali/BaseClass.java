package syedsaifali;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import syedsaifali.AppiumFrameworkDesign.pageObjects.android.FormPage;
import syedsaifali.utils.CommonActions;
import syedsaifali.utils.CommonUtils;

public class BaseClass extends CommonUtils{
	

	AndroidDriver driver;
	AppiumDriverLocalService service;
	FormPage formPage;
	CommonActions androidActions;
	
	@BeforeClass (alwaysRun=true)
	public void ConfigureAppium() throws URISyntaxException, IOException {
			
		Properties prop= new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//data.properties");
		prop.load(fis);
//		String ipAddress =prop.getProperty("ipAddress");
		String ipAddress =	System.getProperty("ipAddress") !=null ? System.getProperty("ipAddress") :prop.getProperty("ipAddress");
		String port = prop.getProperty("port");

		service = startAppiumService(ipAddress, Integer.parseInt(port));
			
		UiAutomator2Options options =  new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("saifEmulator"));
		options.setApp(System.getProperty("user.dir")+ prop.getProperty("appLoc"));
		
//		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL() , options);

		driver = new AndroidDriver(service.getUrl() , options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		formPage= new FormPage(driver);
		androidActions= new CommonActions(driver);
		}
	
	@AfterClass
	public void closeServer() {
		driver.quit();
//		stop appium server
		service.stop();
	}
}
