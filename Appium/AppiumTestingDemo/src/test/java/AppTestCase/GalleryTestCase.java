package AppTestCase;

import org.openqa.selenium.By;
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
		
		
		WebElement photoswipe = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));	//to create any gesture actions we should create WebElement
		
		
		Assert.assertEquals(driver.findElement(By.xpath("( //android.widget.ImageView)[1]")).getAttribute("focusable"), "true");  
		
		
		SwipeAction(photoswipe);	//this method is present in baseClass
	
		
		Assert.assertEquals(driver.findElement(By.xpath("( //android.widget.ImageView)[1]")).getAttribute("focusable"), "false"); 
		  
		
		
	

	}
}
