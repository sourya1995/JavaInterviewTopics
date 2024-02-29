package Collections.Queues;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeTest {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.add("b");
        deque.add("c");
        deque.add("d");
        deque.addLast("e");

        Object headItem = deque.remove();
        System.out.println(headItem);

        Object firstItem = deque.removeFirst();
        System.out.println(firstItem);

        Object lastItem = deque.removeLast();
        System.out.println(lastItem);

        Iterator iterator = deque.iterator();
        while (iterator.hasNext()) {
            String item = (String) iterator.next();
        }

        for (Object object : deque) {
            String item = (String) object;
        }

    }
}
