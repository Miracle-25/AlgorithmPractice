package DataStructureMID.No59generateMatrix;

//        给你一个正整数n ，生成一个包含 1 到n2所有元素，且元素按顺时针顺序螺旋排列的n x n 正方形矩阵 matrix 。
//
//        示例 1：
//        输入：n = 3
//        输出：[[1,2,3],[8,9,4],[7,6,5]]
//
//        示例 2：
//        输入：n = 1
//        输出：[[1]]


public class generateMatrix {
//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：36.7 MB, 在所有 Java 提交中击败了5.20%的用户
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        boolean[][] target = new boolean[n][n];
        int len = n*n;
        int row=0,column=0;
        res[row][column]=1;
        target[row][column]=true;
        for (int i=2;i<len+1;){
            try {
                while (column+1<n && target[row][column+1]==false){
                    column++;
                    res[row][column]=i;
                    target[row][column]=true;
                    i++;
                }
                while (row+1<n && target[row+1][column]==false ){
                    row++;
                    res[row][column]=i;
                    target[row][column]=true;
                    i++;
                }
                while (column-1>=0 && target[row][column-1]==false ){
                    column--;
                    res[row][column]=i;
                    target[row][column]=true;
                    i++;
                }
                while (row-1>=0 && target[row-1][column]==false){
                    row--;
                    res[row][column]=i;
                    target[row][column]=true;
                    i++;
                }

            }catch (Exception e){
                continue;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(generateMatrix(4));
    }
}
