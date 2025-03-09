package syedsaifali.AppiumFrameworkDesign.pageObjects.android;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import syedsaifali.utils.CommonActions;
import syedsaifali.utils.CommonUtils;
import io.appium.java_client.pagefactory.*;


public class ProductCatalogPage extends CommonActions {

	AndroidDriver driver;
		
	public  ProductCatalogPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productPrices;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
	private List<WebElement> AddToCart;
	
	public double productSelection() {
//		List<WebElement> list = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		ArrayList<String> amountArr = new ArrayList<String>();
		double totalAmount = 0.00;
		for(int i =0; i<2;i++) {
//			amountArr.add(driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText().substring(1));
			amountArr.add(productPrices.get(i).getText().substring(1));
			totalAmount+= Double.parseDouble(amountArr.get(i));
//			driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			AddToCart.get(i).click();
		}
		return totalAmount;
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/counterText")
	private WebElement CartCounter;
	
	public void verifyAddCount() {
//		Assert.assertEquals(driver.findElement(By.id("com.androidsample.generalstore:id/counterText")).getText(), "2");
		Assert.assertEquals(CartCounter.getText(), "2");
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/counterText")
	private WebElement counterText;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	private WebElement proceedPage;
	
	public void clickCounterText() throws InterruptedException {
//		driver.findElement(By.id("com.androidsample.generalstore:id/counterText")).click();	
		CartCounter.click();
//		driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).isDisplayed();
		Thread.sleep(5000);
		proceedPage.isDisplayed();
		waitUntilElementAppear(proceedPage, driver);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.attributeContains(proceedPage, "text", "Cart"));
	}
	
}
