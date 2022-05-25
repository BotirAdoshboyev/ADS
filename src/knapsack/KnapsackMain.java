package knapsack;

import java.util.ArrayList;

public class KnapsackMain {
    public static void main(String[] args) {
        int[] weight = {2,5,4,3};
        int[] profit = {5,4,2,1};
        ArrayList<Integer> res = Knapsack.knapsack(weight, profit, 10);
        System.out.println(res);
    }
}
