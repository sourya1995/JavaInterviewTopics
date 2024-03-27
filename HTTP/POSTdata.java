package HTTP;

import java.net.HttpURLConnection;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class POSTdata {
    public static void post(String url, byte[] data, String contentType) throws IOException{
        HttpURLConnection connection = null;
        OutputStream out = null;
        InputStream in = null;

        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestProperty("Content-Type", contentType);
            connection.setDoOutput(true);

            out = connection.getOutputStream();
            out.write(data);
            out.close();

            in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
            in.close();
            
        } finally {
            if(connection != null) connection.disconnect();
            if(out != null) out.close();
            if(in!= null) in.close();
        }
    }
}
