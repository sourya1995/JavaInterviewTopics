package Recursion.RecursivelyPrintBinaryTree;

import java.util.ArrayList;
import java.util.List;
public class Frame {
    public final Node node;
    public int state = 0;
    public final int maxDepth;
    public Frame(Node node, int maxDepth) {
        this.node = node;
        this.maxDepth = maxDepth;
    }

    List<Frame> stack = new ArrayList<>();
    stack.add(new Frame(n, 2));

    while(!stack.isEmpty()){
        int index = stack.size() - 1;
        Frame frame = stack.get(index);
        if(frame.maxDepth <= 0){
            System.out.print("(...)");
            stack.remove(index);
        }else {
            switch(frame.state){
                case 0:
                    frame.state++;
                    System.out.print("(");
                    if(frame.node.left != null){
                        stack.add(new Frame(frame.node.left, frame.maxDepth - 1));
                        break;
                    }
                case 1:
                    frame.state++;
                    System.out.print(frame.node.data);
                    if(frame.node.right != null){
                        stack.add(new Frame(frame.node.right, frame.maxDepth - 1));
                        break;
                    }
                case 2:
                    frame.state++;
                    System.out.print(")");
                    stack.remove(index);
                    

            }
        }
        
    }


    
}
