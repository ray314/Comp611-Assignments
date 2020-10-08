import java.util.LinkedList;
import java.util.List;

public class PDS<T extends Comparable<T>> extends BinarySearchTree<T> {

    protected List<List<Node<T>>> list; // List for adding lists of nodes
    protected List<Node<T>> tempList; // Temporary list for adding nodes

    public PDS() {
        super();
        list = new LinkedList<>();
        tempList = new LinkedList<>();
    }

    @Override
    /**
     * When a node is discovered, add it to temporary list
     */
    public void nodeDiscovered(Node<T> current) {
        tempList.add(current);
    };

    @Override
    /**
     * When the algorithm has inserted a new node
     */
    public void insertedNode(Node<T> newNode) {
        
    }

    @Override
    /**
     * After adding all the nodes, add the temporary list to another list
     */
    public void addNodeToList() {
        list.add(tempList);
        tempList = new LinkedList<>();
    }
    
    public List<List<Node<T>>> getNodeList() {
        return list;
    }
}
