package Interfaces;

public interface IO<IncomingType, OutgoingType> {
    void publish(OutgoingType data);
    IncomingType consume();
    IncomingType RPCSubmit(OutgoingType data);
};

IO<String, String> mockIO = new IO<String, String>() {

    private String channel = "somechannel";
    @Override
    public void publish(String data) {
        System.out.println("Published: " + data);
    };

    @Override
    public String consume() {
        return "Consumed: " + System.in.nextLine();
    };

    @Override
    public String RPCSubmit(String data) {
        return "RPCSubmit: " + data;
    }
};

mockIO.consume();
mockIO.publish("TestData");

