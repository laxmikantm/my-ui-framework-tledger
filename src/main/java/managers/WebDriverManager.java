package managers;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import enums.DriverType;
import enums.EnvironmentType;
import utils.CONSTANT;
/**************************
 *  (C) L Somni            *
 ***************************/

public class WebDriverManager {
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;

	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	public WebDriver getDriver() {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() {
		switch (environmentType) {
		case LOCAL:
			driver = createLocalDriver();
			break;
		case REMOTE:
			driver = createRemoteDriver();
			break;
		}
		return driver;
	}

	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}
	
	private String getOSSystemPrefix() {
		return FileReaderManager.getInstance().getConfigReader().getOSSystem().toString();
	}
	
	private WebDriver createLocalDriver() {
		String osSystemPrefix = getOSSystemPrefix().toLowerCase();
		String driverPath = FileReaderManager.getInstance().getConfigReader().getDriverPath(osSystemPrefix);
		switch (driverType) {
		case FIREFOX:
			System.setProperty(CONSTANT.FIREFOX_DRIVER_PROPERTY, driverPath);
			driver = new FirefoxDriver();
			break;
		case CHROME:
			//TODO fix this issue
			System.setProperty(CONSTANT.CHROME_DRIVER_PROPERTY, "driverDir/chromedriver");
			driver = new ChromeDriver();
			break;
		case INTERNETEXPLORER:
			driver = new InternetExplorerDriver();
			break;
		}

		if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),
				TimeUnit.SECONDS);
		return driver;
	}

	public void closeDriver() {
		driver.quit();
	}

}