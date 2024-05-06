package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    /**
     * This method is used to load the properties from the config.properties file
     * @return the properties prop object
     */
    public Properties init_prop()
    {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("C:/Practice/Cucumber/src/test/resources/properties/config.properties");
            prop.load(ip);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return prop;
    }
}
