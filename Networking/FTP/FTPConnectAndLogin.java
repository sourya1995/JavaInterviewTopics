package Networking.FTP;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
public class FTPConnectAndLogin {

    private static void showServerReply(FTPClient client) {
        String[] replies = ftp.getReplyStrings();
        if(replies != null && replies.length > 0){
            for(String reply: replies){
                System.out.println("Server reply: " + reply);
            }
        }
    }
    public static void main(String[] args) {
        String server = "www.server.com";
        int port = 21;
        String username = "username";
        String password = "password";

        FTPClient ftp = new FTPClient;
        try {
            ftp.connect(server, port);
            showServerReply(ftp);
            int replyCode = ftp.getReplyCode();
            if(!FTPReply.isPositiveCompletion(replyCode)){
                System.out.println("Operation failed: " + replyCode);
                return;
            }
            boolean success = ftp.login(username, password);
            showServerReply(ftp);
            if(!success){
                System.out.println("failed to login");
                return;
            } else {
                System.out.println("LOGGED IN SERVER");
            }
        } catch (IOException e) {
            System.out.println("something went wrong");
            e.printStackTrace();
        }
    }
}
