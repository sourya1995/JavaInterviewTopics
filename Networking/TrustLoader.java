package Networking;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class TrustLoader {
    public static void main(String[] args) {
        try {
            InputStream stream = TrustLoader.class.getResourceAsStream("keystore.jks");
            KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
            char[] trustStorePassword = "password".toCharArray();
            keystore.load(stream, trustStorePassword);
            SSLContext sslContext = SSLContext.getInstance("SSL");
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keystore);
            TrustManager[] managers = trustManagerFactory.getTrustManagers();
            sslContext.init(null, managers, null);
           SSLContext.setDefault(sslContext);


        } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException | KeyManagementException e) {
            e.printStackTrace();
        } finally {
            //something
        }
    }
}
