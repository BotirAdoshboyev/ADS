package others.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorMain {
    public static void main(String[] args) {
        MyObj obj1 = new MyObj(4, "Botir");
        MyObj obj2 = new MyObj(1, "Jasur");
        MyObj obj3 = new MyObj(6, "Diyor");
        MyObj obj4 = new MyObj(3, "Boymurod");
        MyObj obj5 = new MyObj(9, "O'lmas");


        MyObj[] objs = new MyObj[5];
        objs[0] = obj1;
        objs[1] = obj2;
        objs[2] = obj3;
        objs[3] = obj4;
        objs[4] = obj5;

        Arrays.sort(objs, Comparator.comparing(MyObj::getName)); // asc order
        System.out.println(Arrays.toString(objs));

        Arrays.sort(objs, (MyObj o1, MyObj o2) -> o2.getNumber().compareTo(o1.getNumber())); // desc order
        System.out.println(Arrays.toString(objs));

    }
}
