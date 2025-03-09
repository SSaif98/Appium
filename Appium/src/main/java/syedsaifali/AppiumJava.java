package syedsaifali;

import java.io.File;
import java.net.*;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumJava extends BaseClassTest{

	@Test
	public void appiumTest() throws  MalformedURLException, URISyntaxException
	{
//		configureAppium();
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement((By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']"))).click();
		driver.findElement(By.className("android.widget.CheckBox")).click();
		driver.findElement(By.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
		String text = driver.findElement(By.className("android.widget.TextView")).getText();
		Assert.assertEquals(text,"WiFi settings");
		
		driver.findElement(By.id("android:id/edit")).sendKeys("Saif Wifi");
		driver.findElement(By.id("android:id/button1")).click();
		
		
//		driver.findElement(AppiumBy.className("android.widget.Button")).get(1).click();
 	}

}
