package JavaCodingProblems.DataStructures.FenwickTree;

public class FenwickTree {
    private int[] tree;

    public FenwickTree(int size) {
        tree = new int[size + 1];
    }

    public void update(int i, int delta) {
        while (i < tree.length) {
            tree[i] += delta;
            i += i & -i;
        }
    }

    public int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= i & -i;
        }
        return sum;
    }
}


