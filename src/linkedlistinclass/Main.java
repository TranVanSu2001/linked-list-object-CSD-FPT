package linkedlistinclass;

public class Main {

    public static void main(String[] args) {
        MyList list = new MyList();
        list.addToHead(1);
        list.addToHead(2);
        list.addToHead(3);
        list.addToHead(4);
        list.addToHead(10);

        list.traverse();

        Node m = list.search(1);
        int info =list.deleteFromTail();
        System.out.println(info);
        list.traverse();
//        list.addAfter(m, 0);
//
//        list.addToHead(5);
//        list.addToTail(6);
//
//        list.addToTail(7);
//        list.addToHead(10);
//        list.addToTail(16);'

        //---- addAfter
//        Node n = list.search(6);
//        list.addAfter(n, 8);
//        Node m = list.search(8);
//        list.addAfter(m, -10);
//---
        //---- deleteFromTail
//        list.deleteFromTail();
//        list.deleteFromTail();
//        int x = list.deleteFromTail();
        //---- dele
//        list.dele(10);
        //----deleteAfter
//        Node m = list.search(5);
//        list.deleteAfter(m);
        //----count
//        int count = list.count();
//        System.out.println("count: " + count);
//        list.traverse();
        //---- delIndex
//        list.delIndex(1);
//        sort
//        list.sort();
        //----dele
//        list.dele(10);
        //----addBefore
//        list.traverse();
//        Node m = list.search(7);
//        list.addBefore(m, 4);
//        list.traverse();
        //----max
//        int max = list.max();
//        System.out.println("max: " + max);
//        ----min
//        int min = list.min();
//        System.out.println("min: " + min);
//        ----sum
//        int sum = list.sum();
//        System.out.println("sum: " + sum);
//        ----avg
//        int avg = list.avg();
//        System.out.println("avg: " + avg);
//         ----toArray
//        int[] number = list.toArray();
//        for (int i : number) {
//            System.out.print(i + " ");
//
//        }
//        ----sorted
//        list.addToHead(1);
//        list.addToHead(2);
//        list.addToHead(3);
//        list.addToHead(4);
//        list.traverse();
//
        list.traverse();

//        boolean flag = list.sorted();
//        System.out.println("flag: " + flag);
    }
}
