package baseclass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	public AndroidDriver driver; 		//created public AndriodDriver object to use anywhere 
	public AppiumDriverLocalService service;

	@BeforeClass	//this will start before start of any Test class
	public void ConfigurationMethod() throws MalformedURLException {		//this is configuration method where i stored Android driver and code to start the Appium without terminal
//
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js"))
				// withAppiumJS is the path of the appium file i.e., main.js
				.withIPAddress("127.0.0.1") // IP address of the appium server
				.usingPort(4723).build(); // port number of the appium

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("RahulEmulator");
		options.setApp("/Users/rahulbashanapelli/eclipse-workspace/Appium/AppiumTestingDemo/src/test/java/resources/ApiDemos-debug.apk");
		// DesiredCapabilities capabilities = new DesiredCapabilities();
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options); // Android Driver here we will provide
		// the url of appium server
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}
	
	
	
	
	//this method is created is because we can reuse this code again 
	public void LongPressgestures(WebElement ele) throws InterruptedException {	//this method is used for LongPress. Used in LongPress class
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",	//this is for longClicke Gesture
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration",2000));
		Thread.sleep(2000);
	}
	
	
	public void SwipeAction(WebElement photoswipe) { 	//pass the parameters to the method //this method is used to swipe. This method is used in galleryTestcase class
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement) photoswipe).getId(),
			    "direction", "left",
			    "percent", 0.75));	
	}
	
	
	public void Scroll() {		//this method is used to scroll to particular element. Used in Scroll Demo class
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
	}

	@AfterClass		//this will close the app after Test class
	public void TearDown() {
		driver.quit();
		//service.start();
	}
}
