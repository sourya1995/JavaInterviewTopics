package JavaCodingProblems.DataStructures.Trie;

import java.util.function.Function;

public class Trie {
    private final Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {

        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Function function = k -> new Node();
            node = node.getChildren().computeIfAbsent(ch, function);
        }

        node.setWord(true);
    }

    public boolean contains(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            node = node.getChildren().get(ch);
        }

        if (node == null) {
            return false;
        }

        return node.isWord();

    }

    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    private boolean delete(Node node, String word, int index) {
        if (word.length() == index) {
            if (!node.isWord()) {
                return false;
            }

            node.setWord(false);
            return node.getChildren().isEmpty();

        }

        char ch = word.charAt(index);
        Node children = node.getChildren().get(ch);

        if (children == null) {
            return false;
        }

        boolean deleteChildren = delete(children, word, index + 1);
        if (deleteChildren && !children.isWord()) {
            node.getChildren().remove(ch);
            return node.getChildren().isEmpty();
        }

        return false;
    }

}
