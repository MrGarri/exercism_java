import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    BinarySearchTree() {
        this.root = null;
    }

    Node<T> getRoot() {
        return this.root;
    }

    void insert(T value) {
        if (this.root == null) {
            this.root = new Node<>(value);
        } else {
            insert(this.root, value);
        }
    }

    private void insert(Node<T> node, T value) {
        if (value.compareTo(node.getData()) <= 0) {
            if (node.isComplete() || node.getLeft() != null) {
                insert(node.getLeft(), value);
            } else {
                node.setLeft(new Node<>(value));
            }
        } else {
            if (node.isComplete() || node.getRight() != null) {
                insert(node.getRight(), value);
            } else {
                node.setRight(new Node<>(value));
            }
        }
    }

    List<T> getAsSortedList() {
        return getSortedValues(this.root);
    }

    private List<T> getSortedValues(Node<T> node) {
        List<T> values = new ArrayList<>();
        if (node == null)
            return values;

        values.addAll(getSortedValues(node.getLeft()));
        values.add(node.getData());
        values.addAll(getSortedValues(node.getRight()));

        return values;
    }

    List<T> getAsLevelOrderList() {
        List<Node<T>> treeNodes = new ArrayList<>();
        treeNodes.add(this.root);
        return getLevelNodes(treeNodes);
    }

    private List<T> getLevelNodes(List<Node<T>> nodes) {
        List<Node<T>> levelNodes = new ArrayList<>();
        List<T> levelNodesValues = new ArrayList<>();

        nodes.stream().filter(Objects::nonNull).forEach(node -> {
            levelNodesValues.add(node.getData());
            levelNodes.add(node.getLeft());
            levelNodes.add(node.getRight());
        });

        if (!levelNodes.isEmpty())
            levelNodesValues.addAll(getLevelNodes(levelNodes));

        return levelNodesValues;
    }

    static class Node<T> {

        private T data;
        private Node<T> left = null;
        private Node<T> right = null;

        Node(T data) {
            this.data = data;
        }

        Node<T> getLeft() {
            return left;
        }

        Node<T> getRight() {
            return right;
        }

        T getData() {
            return data;
        }

        void setLeft(Node<T> left) {
            this.left = left;
        }

        void setRight(Node<T> right) {
            this.right = right;
        }

        boolean isComplete() {
            return this.right != null && this.left != null;
        }

    }
}
