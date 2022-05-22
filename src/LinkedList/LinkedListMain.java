package LinkedList;

public class LinkedListMain {
    public static void main(String[] args) {
        MyNode node1 = new MyNode(1);
        MyNode node2 = new MyNode(2);
        MyNode node3 = new MyNode(3);
        MyNode node4 = new MyNode(4);
        MyNode node5 = new MyNode(5);
        MyNode node6 = new MyNode(6);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        // For zipList problem
        MyNode node21 = new MyNode(10);
        MyNode node22 = new MyNode(11);
        MyNode node23 = new MyNode(12);
        MyNode node24 = new MyNode(13);
        MyNode node25 = new MyNode(14);
        MyNode node26 = new MyNode(15);

        node21.setNext(node22);
        node22.setNext(node23);
        node23.setNext(node24);
        node24.setNext(node25);
        node25.setNext(node26);


//        MyNode.traverseIterative(node1);
//        MyNode.traverseRecursive(node1);
//        MyNode reversedNode = MyNode.reverseRecursive(node1);
//        System.out.println(reversedNode);

        // Add Node at Index
//        MyNode newNode = new MyNode(44);
//        MyNode res = MyNode.addNodeAtIndexRecursive(6, node1, newNode);
////        MyNode res = MyNode.addNodeAtIndexIterative(7, node1, newNode);

        // Remove Node at Index
//        MyNode res = MyNode.removeItemAtIndexRecursive(5, node1);
//        MyNode res = MyNode.removeItemAtIndexIterative(0, node1);


        // ZipList
        MyNode res = MyNode.zipListRecursive(node1, node21);
//        MyNode res = MyNode.zipListIterative(node1, node21);
        System.out.println(res);
    }
}
