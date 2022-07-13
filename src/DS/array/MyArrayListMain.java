package DS.array;

public class MyArrayListMain {
    public static void main(String[] args) {
        MyArrayList<Integer> arr = new MyArrayList<>();
        for (int i = 0; i < 16; i++)
            arr.add(i);
        System.out.println(arr);
        arr.removeAt(0);
//
//        int s = arr.size();
//        for (int i = 0; i < s; i++) {
//            arr.removeAt(0);
//        }
        System.out.println(arr);
    }
}
