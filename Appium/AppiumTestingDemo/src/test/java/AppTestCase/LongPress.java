package AppTestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import io.appium.java_client.AppiumBy;

public class LongPress extends BaseClass {
	
	
	
	@Test
	public void longpress() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));

		Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']")).getText(),"People Names");
		
		LongPressgestures(ele ); //this method is present in BaseClass
//		To perform any gesture we should inject javascript 
//		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",	//this is for longClicke Gesture
//				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration",2000));
//		Thread.sleep(2000);
	
		driver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']"));
		
		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).getText(), "Sample menu");
		
		//for other gesture actions go to the below site
		//https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
	}

}
