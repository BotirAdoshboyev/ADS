package graph.algoExpertDFS;

class Program {
    public static int findClosestValueInBst(BST tree, int target) {
        int potentialAns = tree.value;
        BST curr = tree;
        while (curr != null) {
            if (potentialAns > target) {

            }
        }
        return -1;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
