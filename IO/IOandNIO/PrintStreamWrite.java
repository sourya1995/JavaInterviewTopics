package IO.IOandNIO;
import java.io.IOException;
import java.io.PrintStream;
public class PrintStreamWrite {
    public static void main(String[] args) {
        String destination = "file1.txt";
        try(PrintStream ps = new PrintStream(destination)){
            ps.println("whatever");

            ps.flush();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
