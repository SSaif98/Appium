package syedsaifali.AppiumFrameworkDesign.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import syedsaifali.utils.CommonActions;
import syedsaifali.utils.CommonUtils;
import io.appium.java_client.pagefactory.*;


public class CheckoutPage extends CommonActions {

	AndroidDriver driver;
	
	public CheckoutPage(AndroidDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement TotalAmount;
	
	public void verifyTotalAmount(double totalAmount) {
//		Assert.assertEquals(Double.parseDouble(driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(2)), totalAmount);
		Assert.assertEquals(Double.parseDouble(TotalAmount.getText().substring(2)), totalAmount);
	}
	
	
	@AndroidFindBy(uiAutomator="new UiSelector().text(\"Send me e-mails on discounts related to selected products in future\")")
	private WebElement discountMsg;
	
	public void clickDiscountMsg() {
//		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Send me e-mails on discounts related to selected products in future\")")).click();
		discountMsg.click();
	}
	
//	longClickGesture(driver.findElement(By.id("com.androidsample.generalstore:id/termsButton")));

	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement termsBtn;
	
	public void longPressTermsBtn() {
		longClickGesture(termsBtn);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/alertTitle")
	private WebElement verifyAlertTitle;
	
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement btn1;
	
	public void verifyAlertTitle() {
		Assert.assertEquals(verifyAlertTitle.getText(), "Terms Of Conditions");
//		Assert.assertEquals(driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText(), "Terms Of Conditions");
//		driver.findElement(By.id("android:id/button1")).click();
		btn1.click();
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement proceedBtn;
	
	public void clickProceedBtn() {
		proceedBtn.click();
//		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	}

	
}
