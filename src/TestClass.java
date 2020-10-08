
public class TestClass {
    public static void main(String[] args) {
        PDS<Integer> bt = new PDS<>();

        bt.add(1);
        
        bt.add(2);
        bt.add(3);
        bt.add(4);
        bt.add(5);

        System.out.println("Affected nodes: " + bt.getNodeList().toString());
        BSTPrinter.printNode(bt.getRootNode());
    }
}
