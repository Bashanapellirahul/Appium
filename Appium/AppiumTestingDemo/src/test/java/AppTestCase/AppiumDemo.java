package AppTestCase;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
//import org.openqa.selenium.By;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import io.appium.java_client.AppiumBy;

public class AppiumDemo extends BaseClass {		//BaseClass is extended to use the methods in to like starting driver ,closing driver and other methods

	@Test
	public void AppiumTestDemo() throws MalformedURLException, InterruptedException {
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Preference\"]")).click();
		
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
	
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		
		driver.findElement(AppiumBy.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
		Thread.sleep(2000);
		
		
		
		Assert.assertEquals(driver.findElement(By.id("android:id/alertTitle")).getText(), "WiFi settings");	
		//this will check whether the title is same or not. If this is same only, other methods are executed
		
		
		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("rahulWifi");
		Thread.sleep(2000);
		
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		Thread.sleep(2000);
		
		
	}

}
