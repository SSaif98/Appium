package syedsaifali;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_1  extends BaseClassTest{

	@Test
	public void fillForm() throws InterruptedException {
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/btnLetsShop\")")).click();
		/*Toast Message: Popup/Msg that appears on screen and disappears.
		Default: //android.widget.Toast
		*/
		
		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name"), "Please enter your name");	

		
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
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		String priceWithCurr= driver.findElement(By.xpath("//android.widget.TextView[@text=\"Jordan 6 Rings\"]/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productPrice\"]")).getText();
		System.out.println(priceWithCurr.substring(1));
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Jordan 6 Rings\"]/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"]")).click();

//		int products = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
//		for(int i=0 ; i<products; i++) {
//			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
//			if(productName.equalsIgnoreCase("Jordan 6 Rings")) {
//				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
//			}
//		}
		
		Assert.assertEquals(driver.findElement(By.id("com.androidsample.generalstore:id/counterText")).getText(), "1");
		driver.findElement(By.id("com.androidsample.generalstore:id/counterText")).click();
		WebElement cart = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(cart, "text", "Cart"));
		
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Jordan 6 Rings\"]/following-sibling::android.widget.LinearLayout/android.widget.TextView[@text=\"$165.0\"]")).isEnabled();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Send me e-mails on discounts related to selected products in future\")")).click();
		
		if(driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().contains(priceWithCurr.substring(1))) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(3000);
		
		
		}
	
}
