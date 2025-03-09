package syedsaifali.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class CommonActions extends CommonUtils {
	AndroidDriver driver;

	public CommonActions(AndroidDriver driver){
//		super(driver);
		this.driver = driver;
	}

	public void longClickGesture(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
						"duration", 2000));
	}
	
	public void scrollTillTheEnd() {
		boolean canScrollMore;
		do {
			 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
					    "left", 100, "top", 100, "width", 200, "height", 200,
					    "direction", "down",
					    "percent", 1.0
					)); 
		}while(canScrollMore);
	}
	
	public void scrollToExactOption(String option) {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\""+option+"\"));"
				));
	}
	
	public void direction(WebElement firstImage, String action) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//			    "left", 100, "top", 100, "width", 200, "height", 200,
				"elementId", ((RemoteWebElement)firstImage).getId(),
			    "direction", action,
			    "percent", 0.75
			));
	}
	
	
	public List<HashMap<String, String>> getJSONData(String jsonPath) throws IOException {
		String jsonContent= FileUtils.readFileToString(new File(jsonPath), StandardCharsets.UTF_8);
		
		ObjectMapper mapper= new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
		});
		return data;
	}


	
}
