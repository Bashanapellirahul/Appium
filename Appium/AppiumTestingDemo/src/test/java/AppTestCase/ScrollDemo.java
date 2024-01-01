package AppTestCase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseClass {

	@Test
	public void ScrollAction() throws InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

		Scroll();//this method is present in BaseClass
		
		String ele = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"WebView\"]")).getText();

		Assert.assertEquals(ele, "WebView");

		System.out.println(ele);	

		driver.findElement(AppiumBy.accessibilityId("WebView")).click();
		
		

	}

}
