package AppTestCase;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import io.appium.java_client.AppiumBy;

public class GalleryTestCase extends BaseClass {
	@Test
	public void GalleryTestCae() {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		;
		driver.findElement(AppiumBy.accessibilityId("Gallery"));

		String galleryElement = driver.findElement(AppiumBy.accessibilityId("Gallery")).getText();
  
		Assert.assertEquals(galleryElement, "Gallery");
		System.out.println(galleryElement);
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		;

	}
}
