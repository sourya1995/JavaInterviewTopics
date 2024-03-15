package Properties;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SaveProperties {
    public void saveProperties(String location) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("name", "Steve");
        properties.setProperty("age", "25");
        properties.setProperty("city", "New York");
        
        File file = new File(location);
        if(!file.exists()){
            file.createNewFile();
        }

        properties.storeToXML(new FileOutputStream(file), "testing some stuff");
       
    }
    public static void main(String[] args) {
     
            
        }
    }

