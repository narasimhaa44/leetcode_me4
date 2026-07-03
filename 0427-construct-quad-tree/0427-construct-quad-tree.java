/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

// class Solution {
//     public Node construct(int[][] grid) {
        
//     }
// }
class Solution {

    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }

    private Node build(int[][] grid, int row, int col, int size) {

        if (isSame(grid, row, col, size)) {
            return new Node(grid[row][col] == 1, true);
        }

        int half = size / 2;

        Node root = new Node(true, false);

        root.topLeft = build(grid, row, col, half);

        root.topRight = build(grid, row, col + half, half);

        root.bottomLeft = build(grid, row + half, col, half);

        root.bottomRight = build(grid, row + half, col + half, half);

        return root;
    }

    private boolean isSame(int[][] grid, int row, int col, int size) {

        int val = grid[row][col];

        for (int i = row; i < row + size; i++) {

            for (int j = col; j < col + size; j++) {

                if (grid[i][j] != val)
                    return false;
            }
        }

        return true;
    }
}