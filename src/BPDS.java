import java.util.Iterator;
import java.util.List;

public class BPDS<T extends Comparable<T>> extends PDS<T> {
    
    /**
     * Exception thrown by {@link #blackHeight} if the black-height of
     * a node is ill-defined.
     */
    public static class BlackHeightException extends RuntimeException
    {
    }

    public BPDS() {
        super();
    }

    protected void leftRotate(Node<T> x) {
        Node<T> y = x.right;
        Node<T> xParent;
        Node<T> yParent;
        x.right = y.left;
        xParent = getParentNode(x);
        yParent = getParentNode(y);
        if (y.left != null) {
            Node<T> yLeftParent = getParentNode(y.left);
            yLeftParent = x;
        }
        // make y the parent
        yParent = xParent; // reassign the parent of y
        if (xParent == null) {
            root = y;
        } else {
            if (x == xParent.left) {
                xParent.left = y;
            } else {
                xParent.right = y;
            }
        }
        y.left = x;
        xParent = y;
    }

    protected void rightRotate(Node<T> x) {
        Node<T> y = x.left;

        x.left = y.right;
        if (x.left != null) {
            Node<T> yRightParent = getParentNode(y.right);
            yRightParent = x;
        }

        Node<T> xParent = getParentNode(x);
        Node<T> yParent = getParentNode(y);
        yParent = xParent;

        y.right = x;
        xParent = y;

        if (root == x) {
            root = y;
        } else {
            if (yParent.left == x) {
                yParent.left = y;
            } else {
                yParent.right = y;
            }
        }
    }
    /**
     * Get the parent of this node
     * @param y - the specific node
     * @return the parent node
     */
    private Node<T> getParentNode(Node<T> y) {
        Iterator<List<Node<T>>> it = list.iterator();
        while (it.hasNext()) {
            Iterator<Node<T>> it2 = it.next().iterator();
            Node<T> previousNode = null;
            while (it2.hasNext()) {
                Node<T> tempNode = it2.next();
                if (y == tempNode) { // found the node, get the parent by previous node in the list
                    return previousNode;
                }
                previousNode = tempNode;
            }
        }
        return null;
    }

    public Node<T> add(T data) {
        Node<T> newNode = super.add(data);
        
        insertFixup(newNode);
        return newNode;
    }

    protected void insertFixup(Node<T> z) {
        Node<T> y = null;
        Node<T> zParent = getParentNode(z);

        while (zParent.color == Node.RED) {
            if (zParent == getParentNode(zParent).left) {
                y = getParentNode(zParent).right;
                
            }
        }
    }
}
