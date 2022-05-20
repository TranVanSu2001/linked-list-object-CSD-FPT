package linkedlistinclass;

public class Node {

    int info;
    Node next;

    public Node(int x) {
        info = x;
        next = null;
    }

    @Override
    public String toString() {
        return "Node: " + info;
    }
    
    

}
