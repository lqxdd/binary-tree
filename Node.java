public class Node {
    public int data;
    public Node left;
    public Node right;

    Node(int data) {
        this.data = data;
        right = null;
        left = null;
    }

    public String toString(){
        return "node " +data;
    }
}
