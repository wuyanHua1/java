package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	private static Config Instance=new Config();
	public static Config getInstance() {
		return Instance;
	}
	
	private Properties properties=new Properties();
	private Config()
	{
		InputStream inputStream=Config.class.getClassLoader().getResourceAsStream("config.properties");
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getString(String key) {
		return properties.getProperty(key);
	}
	public int getInt(String key) {
		return Integer.valueOf(properties.getProperty(key));
	}
}
