package HTTP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// This class gets the response body of an HTTP request as a string.

public class GetResponseBodyAsString {
    public String getText(String url) throws MalformedURLException, IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        int responseCode = connection.getResponseCode();
        InputStream inputStream;
        if(200 <= responseCode && responseCode <= 299)
            inputStream = connection.getInputStream();
        else
            inputStream = connection.getErrorStream();
       BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();


        
    }
}
