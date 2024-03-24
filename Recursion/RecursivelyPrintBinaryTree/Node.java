package Recursion.RecursivelyPrintBinaryTree;

public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data){
        this(data, null, null);
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void print(final int maxDepth){
        if(maxDepth <= 0){
            System.out.print("(...)");
        } else {
            System.out.print("(");
            if(left != null){
                left.print(maxDepth - 1);
            }
            System.out.print(data);
            if(right != null){
                right.print(maxDepth - 1);
            }
            System.out.print(")");
        }
    }
}
