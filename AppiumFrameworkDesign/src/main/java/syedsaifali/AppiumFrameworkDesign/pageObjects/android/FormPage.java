package syedsaifali.AppiumFrameworkDesign.pageObjects.android;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import syedsaifali.utils.CommonActions;
import syedsaifali.utils.CommonUtils;


public class FormPage extends CommonActions {

	AndroidDriver driver;
	//Constructor
	//When an obj is created of the class the constructor executes first
	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver= driver ;
		//"this" represents current class instance
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	//Why we declaring every element as private
	//So that it can not be accessed in eCommerce_tc_hybrid class if it is public then this show there and you can use it like
	//formPage.namefield.click() which is correct but we are using page object pattern and no technicality in main file
	//It is encapsulation we are hiding the unnecessary information
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleOption;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private WebElement maleOption;
	
	public void setNameField(String name) {
//		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Syeda Atiya Ali");
//		driver.hideKeyboard();
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text=\"Female\" and @checked=\"true\"]")
	private WebElement femaleSelected;
	
	@AndroidFindBy(xpath=("//android.widget.RadioButton[@text=\"Male\" and @checked=\"true\"]"))
	private WebElement maleSelected;

	public void setGender(String gender) {
		if(gender.contains("female")) {
//			driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();

			femaleOption.click();
			Assert.assertTrue(femaleSelected.isDisplayed());
		}else {
			maleOption.click();
			Assert.assertTrue(maleSelected.isDisplayed());
		}
	}
	
	@AndroidFindBy(className="android.widget.Spinner")
	private WebElement countryDropdown;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Argentina\")")
	private WebElement selectCountry;
	
	public void setCountrySelection(String option) {
		
//		driver.findElement(By.className("android.widget.Spinner")).click();
//		driver.findElement(AppiumBy.androidUIAutomator(
//				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"
//				));
//		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Argentina\")")).click();
		countryDropdown.click();
		scrollToExactOption(option);
		selectCountry.click();
	}
	
	@AndroidFindBy(className= "android.widget.Button")
	private WebElement LetsShop;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.androidsample.generalstore:id/toolbar_title\")")
	private WebElement ProductsScreen;
	
	public void clickLetsShop() {
//		driver.findElement(By.className("android.widget.Button")).click();
		LetsShop.click();
//		Assert.assertEquals(driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/toolbar_title\")")).getText(), "Products");	
		Assert.assertEquals(ProductsScreen.getText(), "Products");	
	}
	
	public void setActivity() {
  		Activity act = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.SplashActivity");
		((JavascriptExecutor) driver).executeScript("mobile: startActivity",
		ImmutableMap.of("intent", "com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity"));

	}
	
}
