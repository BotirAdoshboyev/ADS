package DS.priorityQueue;

import java.util.Iterator;
import java.util.PriorityQueue;

public class HeapMain {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(14);
        pq.add(7);
        pq.add(22);
        pq.add(3);
        pq.add(6);
        pq.add(12);
        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }
}
//[1, 3, 6, 22, 10, 7, 12]
/*                  1
*               3       6
*            22   10  7   12
* */