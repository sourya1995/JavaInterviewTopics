package HTTP;

import java.net.URL;
import java.io.IOException;
import java.net.HttpURLConnection;

public class CheckResourceExists {
    public static final boolean checkIfResourceExists(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("HEAD");
        int code = connection.getResponseCode();
        connection.disconnect();
        return code == 200;
        
    }
}
