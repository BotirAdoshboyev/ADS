package MinSpanningTree;

import java.util.Arrays;

public class MSTMain {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 1, 1};
        int res = nonConstructibleChange(arr);
        System.out.println(res);

    }

    public static int nonConstructibleChange(int[] coins) {
        if(coins.length == 0) return 1;
        int res = 1;
        Arrays.sort(coins);
        while(isConstructable(coins, coins.length-1, res, 0)) res++;
        return res;
    }

    private static boolean isConstructable(int[] coins, int index, int target, int sum) {
        if (sum == target) return true;
        if (index < 0) return false;
        return isConstructable(coins, index - 1, target, coins[index] + sum) || isConstructable(coins, index - 1, target, sum);
    }

}
