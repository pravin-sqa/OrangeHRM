package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties props = new Properties();

    static {
        String env = System.getProperty("env", "qa");

        try (InputStream in = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config/" + env + ".properties"))
        {
            props.load(in);
        }
        catch (Exception e) {
            throw new RuntimeException("config/" + env + ".properties vachta aali nahi", e);
        }
    }

    public static String get(String key)
    {

        return props.getProperty(key);
    }
}