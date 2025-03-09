package syedsaifali;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends MobileBrowserBase{

	@Test
	public void mobileBroweserTest() {
		
//		driver.get("http://google.com");
//		driver.findElement(By.name("q")).sendKeys("Rahul Shetty Academy");
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//*[@class=\"navbar-toggler-icon\"]")).click();
		driver.findElement(By.cssSelector("[href=\"/angularAppdemo/products\"]")).click();
		((JavascriptExecutor) driver).executeScript("window.scroll(0,1000)", "");
		
		String text= driver.findElement(By.cssSelector("[href=\"/angularAppdemo/products/3\"]")).getText();
		Assert.assertEquals(text, "Devops");
	}
}
