package Properties;

import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {
    public static Properties loadDefaults() {
        try(InputStream bundledResource = Defaults.class.getResourceAsStream("defaults.properties")) {
            Properties defaults = new Properties();
            defaults.load(bundledResource);
            return defaults;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
