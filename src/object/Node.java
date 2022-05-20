package object;

public class Node {

    Person info;
    Node next;

    public Node(String name, int age) {
        info = new Person(name, age);
        next = null;
    }

    @Override
    public String toString() {
        return "Node{" + "info=" + info + ", next=" + next + '}';
    }



}
