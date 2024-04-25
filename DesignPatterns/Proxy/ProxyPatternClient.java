package DesignPatterns.Proxy;

public class ProxyPatternClient {
    public static void main(String[] args) {
        OfficeInternetAccess access = new ProxyInternetAccess("Anthony Gordon");
        access.grantInternetAccess();
    }
}
