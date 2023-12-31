package baseclass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void ConfigurationMethod() throws MalformedURLException {
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

	@AfterClass
	public void TearDown() {
		driver.quit();
		//service.start();
	}
}
