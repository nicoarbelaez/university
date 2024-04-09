package tree;

import java.util.ArrayList;
import java.util.List;

import models.TrackNumber;

/**
 * Represents a node in a tree.
 */
public class Node {
    private TrackNumber clueNumber;
    private List<Node> children = new ArrayList<>();

    public Node(TrackNumber clueNumber) {
        this.clueNumber = clueNumber;
    }

    public void insert(Node node) {
        children.add(node);
    }

    @Override
    public String toString() {
        return printTree(this, "", true);
    }

    private String printTree(Node node, String prefix, boolean isTail) {
        StringBuilder sb = new StringBuilder();

        sb.append(prefix)
                .append(isTail ? "└── " : "├── ")
                .append(node.clueNumber.toString())
                .append("\n");

        for (int i = 0; i < node.children.size() - 1; i++) {
            sb.append(printTree(node.children.get(i), prefix + (isTail ? "    " : "│   "), false));
        }

        if (node.children.size() > 0) {
            sb.append(
                    printTree(node.children.get(node.children.size() - 1), prefix + (isTail ? "    " : "│   "), true));
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Node node = (Node) obj;
        return clueNumber.equals(node.clueNumber) && children.equals(node.children);
    }

    public TrackNumber getClueNumber() {
        return clueNumber;
    }

    public void setClueNumber(TrackNumber clueNumber) {
        this.clueNumber = clueNumber;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
