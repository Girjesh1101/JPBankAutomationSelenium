package config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	
	private static Properties properties;
	
	static {
		
		try {
			
			String path="src/test/java/resource/config.properties";
			String configFilePath = path;
			FileInputStream input = new FileInputStream(configFilePath);
			
			properties = new Properties();
			properties.load(input);
			input.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Filed to load config.properties");
		}
	}
	
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
}
