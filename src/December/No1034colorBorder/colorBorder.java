package December.No1034colorBorder;

//        给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色。
//
//        两个网格块属于同一 连通分量 需满足下述全部条件：
//
//        两个网格块颜色相同
//        在上、下、左、右任意一个方向上相邻
//        连通分量的边界 是指连通分量中满足下述条件之一的所有网格块：
//
//        在上、下、左、右四个方向上与不属于同一连通分量的网格块相邻
//        在网格的边界上（第一行/列或最后一行/列）
//        请你使用指定颜色color 为所有包含网格块grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格grid 。
//
//        示例 1：
//        输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
//        输出：[[3,3],[3,2]]
//
//        示例 2：
//        输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
//        输出：[[1,3,3],[2,3,3]]
//
//        示例 3：
//        输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
//        输出：[[2,2,2],[2,1,2],[2,2,2]]

public class colorBorder {
//    执行用时：1 ms, 在所有 Java 提交中击败了82.67%的用户
//    内存消耗：39.3 MB, 在所有 Java 提交中击败了60.89%的用户
    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean[][] ishere = new boolean[grid.length][grid[0].length];
        ishere[row][col]=true;
        int target = grid[row][col];
        if (isEdge(ishere,grid,row,col,target)){
            grid[row][col]=color;
        }
        changeColor(ishere,grid, row, col, color,target);

        return grid;
    }
    public static void changeColor(boolean[][] ishere,int[][] grid,int row,int col,int color,int target){
        if (col+1<grid[0].length && grid[row][col+1]==target ){
        if (!ishere[row][col+1]){
            if (isEdge(ishere,grid,row,col+1,target)){
                grid[row][col+1]=color;
                ishere[row][col+1]=true;
            }else {
                ishere[row][col+1]=true;
            }
                changeColor(ishere,grid,row,col+1,color,target);

        }
        }
        if (row+1<grid.length &&grid[row + 1][col]==target ) {
            if (!ishere[row + 1][col]) {
                if (isEdge(ishere,grid, row + 1, col,target)) {
                    grid[row + 1][col] = color;
                    ishere[row + 1][col] = true;
                } else {
                    ishere[row + 1][col] = true;
                }
                    changeColor(ishere, grid, row + 1, col, color,target);

            }
        }
        if (col-1>-1 && grid[row][col-1]==target){
        if (!ishere[row][col-1]){
            if (isEdge(ishere,grid,row,col-1,target)){
                grid[row][col-1]=color;
                ishere[row][col-1]=true;
            }else {
                ishere[row][col-1]=true;
            }
                changeColor(ishere,grid,row,col-1,color,target);

        }
        }
        if (row-1>-1 && grid[row-1][col]==target) {
            if (!ishere[row - 1][col]) {
                if (isEdge(ishere,grid, row - 1, col,target)) {
                    grid[row - 1][col] = color;
                    ishere[row - 1][col] = true;
                } else {
                    ishere[row - 1][col] = true;
                }
                    changeColor(ishere, grid, row - 1, col, color,target);

            }
        }

    }
    public static boolean isEdge(boolean[][] ishere,int[][] grid,int row,int col,int target){
        if (grid[row][col]==target){
        if (row==0 || row == grid.length-1){
            return true;
        }
        if (col==0 || col == grid[0].length-1){
            return true;
        }
        if ((grid[row][col]!=grid[row-1][col] && !ishere[row-1][col]) ||
                (grid[row][col]!=grid[row+1][col] && !ishere[row+1][col]) ||
                (grid[row][col]!=grid[row][col-1] && !ishere[row][col-1]) ||
                (grid[row][col]!=grid[row][col+1] && !ishere[row][col+1])){
            return true;
        }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,2,1,2,1,2},{2,2,2,2,1,2},{1,2,2,2,1,2}};
        System.out.println(colorBorder(test,1,3,1));
    }
}
