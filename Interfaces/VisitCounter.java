package Interfaces;

import java.util.concurrent.atomic.AtomicLong;

public class VisitCounter implements IO<Long, Integer> {

    private static AtomicLong counter = new AtomicLong(0);


    @Override
    public void publish(Integer count) {
        counter.addAndGet(count);
    }

    @Override
    public Long consume() {
       return counter.get();
    }

    @Override
    public Long RPCSubmit(Integer data) {
        return counter.addAndGet(data);
    }

    public static void main(String[] args) {
        VisitCounter vc = new VisitCounter();
        vc.publish(10);
        System.out.println(vc.consume()); // 10
        vc.publish(20);
        System.out.println(vc.consume()); // 30
        System.out.println(vc.RPCSubmit(30)); // 60
    }
    
}
