package syedsaifali;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import syedsaifali.AppiumFrameworkDesign.pageObjects.android.CheckoutPage;
import syedsaifali.AppiumFrameworkDesign.pageObjects.android.FormPage;
import syedsaifali.AppiumFrameworkDesign.pageObjects.android.ProductCatalogPage;
import syedsaifali.BaseClass;
import syedsaifali.utils.CommonActions;

public class eCommerce_tc_HybridApp  extends BaseClass{

	//Adding groups to run specific group
	@Test(dataProvider="getData", groups= {"Smoke"})
	public void fillForm(String name, String gender, String country) throws InterruptedException {
				
		formPage.setNameField(name);
		formPage.setGender(gender);
		formPage.setCountrySelection(country);
		formPage.clickLetsShop();
		
		ProductCatalogPage productCatalog= new ProductCatalogPage(driver);
		
		//Product Selection
		double totalAmount = productCatalog.productSelection();
		
		System.out.println(totalAmount);
				
		productCatalog.verifyAddCount();
		productCatalog.clickCounterText();
		
		CheckoutPage checkoutPageScreen= new CheckoutPage(driver);
		checkoutPageScreen.verifyTotalAmount(totalAmount);
		checkoutPageScreen.clickDiscountMsg();
		checkoutPageScreen.longPressTermsBtn();
		checkoutPageScreen.verifyAlertTitle();
		checkoutPageScreen.clickProceedBtn();
		Thread.sleep(2000);

		//		Set<String> contexts= driver.getContextHandles();
//		for(String contextName : contexts) {
//			System.out.println(contextName);
//		}
//		 driver.context("WEBVIEW_com.androidsample.generalstore");
//		driver.findElement(By.name("q")).sendKeys("Rahul Shetty Academy");
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		 driver.context("NATIVE_APP");
		}
	
	@BeforeMethod(alwaysRun=true)
	public void openDefaultPage() {		
		formPage.setActivity();
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
//		return new Object[][] {{"Atiya Ali", "male", "Argentina"}, {"Syed Saif Ali", "male", "Argentina"}};
		return new Object[][] {{"Atiya Ali", "female", "Argentina"}};

	}
	
	
}
