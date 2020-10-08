import java.awt.Color;
public class Node<T extends Comparable<?>> {
    /** Color for a red node. */
    protected static final Color RED = Color.red;

    /** Color for a black node. */
    protected static final Color BLACK = Color.black;

    /** The node's color, either RED or BLACK. */
    protected Color color;
    Node<T> left, right;
    T data;
    

    public Node(T data) {
        this.data = data;
        this.color = RED;
    }

    public String toString() {
        return data.toString();
    }
}
