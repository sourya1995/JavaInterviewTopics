package JavaCodingProblems.DataStructures.ConcurrentCollections;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;


public class BiryaniOrderExample {
    static class BiryaniOrder implements Delayed {
        private final String type;
        private final long deliveryTime;

        public BiryaniOrder(String type, long delay, TimeUnit unit) {
            this.deliveryTime = System.currentTimeMillis() + unit.toMillis(delay);
            this.type = type;
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.deliveryTime < ((BiryaniOrder) o).deliveryTime) {
                return -1;
            } else if (this.deliveryTime > ((BiryaniOrder) o).deliveryTime) {
                return 1;
            }
            return 0;
        }

        @Override
        public long getDelay(TimeUnit unit) {
           long delay = deliveryTime - System.currentTimeMillis();
           return unit.convert(delay, TimeUnit.MILLISECONDS);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BiryaniOrder{");
            sb.append("type=").append(type);
            sb.append(", deliveryTime=").append(deliveryTime);
            sb.append('}');
            return sb.toString();
        }

        public static void main(String[] args) {
            DelayQueue<BiryaniOrder> biryaniQueue = new DelayQueue<>();

            biryaniQueue.put(new BiryaniOrder("Chicken Biryani", 5, TimeUnit.SECONDS));
            biryaniQueue.put(new BiryaniOrder("Mutton Biryani", 10, TimeUnit.SECONDS));
            biryaniQueue.put(new BiryaniOrder("Veg Biryani", 3, TimeUnit.SECONDS));
    
            System.out.println("Biryani orders placed in the DelayQueue");

            while(!biryaniQueue.isEmpty()) {
                try {
                    BiryaniOrder order = biryaniQueue.take();
                    System.out.println("Delivered: " + order);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }




    }
}
