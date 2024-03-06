package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExampleCLI {
    private static final String CLI_LINE = "example-cli>";
    private static final String CMD_QUIT = "quit";
    private static final String CMD_HELLO = "hello";
    private static final String CMD_ANSWER = "answer";

    public static void main(String[] args) {
        ExampleCLI example = new ExampleCLI();
        try {
            example.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void hello(String[] cmdArr) {
        System.out.println("Hello World!");
    }

    private void answer(String[] cmdArr) {
        System.out.println("42");
    }

    private void start() throws IOException {
        String cmd = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (!cmd.equals(CMD_QUIT)) {
            System.out.print(CLI_LINE);
            cmd = reader.readLine();
            String[] cmdArr = cmd.split(" ");
            if (cmdArr[0].equals(CMD_HELLO)) {
                hello(cmdArr);
            } else if (cmdArr[0].equals(CMD_ANSWER)) {
                answer(cmdArr);
            } else {
                System.out.println("Unknown command");
            }
        }
    }
}
