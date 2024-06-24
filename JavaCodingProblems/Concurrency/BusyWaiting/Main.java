package JavaCodingProblems.Concurrency.BusyWaiting;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        StartService service = new StartService();
        new Thread(service).start();
        Thread.sleep(500);
        service.setServiceAvailable(true);
    }
}
