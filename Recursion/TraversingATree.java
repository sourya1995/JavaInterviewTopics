package Recursion;

public class TraversingATree {
    public class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data){
            this.data = data;
        }


    }

    public static void inOrderTraversal(Node root){
        if(root != null){
            inOrderTraversal(root.left); //traverse left sub tree
            System.out.println(root.data + ""); //traverse current node
            inOrderTraversal(root.right);

        }
    }
}
