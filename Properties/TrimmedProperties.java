package Properties;


import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Map;
import java.util.Properties;

import javax.naming.directory.InvalidSearchFilterException;

public class TrimmedProperties extends Properties {

    @Override
    public void load(InputStream inStream) throws IOException{
        if(inStream instanceof FileInputStream) {
            Properties temp = new Properties();
            temp.load(inStream);
            trimAndLoad(temp);
        } else {
            super.load(inStream);
        }
    }

    @Override
    public void load(Reader reader) throws IOException {
        if(reader instanceof  FileReader){
            Properties temp = new Properties();
            temp.load(reader);
            trimAndLoad(temp);
        } else {
            super.load(reader);
        
        }
    }

    private void trimAndLoad(Properties p){
        for(Map.Entry<Object, Object> entry: p.entrySet()){
            if(entry.getValue() instanceof String) {
                put(entry.getKey(), trimTrailing((String) entry.getValue()));
            } else {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    public static String trimTrailing(String str){
        if(str != null) {
            for (int i = str.length() - 1; i >= 0; i--){
                if((str.charAt(i) != ' ') && (str.charAt(i) != '\t')) {
                    return str.substring(0, i + 1);
                }
            }
        }
        return str;
    }


}
