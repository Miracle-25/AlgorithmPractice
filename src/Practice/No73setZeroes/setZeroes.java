package Practice.No73setZeroes;

//        给定一个m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
//        进阶：
//        一个直观的解决方案是使用 O(mn)的额外空间，但这并不是一个好的解决方案。
//        一个简单的改进方案是使用 O(m+n) 的额外空间，但这仍然不是最好的解决方案。
//        你能想出一个仅使用常量空间的解决方案吗？
//
//        示例 1：
//        输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
//        输出：[[1,0,1],[0,0,0],[1,0,1]]
//
//        示例 2：
//        输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//        输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]

import java.util.ArrayList;
import java.util.List;

public class setZeroes {
//    执行用时：1 ms, 在所有 Java 提交中击败了98.33%的用户
//    内存消耗：40.1 MB, 在所有 Java 提交中击败了16.50%的用户
    public static void setZeroes(int[][] matrix) {
        List<Integer> temp = new ArrayList();
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if (matrix[i][j]==0){
                    temp.add(i);
                    temp.add(j);
                }
            }
        }
        for (int i=0;i< temp.size();i=i+2){
            zero(matrix,temp.get(i),temp.get(i+1));
        }

    }
    public static void zero(int[][] matrix,int r,int c){
        for (int i=0;i<matrix[r].length;i++){
            matrix[r][i]=0;
        }
        for (int j=0;j<matrix.length;j++){
            matrix[j][c]=0;
        }
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(test);
        System.out.println("Finish");
    }
}
