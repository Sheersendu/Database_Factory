package config;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {

	private static Properties properties;
	private static final String propertiesFilePath = "./src/src/config/applicationConfig.properties";

	public static Properties getConfiguration() {
		File configFile = new File(propertiesFilePath);
		try
		{
			FileReader fileReader = new FileReader(configFile);
			properties = new Properties();
			properties.load(fileReader);
			fileReader.close();
			return properties;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
