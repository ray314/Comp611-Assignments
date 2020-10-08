public class BinarySearchTree<T extends Comparable<T>> {
    protected Node<T> root;

    public void nodeDiscovered(Node<T> current) {

    }

    public void addNodeToList() {

    }

    public void insertedNode(Node<T> newNode) {

    }

    private Node<T> addRecursive(Node<T> current, Node<T> newNode) {
        T data = newNode.data;
        if (current == null) {
            // Add new node
            nodeDiscovered(newNode);
            return newNode;
        }
        nodeDiscovered(current);
        if (data.compareTo(current.data) < 0) {
            current.left = addRecursive(current.left, newNode);
        } else if (data.compareTo(current.data) > 0) {
            current.right = addRecursive(current.right, newNode);
        } else {
            return current;
        }
        
        return current;
    }

    /**
     * Adds a node to the tree and returns the new node
     * @param data
     */
    public Node<T> add(T data) {
        Node<T> newNode = new Node<>(data);
        root = addRecursive(root, newNode);
        addNodeToList();
        return newNode;
    }

    private boolean containsNodeRecursive(Node<T> current, T data) {
        if (current == null) {
            return false;
        } else if (data == current.data) {
            return true;
        }
        return data.compareTo(current.data) < 0 
        ? containsNodeRecursive(current.left, data)
        : containsNodeRecursive(current.right, data);
    }

    public boolean containsNode(T data) {
        return containsNodeRecursive(root, data);
    }

    private T findSmallestData(Node<T> root) {
        return root.left == null ? root.data : findSmallestData(root.left);
    }

    private Node<T> deleteRecursive(Node<T> current, T data) {
        if (current == null) {
            return null;
        }

        if (data == current.data) {
            if (current.left == null && current.right == null) {
                return null;
            } else if (current.right == null) {
                return current.left;
            } else if (current.left == null){
                return current.right;
            } else {
                T smallestNode = findSmallestData(current.right);
                current.data = smallestNode;
                current.right = deleteRecursive(current.right, smallestNode);
                return current;
            }
        }

        if (data.compareTo(current.data) < 0) {
            current.left = deleteRecursive(current.left, data);
            return current;
        }
        current.right = deleteRecursive(current.right, data);
        return current;
    }

    public void delete(T data) {
        root = deleteRecursive(root, data);
    }

    public Node<T> getRootNode() {
        return root;
    }
}
