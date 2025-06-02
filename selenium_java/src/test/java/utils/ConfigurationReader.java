package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties prop;

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/Config.properties");
            prop = new Properties();
            prop.load(fis);
            fis.close();
        } catch (IOException e) {
            System.err.println("Failed to load config.properties file: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        if (prop == null) {
            throw new IllegalStateException("Properties file not loaded properly.");
        }
        return prop.getProperty(key);
    }
}
