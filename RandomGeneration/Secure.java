package RandomGeneration;

import java.security.SecureRandom;
import java.util.Arrays;

public class Secure {
    public static void main(String[] args) {
        SecureRandom rng = new SecureRandom();
        byte[] randomBytes = new byte[64];
        rng.nextBytes(randomBytes);
        System.out.println(Arrays.toString(randomBytes));
    }
}
