package JavaCodingProblems.DataStructures.Trie;

import java.util.HashMap;
import java.util.Map;


public class Node {
    private final Map<Character, Node> children = new HashMap<>();
    private boolean word;

    Map<Character, Node> getChildren() {
        return children;
    }

    boolean isWord() {
        return word;
    }

    public void setWord(boolean word) {
        this.word = word;
    }

}
