package OOP.NestedClass;

public class IntStack {
    private IntStackNode head;

    private static class IntStackNode {
        private int val;
        private IntStackNode next;

        public IntStackNode(int v, IntStackNode n) {
            val = v;
            next = n;
        }
    }

    public IntStack push(int v) {
        head = new IntStackNode(v, head);
        return this;
    }

    public int pop() {
        int v = head.val;
        head = head.next;
        return v;
    }

    public boolean isEmpty() {
        return head == null;
    }

}
