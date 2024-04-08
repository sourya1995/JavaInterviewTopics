package Internals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadConfig {
    private Properties getDefaults() throws IOException{
        Properties defaults = new Properties();
        try(InputStream defaultStream = LoadConfig.class.getResourceAsStream("config.properties")){
            defaults.load(defaultStream);
        }

        return defaults;
    }
}
