package JavaCodingProblems.DataStructures.Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class GraphDFS {
    private int v;
    private final LinkedList<Integer>[] adjacents;

    public GraphDFS(int v) {
        this.v = v;
        adjacents = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjacents[i] = new LinkedList<>();

        }
    }

    public void addEdge(int v, int w) {
        adjacents[v].add(w);
    }

    public void DFS(int start) {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            start = stack.pop();

            if (!visited[start]) {
                visited[start] = true;
                System.out.println(start);
            }

            Iterator<Integer> it = adjacents[start].listIterator();
            while (it.hasNext()) {
                int n = it.next();
                if (!visited[n]) {
                    stack.push(n);
                }
            }

        }

    }

}
