package linkedlistinclass;

public class MyList {

    Node head;
    Node tail;

    MyList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

//    1.   void addToHead(int x) - add a node with value x  at the head of  a list.
    public void addToHead(int x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        p.next = head;
        head = p;
    }

//    2.   void addToTail(int x) - add a node with value x  at the tail of  a list.
    public void addToTail(int x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        tail.next = p;
        tail = p;
    }
//    3.   void addAfter(Node p, int x) - add a node with value x  after the node p.

    public void addAfter(Node p, int x) {
        if (p == null) {
            return;
        }
        if (p == tail) {
            addToTail(x);
            return;
        }
        Node nodeBeAdded = new Node(x);
        nodeBeAdded.next = p.next;
        p.next = nodeBeAdded;
        if (nodeBeAdded.next == null) {
            tail = nodeBeAdded;
        }
    }
//    4.   void traverse() - traverse from head to tail and dislay info of all nodes in the list.

    public void traverse() {
        Node p = head;
        while (p != null) {
            System.out.print(p.info + " ");
            p = p.next;
        }
        System.out.println();
    }

//    5.   int deleteFromHead() - delete the head and return its info.
    public int deleteFromHead() {
        if (isEmpty()) {
            return -1;
        }

        int headInfo = head.info;
        if (head == tail) {
            head = tail = null;
            return headInfo;
        }
        head = head.next;
        return headInfo;
    }

//    6.   int deleteFromTail() - delete the tail and return its info.
    public int deleteFromTail() {
        if (isEmpty()) {
            return -1;
        }
        int tailInfo = tail.info;
        if (head == tail) {
            head = tail = null;
            return tailInfo;
        }
        Node curNode = head;
        while (curNode != null) {
            if (curNode.next.next == null) {
                curNode.next = null;
                tail = curNode;
            }
            curNode = curNode.next;
        }
        return tailInfo;
    }
    
//    7.   int deleteAter(Node p) - delete the node after the node  p  and return its info.
    public int deleteAfter(Node p) {
        if (p == tail || p == null) {
            return -1;
        }
        
        if (p.next == tail) {
            return deleteFromTail();
        }
        
        int nodeInfo = p.next.info;
        p.next = p.next.next;
        return nodeInfo;
    }

//    8.   void dele(int x) - delele the first node whose info is equal to  x.
    public void dele(int x) {
        if (isEmpty()) {
            return;
        }
        
        if (head.info == x) {
            if (head == tail) {
                head = tail = null;
                return;
            }
            deleteFromHead();
            return;
        }
        
        Node curNode = head;
        while (curNode != null) {
            if (curNode.next.info == x) {
                if (curNode.next.next == null) {
                    deleteFromTail();
                } else {
                    curNode.next = curNode.next.next;
                }
                break;
            }
            curNode = curNode.next;
        }

    }

//    9.   Node search(int x) - search and return the reference to the first node having info x.
    public Node search(int x) {
        Node p = head;
        while (p != null) {
            if (p.info == x) {
                return p;
            }
            p = p.next;
        }
        return null;
    }
//    10. int count() - count and return number of nodes in the list.

    public int count() {
        if (isEmpty()) {
            return 0;
        }
        Node curNode = head;
        int count = 0;
        while (curNode != null) {
            count++;
            curNode = curNode.next;
        }
        return count;
    }
//    11. void dele(int i) - delete an i-th node on the list. Besure that such a node exists.

    public void deleIndex(int index) {
        if (index < 0 || index > count() - 1) {
            return;
        }
        if (count() == 1) {
            head = tail = null;
            return;
        }

        if (index == 0) {
            deleteFromHead();
            return;
        }
        if (index == count() - 1) {
            deleteFromTail();
            return;
        }

        int i = 1;
        Node curNode = head;

        while (curNode != null) {
            if (i == index) {
                curNode.next = curNode.next.next;
                return;
            }
            i++;
            curNode = curNode.next;
        }
    }

//    12. void sort() - sort the list by ascending order of info.
    public void sort() {
        if (isEmpty()) {
            return;
        }
        for (Node node1 = head; node1 != null; node1 = node1.next) {
            for (Node node2 = node1.next; node2 != null; node2 = node2.next) {
                if (node1.info > node2.info) {
                    int temp = node1.info;
                    node1.info = node2.info;
                    node2.info = temp;
                }
            }
        }
    }

//    13. void dele(Node p) - delete node p if it exists in the list.
    public void dele(Node p) {
        if (p == head) {
            deleteFromHead();
            return;
        }
        if (p == tail) {
            deleteFromTail();
            return;
        }

        Node curNode = head;

        while (curNode != null) {
            if (curNode.next == p) {
                curNode.next = curNode.next.next;
            }
            curNode = curNode.next;
        }
    }

//    14. int [] toArray() - create and return array containing info of all nodes in the list.
    public int[] toArray() {
        int[] result = new int[count()];
        int index = 0;
        Node curNode = head;
        while (curNode != null) {
            result[index] = curNode.info;
            curNode = curNode.next;
            index++;
        }
        return result;
    }

//    16. void addBefore(Node p, int x) - add a node with value x  before the node p.
    public void addBefore(Node p, int x) {
        if (p == null || isEmpty()) {
            return;
        }
        if (p == head) {
            addToHead(x);
            return;
        }
        Node curNode = head;
        Node nodeBeAdded = new Node(x);
        while (curNode != null) {
            if (curNode.next == p) {
                nodeBeAdded.next = p;
                curNode.next = nodeBeAdded;
                break;
            }
            curNode = curNode.next;
        }
    }

//    18. int max() - find and return the maximum value in the list.
    public int max() {
        if (isEmpty()) {
            return -1;
        }
        if (head == tail) {
            return head.info;
        }
        int max = head.info;
        Node curNode = head.next;
        while (curNode != null) {
            if (curNode.info > max) {
                max = curNode.info;
            }
            curNode = curNode.next;
        }
        return max;
    }

    // 19. int min() - find and return the minimum value in the list. 
    public int min() {
        if (isEmpty()) {
            return -1;
        }
        if (head == tail) {
            return head.info;
        }
        int min = head.info;
        Node curNode = head.next;
        while (curNode != null) {
            if (curNode.info < min) {
                min = curNode.info;
            }
            curNode = curNode.next;
        }
        return min;
    }

    // 20. int sum() - return the sum of all values in the list. 
    public int sum() {
        if (isEmpty()) {
            return -1;
        }
        if (head == tail) {
            return head.info;
        }
        int sum = 0;
        Node curNode = head;
        while (curNode != null) {
            sum += curNode.info;
            curNode = curNode.next;
        }
        return sum;
    }

    // 21. int avg() - return the average of all values in the list.
    public int avg() {
        if (isEmpty()) {
            return -1;
        }
        if (head == tail) {
            return head.info;
        }
        return sum() / count();
    }

//    22. boolean sorted() - check and return true if the list is sorted, return false if the list is not sorted.
    public boolean sorted() {
        Node curNode = head;

        while (curNode != null) {
            if (curNode.next != null && (curNode.info > curNode.next.info)) {
                return false;
            }
            curNode = curNode.next;
        }
        return true;
    }
//     void insert(int x) - insert node with value x into sorted list so that the new list is sorted

    public void insert(int x) {
        Node newNode = new Node(x);

        if (newNode.info < head.info) {
            addToHead(x);
            return;
        }
        if (newNode.info > tail.info) {
            addToTail(x);
            return;
        }

        Node preNode = head;
        Node curNode = head;
        while (curNode != null) {
            if (newNode.info <= curNode.info) {
                preNode.next = newNode;
                newNode.next = curNode;
                break;
            }
            preNode = curNode;
            curNode = curNode.next;
        }
    }

//        24. Reverse a singly linked list using only one pass through the list.
    public void Reverse() {
//            update tail 
        tail = head;
        Node curNode = head;
        while (curNode.next != null) {
            Node nextNode = curNode.next;
            curNode.next = nextNode.next;
            nextNode.next = head;
            head = nextNode;
        }
    }
}
