package Interfaces;

public class RabbitMQ implements IO<String, String> {

    private String exchange;
    private String queue;

    public RabbitMQ(String exchange, String queue) {
        this.exchange = exchange;
        this.queue = queue;
    }


    @Override
    public void publish(String data) {
        rabbit.basicPublish(exchange, queue, data.getBytes());
    }

    @Override
    public String consume() {
      return rabbit.basicConsume(exchange, queue);
    }

    @Override
    public String RPCSubmit(String data) {
      return rabbit.RPCSubmit(exchange, queue, data);
    }
    
}
