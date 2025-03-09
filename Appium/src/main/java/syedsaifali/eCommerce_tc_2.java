package syedsaifali;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_2  extends BaseClassTest{

	@Test
	public void fillForm() throws InterruptedException {
		
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
		
		Assert.assertEquals(driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/toolbar_title\")")).getText(), "Products");	
		
		//Product Selection
		List<WebElement> list = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		ArrayList<String> amountArr = new ArrayList<String>();
		double totalAmount = 0.00;
		for(int i =0; i<2;i++) {
			amountArr.add(driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText().substring(1));
			totalAmount+= Double.parseDouble(amountArr.get(i));
			driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
		}
		Assert.assertEquals(driver.findElement(By.id("com.androidsample.generalstore:id/counterText")).getText(), "2");
		driver.findElement(By.id("com.androidsample.generalstore:id/counterText")).click();	
		Thread.sleep(5000);
		driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).isDisplayed();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		Assert.assertEquals(Double.parseDouble(driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(2)), totalAmount);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Send me e-mails on discounts related to selected products in future\")")).click();

		
		longClickGesture(driver.findElement(By.id("com.androidsample.generalstore:id/termsButton")));
		Assert.assertEquals(driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText(), "Terms Of Conditions");
		driver.findElement(By.id("android:id/button1")).click();
	
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(6000);


		}
	
}
