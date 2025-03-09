package syedsaifali.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class CommonUtils  {
	AppiumDriverLocalService service;

	AndroidDriver driver;
//	public CommonUtils(AndroidDriver driver) {
//		this.driver= driver;
//	}

	public AppiumDriverLocalService startAppiumService(String ipAddress, int port) {
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C://Users//Saif//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress(ipAddress).usingPort(port).build();
		service.start();
		return service;
	}
	
	public void waitUntilElementAppear(WebElement proceedPage,AndroidDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(proceedPage, "text", "Cart"));
	}
	
	public String getScreenshot(String testCaseName, AndroidDriver driver) throws IOException {
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports"+testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		//1. capture SS and place it in folder   //2. extent report pick file and attach to report 
	}
	
}
