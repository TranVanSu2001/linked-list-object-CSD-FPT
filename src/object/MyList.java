package object;

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

    //    void addToHead(int x) - add a node with value x  at the head of  a list.
    public void addToHead(String name, int age) {
        Node p = new Node(name, age);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        p.next = head;
        head = p;
    }

//    void addToTail(int x) - add a node with value x  at the tail of  a list.
    public void addToTail(String name, int age) {
        Node p = new Node(name, age);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        tail.next = p;
        tail = p;
    }
//    void addAfter(Node p, int x) - add a node with value x  after the node p.

    public void addAfter(Node p, String name, int age) {
        if (p == null) {
            return;
        }
        if (p == tail) {
            addToTail(name, age);
            return;
        }
        Node nodeBeAdded = new Node(name, age);
        nodeBeAdded.next = p.next;
        p.next = nodeBeAdded;
        if (nodeBeAdded.next == null) {
            tail = nodeBeAdded;
        }
    }

    //remove head
    public void deleteFromHead() {
        if (isEmpty()) {
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }
        head = head.next;
    }

    //remove tail
    public void deleteFromTail() {
        if (isEmpty()) {
            return;
        }
        if (head == tail) {
            head = tail = null;
            return;
        }
        Node curNode = head;
        while (curNode != null) {
            if (curNode.next.next == null) {
                curNode.next = null;
                tail = curNode;
            }
            curNode = curNode.next;
        }
        return;
    }

    //print myList
    public void traverse() {
        Node p = head;
        while (p != null) {
            System.out.print("(" + p.info.name + "," + p.info.age + ")");
            p = p.next;
        }
        System.out.println();
    }

    //count element
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

    //---------------------------------------
//   1. addLast(String xName, int xAge) - check if xName has the first 
//    letter 'B' of xAge < 17 then do nothing, otherwise add new person to end of the list
    public void addLast(String xName, int xAge) {
        if (xName.startsWith("B") || xAge < 17) {
            return;
        } else {
            Node p = new Node(xName, xAge);
            if (isEmpty()) {
                head = tail = p;
                return;
            }
            tail.next = p;
            tail = p;
        }
    }

    //  2. delete first node having age = 20
    public void dele() {
        if (isEmpty()) {
            return;
        }

        if (head.info.age == 20) {
            if (head == tail) {
                head = tail = null;
                return;
            }
            deleteFromHead();
            return;
        }

        Node curNode = head;
        while (curNode.next != null) {
            if (curNode.next.info.age == 20) {
                if (curNode.next == tail) {
                    deleteFromTail();
                    return;
                } else {
                    curNode.next = curNode.next.next;
                    return;
                }
            }
            curNode = curNode.next;
        }
    }

    //3. display the first 5 person having age > 22
    public void diplayPerson() {
        int count = 0;
        Node curNode = head;
        if (head == null) {
            return;
        }

        while (curNode != null) {
            if (count < 5) {
                if (curNode.info.age > 22) {
                    System.out.println(curNode);
                    count++;
                }
            } else {
                return;
            }
            curNode = curNode.next;
        }
    }

//    4. Find the second max age. Display the first person having that age
    public void findSecondMax() {
        if (head == tail || head == null) {
            return;
        }

        Node curNode = head;
        int index = 0;
        int[] arrayAge = new int[count()];
        while (curNode != null) {
            arrayAge[index] = curNode.info.age;  //create array to store age 
            index++;
            curNode = curNode.next;
        }

        //sort array ascending
        for (int i = 0; i < arrayAge.length - 1; i++) {
            for (int j = 0; j < arrayAge.length - i - 1; j++) {
                if (arrayAge[j] > arrayAge[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arrayAge[j];
                    arrayAge[j] = arrayAge[j + 1];
                    arrayAge[j + 1] = temp;
                }
            }
        }

        int secondMax = arrayAge[arrayAge.length - 2];

        Node findNode = head;
        while (findNode != null) {
            if (findNode.info.age == secondMax) {
                System.out.println(findNode);
                return;
            }

            findNode = findNode.next;
        }
    }

    // 5. sort the list descendingly by age
    public void sort() {
        if (isEmpty()) {
            return;
        }
        for (Node node1 = head; node1 != null; node1 = node1.next) {
            for (Node node2 = node1.next; node2 != null; node2 = node2.next) {
                if (node1.info.age < node2.info.age) {
                    int temp = node1.info.age;
                    node1.info.age = node2.info.age;
                    node2.info.age = temp;
                }
            }
        }
    }

    //6. Delete the last node having age = 20
    public void deleteLastNode() {
        if (head == null) {
            return;
        }
        if (tail.info.age == 20) {
            deleteFromTail();
            return;
        }

        Node curNode = head;
        int count = 0;
        while (curNode != null) {

            if (curNode.info.age == 20) {
                count++;
            }
            curNode = curNode.next;
        }

        int countDel = 0;
        Node prevNode = head;
        Node currNode = head;
        while (currNode.next != null) {

            if (currNode.info.age == 20) {
                countDel++;
            }

            if (countDel == count) {
                prevNode.next = currNode.next;
                return;
            }

            prevNode = currNode;
            currNode = currNode.next;
        }
    }

    // 7. Display the last 5 person having age > 22
    public void displayFiveLast() {
        Node curNode = head;
        int count = 0; //count the person valid
        while (curNode != null) {

            if (curNode.info.age > 22) {
                count++;
            }
            curNode = curNode.next;
        }

        int countDisplay = 0;
        Node dNode = head;
        while (dNode != null) {

            if (dNode.info.age > 22) {
                if (countDisplay >= count - 5) {
                    System.out.println(dNode);
                }
            }

            if (dNode.info.age > 22) {
                countDisplay++;
            }

            dNode = dNode.next;
        }
    }

    // 8. find the third max age
    public void findThirdMax() {
        if (head == tail || head == null) {
            return;
        }

        Node curNode = head;
        int index = 0;
        int[] arrayAge = new int[count()];
        while (curNode != null) {
            arrayAge[index] = curNode.info.age;  //create array to store age 
            index++;
            curNode = curNode.next;
        }

        //sort array ascending
        for (int i = 0; i < arrayAge.length - 1; i++) {
            for (int j = 0; j < arrayAge.length - i - 1; j++) {
                if (arrayAge[j] > arrayAge[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arrayAge[j];
                    arrayAge[j] = arrayAge[j + 1];
                    arrayAge[j + 1] = temp;
                }
            }
        }

        int thirdMax = arrayAge[arrayAge.length - 3];

        Node findNode = head;
        while (findNode != null) {
            if (findNode.info.age == thirdMax) {
                System.out.println(findNode);
                return;
            }

            findNode = findNode.next;
        }
        return;
    }

    //9. add(String xName, int xAge, int index) - insert the new person at the given index
    public void addPersonIndex(String xName, int xAge, int index) {
        if (head == null) {
            return;
        }
        Node newNode = new Node(xName, xAge);
        Node curNode = head;
        Node prevNode = null;
        int i = 0;
        while (curNode.next != null) {
            if (index == i) {
                newNode.next = curNode;
                prevNode.next = newNode;
                return;
            }

            i++;
            prevNode = curNode;
            curNode = curNode.next;
        }
    }

    //find node by index
    public Node findNodeIndex(int index) {
        if (head == null) {
            return null;
        }
        Node curNode = head;
        Node prevNode = null;
        int i = 0;
        while (curNode.next != null) {
            if (index == i) {
                return curNode;
            }

            i++;
            prevNode = curNode;
            curNode = curNode.next;
        }

        return null;

    }

    //10. sort(int startIndex, int endIndex) - sort the linked list ascending by name from startIndex to endIndex
    public void sort(int startIndex, int endIndex) {
        Node startNode = findNodeIndex(startIndex);
        Node endNode = findNodeIndex(endIndex);

        //loop to sort
        for (Node node1 = startNode; node1 != endNode; node1 = node1.next) {
            for (Node node2 = node1.next; node2 != null; node2 = node2.next) {
                if (node1.info.name.charAt(0) > node2.info.name.charAt(0)) {
                    String temp = node1.info.name;
                    node1.info.name = node2.info.name;
                    node2.info.name = temp;
                }
            }
        }
    }
}
