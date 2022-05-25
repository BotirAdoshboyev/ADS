package knapsack;


import java.util.ArrayList;

/*
 * ==== input ====
 * weight: {2,5,4,3}
 * profit: {5,4,2,1}
 * capacity: 10
 * ==== output ====
 * knapsack: {5,4,1} => possible max profit by not exceeding capacity 10
 * ================
 * possible weights: [[2, 4, 3], [2, 5, 3], [2, 3], [5, 4], [2, 4], [2, 5], [2]]
 * possible profits: [[5, 2, 1], [5, 4, 1], [5, 1], [4, 2], [5, 2], [5, 4], [5]]
 * */
public class Knapsack {

    static ArrayList<Integer> knapsack(int[] weight, int[] profit, int capacity) {
        ArrayList<ArrayList<Integer>> possibleProfits = solve(weight, capacity, weight.length - 1, profit);
        int maxProfitIndex = -1;
        int maxProfit = 0;
        for (int i = 0; i < possibleProfits.size() - 1; i++) {
            int sum = 0;
            for (int p : possibleProfits.get(i)) sum += p;
            if (sum > maxProfit) {
                maxProfit = sum;
                maxProfitIndex = i;
            }
        }
        return possibleProfits.get(maxProfitIndex);
    }

    static ArrayList<ArrayList<Integer>> solve(int[] weight, int capacity, int index, int[] profit) {
        if (index < 0) {
            return new ArrayList<>(); // base condition
        }
        if (weight[index] <= capacity) {
            ArrayList<ArrayList<Integer>> currKnapsack = new ArrayList<>();
            ArrayList<Integer> currItem = new ArrayList<>();
            currItem.add(profit[index]);
            currKnapsack.add(currItem);
            ArrayList<ArrayList<Integer>> included = solve(weight, capacity - weight[index], index - 1, profit);
            ArrayList<ArrayList<Integer>> excluded = solve(weight, capacity, index - 1, profit);
            if (included.isEmpty()) included = currKnapsack;
            else for (ArrayList<Integer> item : included) item.add(profit[index]);
            included.addAll(excluded);
            return included;
        } else {
            return solve(weight, capacity, index - 1, profit);
        }

    }
}
