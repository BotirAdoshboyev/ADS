package dfs;

import java.util.Arrays;

public class DFS {

    private int[][] grid;

    public DFS(int n, int m) {
        grid = new int[n][m];
    }

    public void addRow(int[] row, int index) {
        if(index >= grid.length) throw new IndexOutOfBoundsException(index);
        if(row.length > grid[0].length) throw new IndexOutOfBoundsException(row.length);
        grid[index] = row;
    }

    public void gridTraverse() {

    }

    private void girdDfs(int[][] grid, int cell) {
//        System.out.println(cell);
//        if(m == grid.length )
    }



    @Override
    public String toString() {
        return "DFS{" +
                "grid=" + Arrays.deepToString(grid) +
                '}';
    }
}
