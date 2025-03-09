package syedsaifali;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class MultiplCases extends BaseClassTest{


	@BeforeMethod
	public void openDefaultPage() {		
  		Activity act = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.SplashActivity");
		((JavascriptExecutor) driver).executeScript("mobile: startActivity",
		ImmutableMap.of("intent", "com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity"));
	}
	
	@Test
	public void positiveCase() {
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Syeda Atiya Ali");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.RadioButton[@text=\"Female\" and @checked=\"true\"]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.RadioButton[@text=\"Male\" and @checked=\"false\"]")).isDisplayed());
		
		driver.findElement(By.className("android.widget.Spinner")).click();
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"
				));
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Argentina\")")).click();
		driver.findElement(By.className("android.widget.Button")).click();
//		Assert.assertTrue(!(driver.findElement(By.xpath("//android.widget.Toast[1]")).isDisplayed()));	
	}
	
	
	@Test
	public void errorMethod() throws InterruptedException {
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/btnLetsShop\")")).click();
		Thread.sleep(1000);
		/*Toast Message: Popup/Msg that appears on screen and disappears.
		Default: //android.widget.Toast
		*/
		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name"), "Please enter your name");	
	}
	
}
