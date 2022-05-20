package object;

import linkedlistinclass.*;

public class Main {

    public static void main(String[] args) {
        MyList list = new MyList();

        list.addLast("D", 18);
        list.addLast("C", 2);
        list.addLast("H", 20);
        list.addLast("G", 38);
        list.addLast("M", 78);
        list.addLast("P", 50);
//        list.addLast("L", 60);
//        list.addLast("W", 42);
        list.addLast("S", 20);
        list.addLast("S", 20);
        list.addLast("M", 20);
        list.addLast("N", 22);
        list.addLast("J", 27);
        list.addLast("O", 27);
        list.addLast("U", 27);

//        list.sort();
//        list.deleteLastNode();
//        list.displayFiveLast();
//        list.findThirdMax();
        list.traverse();
        list.sort(0,list.count());
        list.traverse();

//        list.addPersonIndex("sutv", 10000, 2);
//        Node m = list.findNodeIndex(3);
//        System.out.println("");
//        System.out.println(m);
//        list.findSecondMax();
//        list.traverse();

    }
}
