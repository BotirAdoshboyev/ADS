package dfs;

public class DFSMain {
    public static void main(String[] args) {
        DFS dfs = new DFS(4, 4);
        int[] row1 = {4,2,5,6};
        int[] row2 = {1,0,7,8};
        int[] row3 = {3,9,13,15};
        int[] row4 = {10,16,11,12};
        dfs.addRow(row1, 0);
        dfs.addRow(row2, 1);
        dfs.addRow(row3, 2);
        dfs.addRow(row4, 3);
        System.out.println(dfs);
    }
}
