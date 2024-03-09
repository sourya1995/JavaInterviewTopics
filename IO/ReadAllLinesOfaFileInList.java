package IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadAllLinesOfaFileInList {
    public List<String> getAllLines(String fileName) throws IOException {
        List<String> lines = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = null;
            while((line = br.readLine()) != null){
                lines.add(line);
            }
        }
        return lines;
    }
}
