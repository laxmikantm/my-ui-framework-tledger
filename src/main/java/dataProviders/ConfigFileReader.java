package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;
import enums.OSSystem;
import utils.CONSTANT;
/**************************
 *  (C) L Somni            *
 ***************************/
public class ConfigFileReader {

	private Properties properties;

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(CONSTANT.PROPERTIES_FILE_PATH));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + CONSTANT.PROPERTIES_FILE_PATH);
		}
	}

	public String getDriverPath(String ossystemPrefix) {
		String keyDrivePath = ossystemPrefix + CONSTANT.WEB_DRIVEN;
		String driverPath = properties.getProperty(keyDrivePath);
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}

	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty(CONSTANT.IMPLICTLY_WAIT);
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}

	public String getApplicationUrl() {
		String url = properties.getProperty(CONSTANT.URL_END_POINT);
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if (browserName == null || browserName.equals("chrome"))
			return DriverType.CHROME;
		else if (browserName.equalsIgnoreCase("firefox"))
			return DriverType.FIREFOX;
		else if (browserName.equals("iexplorer"))
			return DriverType.INTERNETEXPLORER;
		else
			throw new RuntimeException(
					"Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}

	public EnvironmentType getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if (environmentName == null || environmentName.equalsIgnoreCase("local"))
			return EnvironmentType.LOCAL;
		else if (environmentName.equals("remote"))
			return EnvironmentType.REMOTE;
		else
			throw new RuntimeException(
					"Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}

	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if (windowSize != null)
			return Boolean.valueOf(windowSize);
		return true;
	}

	public OSSystem getOSSystem() {
		String osSystem = properties.getProperty("osSystem");
		if (osSystem == null || osSystem.equalsIgnoreCase("macos")) {
			return OSSystem.MACOS;
		} else if (osSystem.equalsIgnoreCase("linux64")) {
			return OSSystem.LINUX64;
		} else if (osSystem.equalsIgnoreCase("linux32")) {
			return OSSystem.LINUX32;
		} else {
			throw new RuntimeException(
					"osSystem Name Key value in Configuration.properties is not matched : " + osSystem);
		}
	}
	
	public String getTestDataResourcePath() {
		String testDataResourcePath = properties.getProperty("testDataResourcePath");
		if (testDataResourcePath != null)
			return testDataResourcePath;
		else
			throw new RuntimeException(
					"Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
	}

}
