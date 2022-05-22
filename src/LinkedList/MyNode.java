package LinkedList;

import java.util.Objects;

public class MyNode {

    Integer value = null;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }

    MyNode next = null;

    public MyNode() {}

    public MyNode(Integer value) {
        this.value = value;
    }

    public MyNode(Integer value, MyNode next) {
        this(value);
        this.next = next;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    @Override
    public String toString() {
        return "MyNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyNode myNode = (MyNode) o;
        return Objects.equals(value, myNode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    static MyNode tempHead = null;
    static MyNode prev = null;

    // traverse
    public static void traverseIterative(MyNode head) {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    public static void traverseRecursive(MyNode head) {
        if (head == null) return;
        System.out.println(head.value);
        traverseRecursive(head.next);
    }

    // reverse linked list assuming that we do not have access to use previous field
    public static MyNode reverseIterative(MyNode head) {
        MyNode previous = null;
        MyNode curr = head;
        MyNode next = head.next;
        while (next != null) {
            curr.next = previous;
            previous = curr;
            curr = next;
            next = curr.next;
        }
        curr.next = previous;
        return curr;
    }

    static MyNode last = null;
    public static MyNode reverseRecursive(MyNode head) {
        if (head.next == null) {
            last = head;
            return head;
        }
        MyNode rest = reverseRecursive(head.next);
        head.next = null;
        rest.next = head;
        System.out.println(last);
        return head;
    }

    // add item at index, 0-based
    public static MyNode addNodeAtIndexIterative(int index, MyNode head, MyNode additionalNode) {
        MyNode curr = head;
        MyNode prev = null;
        int i = 0;
        while (i != index) {
            if (curr == null) throw new RuntimeException("Index exceeded, index must be less than " + (i+1));
            prev = curr;
            curr = curr.next;
            i++;
        }
        additionalNode.next = curr;
        if (prev != null) {
            prev.next = additionalNode;
        } else {
            return additionalNode;
        }
        return head;
    }

    public static MyNode addNodeAtIndexRecursive(int index, MyNode head, MyNode additionalNode) {
        if (index == 0) {
            additionalNode.next = head;
            if (tempHead == null) {
                return additionalNode; // index = 0
            } else {
                prev.next = additionalNode;
                return tempHead;
            }
        }
        if (tempHead == null) tempHead = head;
        prev = head;
        if (head == null) throw new RuntimeException("Index exceeded");
        return addNodeAtIndexRecursive(--index, head.next, additionalNode);
    }

    // Remove item at index, 0-based
    public static MyNode removeItemAtIndexIterative(int index, MyNode head) {
        MyNode curr = head;
        MyNode prev = null;
        int i = 0;
        while (i != index) {
            if (curr.next == null) throw new RuntimeException("Index exceeded");
            prev = curr;
            curr = curr.next;
            i++;
        }
        if (prev != null) {
            prev.next = curr.next;
            return head;
        }
        return curr.next;
    }

    public static MyNode removeItemAtIndexRecursive(int index, MyNode head) {
        if (index == 0) {
            if (tempHead == null) return head.next; // index = 0
            prev.next = head.next;
            return tempHead;
        }
        if (tempHead == null) tempHead = head;
        prev = head;
        if (head.next == null) throw new RuntimeException("Index exceeded");
        return removeItemAtIndexRecursive(--index, head.next);
    }

    /*
    * input
    * first: {1,2,3,4}
    * second: {10,11,12,13,14,15}
    * output
    * {1,10,2,11,3,12,4,13,14,15}
    * */
    public static MyNode zipListIterative(MyNode first, MyNode second) {
        MyNode firstCurr = first;
        MyNode secondCurr = second;
        while (firstCurr != null && secondCurr != null) {
            // save current nodes temporarily
            MyNode secondNext = secondCurr.next;
            MyNode firstNext = firstCurr.next;

            // zip
            if (firstNext != null) secondCurr.next = firstNext; // size of first list is less than size of second list
            firstCurr.next = secondCurr;

            // iteration
            secondCurr = secondNext;
            firstCurr = firstNext;
        }
        return first;
    }

    public static MyNode zipListRecursive(MyNode first, MyNode second) {
        if (tempHead == null) tempHead = first;
        // save nodes temporarily
        MyNode firstNext = first.next;
        MyNode secondNext = second.next;

        // zip
        if (firstNext != null) second.next = firstNext;
        first.next = second;

        if (firstNext == null || secondNext == null) return tempHead; // base case

        return zipListRecursive(firstNext, secondNext);
    }
}














