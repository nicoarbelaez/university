package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Represents a tree data structure.
 */
public class Tree {
    private Node root;
    private Node focusNode;
    private Node lastNode;
    private int level;
    private final List<Node> levelNodes;
    private final Deque<Node> nextNodes;
    private final Stack<Node> prevNodes;

    public Tree(Node root) {
        this.root = root;
        this.focusNode = root;
        this.lastNode = root;
        this.level = 1;
        this.levelNodes = new LinkedList<>();
        this.nextNodes = new LinkedList<>();
        this.prevNodes = new Stack<>();

        this.levelNodes.add(root);
        this.prevNodes.add(root);
    }

    public void insert(Node parent, Node child) {
        parent.insert(child);
        updateLastNode();
    }

    public void nextFocus() {
        if (nextNodes.isEmpty() && levelNodes.isEmpty()) {
            return;
        }
        if (!nextNodes.isEmpty()) {
            moveToNextNode();
            return;
        }
        moveToNextLevel();
        moveToNextNode();
    }

    private void moveToNextNode() {
        if (!nextNodes.isEmpty()) {
            focusNode = nextNodes.poll();
            prevNodes.push(focusNode);
        }
    }

    private void moveToNextLevel() {
        for (Node node : levelNodes) {
            for (Node child : node.getChildren()) {
                nextNodes.add(child);
            }
        }

        if (nextNodes.isEmpty()) {
            return;
        }
        level++;
        levelNodes.clear();
        levelNodes.addAll(nextNodes);
    }

    public void previousFocus() {
        if (!prevNodes.isEmpty()) {
            nextNodes.addFirst(prevNodes.pop());
            if (!prevNodes.isEmpty()) {
                focusNode = prevNodes.peek();
            }
        }
    }

    public Node search(int[] digits) {
        return search(root, digits);
    }

    private Node search(Node node, int[] digits) {
        if (node.getClueNumber().getDigits().equals(digits)) {
            return node;
        }

        for (Node child : node.getChildren()) {
            Node found = search(child, digits);
            if (found != null) {
                return found;
            }
        }

        return null;
    }

    public Node getParent(Node child) {
        return getParent(root, child);
    }

    private Node getParent(Node node, Node child) {
        for (Node n : node.getChildren()) {
            if (n.equals(child)) {
                return node;
            }

            Node parent = getParent(n, child);
            if (parent != null) {
                return parent;
            }
        }
        return null;
    }

    public void updateLastNode() {
        lastNode = findLastNode(root);
    }

    private Node findLastNode(Node node) {
        if (node.getChildren().isEmpty()) {
            return node;
        } else {
            return findLastNode(node.getChildren().get(node.getChildren().size() - 1));
        }
    }

    @Override
    public String toString() {
        return root.toString();
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getFocusNode() {
        return focusNode;
    }

    public void setFocusNode(Node focusNode) {
        this.focusNode = focusNode;
    }

    public Node getLastNode() {
        return lastNode;
    }

    public void setLastNode(Node lastNode) {
        this.lastNode = lastNode;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Node> getLevelNodes() {
        return levelNodes;
    }

    public Deque<Node> getNextNodes() {
        return nextNodes;
    }

    public Stack<Node> getPrevNodes() {
        return prevNodes;
    }
}