package Properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class LoadPropertiesFromXML {
    public static void loadProperties(String location) throws InvalidPropertiesFormatException, FileNotFoundException, IOException {
        Properties properties = new Properties();
        File file = new File(location);
        if(file.exists()){
            properties.loadFromXML(new FileInputStream(file));
            for(String name: properties.stringPropertyNames()){
                System.out.println(name + "=" + properties.getProperty(name));
            }
        } else {
            System.err.println(file + "not found at" + location);
        }
    }
}
