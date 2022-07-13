package algoExpert.Arrays;

import java.util.*;

public class ArraySolutions {

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> res = new ArrayList<>();
        Arrays.sort(array);
        Set<Integer> map = new HashSet<>();
        for (int k : array) map.add(k);

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int lookingFor = targetSum - array[i] - array[j];
                if (map.contains(lookingFor) && lookingFor > array[j]) {
                    Integer[] triple = new Integer[3];
                    triple[0] = array[i];
                    triple[1] = array[j];
                    triple[2] = lookingFor;
                    res.add(triple);
                }
            }
        }
        return res;
    }

//    private static Integer[] twoSum(int[] array, int firstNumIndex, int target, Map<Integer, Integer> map) {
//        Integer[] res = new Integer[3];
//        for (int i = firstNumIndex; i < array.length; i++) {
//            int lookingFor = target - array[firstNumIndex] - array[i];
//            if (map.containsKey(lookingFor) && map.get(lookingFor) > i) {
//                res = ;
//                res[0] = array[firstNumIndex];
//                res[1] = array[i];
//                res[2] = lookingFor;
//            }
//        }
//        return res;
//    }


    public static List<Integer> spiralTraverse2(int[][] array) {
        List<Integer> ans = new ArrayList<>();
        boolean[][] visited = new boolean[array.length][array[0].length];
        visited[0][0] = true;
        ans.add(array[0][0]);
        boolean forward = true;
        int i = 0, j = 0;
        while (ans.size() < array.length * array[0].length) {
            if (forward) {
                if (j + 1 < array[0].length && !visited[i][j + 1]) {
                    visited[i][++j] = true;
                    ans.add(array[i][j]);
                } else if (i + 1 < array.length && !visited[i + 1][j]) {
                    visited[++i][j] = true;
                    ans.add(array[i][j]);
                } else forward = false;
            } else {
                if (j - 1 >= 0 && !visited[i][j - 1]) {
                    visited[i][--j] = true;
                    ans.add(array[i][j]);
                } else if (i - 1 >= 0 && !visited[i - 1][j]) {
                    visited[--i][j] = true;
                    ans.add(array[i][j]);
                } else forward = true;
            }
        }
        return ans;
    }

    private static boolean[][] visited;

    public static List<Integer> spiralTraverse(int[][] array) {
        int i = 0, j = 0;
        List<Integer> ans = new ArrayList<>();
        visited = new boolean[array.length][array[0].length];
        while (ans.size() < array.length * array[0].length)
            ans.addAll(traversePerimeter(array, i++, j++));
        return ans;
    }

    private static List<Integer> traversePerimeter(int[][] array, int i, int j) {
        List<Integer> perimeter = new ArrayList<>();
        int maxI = array.length, maxJ = array[0].length;
        while (j < maxJ && !visited[i][j]) {
            visited[i][j] = true;
            perimeter.add(array[i][j]);
            j++;
        }
        j--;
        i++;
        while (i < maxI && !visited[i][j]) {
            visited[i][j] = true;
            perimeter.add(array[i][j]);
            i++;
        }
        i--;
        j--;
        while (j >= 0 && !visited[i][j]) {
            visited[i][j] = true;
            perimeter.add(array[i][j]);
            j--;
        }
        j++;
        i--;
        while (i >= 0 && !visited[i][j]) {
            visited[i][j] = true;
            perimeter.add(array[i][j]);
            i--;
        }
        return perimeter;
    }

    public static int longestPeak(int[] array) {
        int tipIndex = 1;
        int ans = 0;
        while (tipIndex < array.length - 1) {
            if (array[tipIndex] > array[tipIndex - 1] && array[tipIndex] > array[tipIndex + 1]) {
                int left = tipIndex - 1, right = tipIndex + 1;
                while (left > 0 && array[left - 1] < array[left])
                    left--;
                while (right < array.length - 1 && array[right + 1] < array[right])
                    right++;
                ans = Math.max(ans, right - left + 1);
                tipIndex = right;
                continue;
            }
            tipIndex++;
        }
        return ans;
    }

    public static int minimumLengthEncoding(String[] words) {
        StringBuilder builder = new StringBuilder();
        Set<String> substrings = new HashSet<>();
        for (String word : words) {
            if (word.length() < 1)
                continue;
            int fromIndex = 1;
            while (fromIndex < word.length())
                substrings.add(word.substring(fromIndex++));
        }
        for (String word : words) {
            if (!substrings.contains(word)) {
                builder.append(word).append("#");
                substrings.add(word);
            }
        }
        return builder.length();
    }

    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        List<int[]> ansList = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0])); // O(nlog(n)) - time
        System.out.println(Arrays.deepToString(intervals));
        int prev = 0, curr = 1;
        while (curr < intervals.length) {
            int[] currInterval = intervals[curr];
            int[] prevInterval = intervals[prev];
            if (prevInterval[1] >= currInterval[0]) {
                intervals[prev][1] = intervals[curr++][1];
                if (curr == intervals.length - 1)
                    ansList.add(intervals[prev]);
            } else {
                ansList.add(prevInterval);
                if (curr == intervals.length - 1)
                    ansList.add(currInterval);
                prev = curr;
                curr++;
            }
        }
        int[][] ans = new int[ansList.size()][];
        for (int i = 0; i < ansList.size(); i++) ans[i] = ansList.get(i);
        return ans;
    }

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        for (int i = 1; i < heights.length; i++) {
            int prev = heights[i - 1], curr = heights[i];
            if (curr - prev > bricks && ladders == 0) return i - 1;
            if (prev < curr) {
                if (curr - prev <= bricks)
                    bricks -= curr - prev;
                else if (curr - prev > bricks && ladders > 0)
                    ladders--;
            }
            if (i == heights.length - 1) return i;
        }
        return 0;
    }

    //    public static int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> heap = new PriorityQueue<>();
//        for (int num : nums)
//            heap.add(num * -1);
//        System.out.println(heap.poll());
//        return 1;
//    }

    public static int maxSubsetSumNoAdjacent(int[] array) {
        if (array.length == 0) return 0;
        if (array.length == 2) return Math.max(array[0], array[1]);
        if (array.length == 3) return Math.max(array[1], array[0] + array[2]);
        for (int i = 3; i < array.length; i++) {
            array[i] = Math.max(array[i - 3] + array[i], array[i-2] + array[i]);
            array[i] = Math.max(array[i], array[i-1]);
        }
        return array[array.length - 1];
    }

    public static void main(String[] args) {
        int[] h = {4, 3, 5, 200, 5, 3};
        int[][] c = {{5, 5}, {4, 6}, {2, 6}};
        int res = maxSubsetSumNoAdjacent(h);
        System.out.println(res);
    }
}


