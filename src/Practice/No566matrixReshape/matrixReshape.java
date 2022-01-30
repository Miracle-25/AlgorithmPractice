package Practice.No566matrixReshape;

//        在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
//        给你一个由二维数组 mat 表示的m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
//        重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
//        如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
//
//        示例 1：
//        输入：mat = [[1,2],[3,4]], r = 1, c = 4
//        输出：[[1,2,3,4]]
//
//        示例 2：
//        输入：mat = [[1,2],[3,4]], r = 2, c = 4
//        输出：[[1,2],[3,4]]

public class matrixReshape {
//    执行用时：1 ms, 在所有 Java 提交中击败了34.69%的用户
//    内存消耗：38.9 MB, 在所有 Java 提交中击败了95.71%的用户
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] res = new int[r][c];
        int row = mat.length , column = mat[0].length;
        if (r*c != row*column){
            return mat;
        }
        int[] temp = new int[row*column];
        int num=0;
        for (int i=0;i<row;i++){
            for (int j=0;j<column;j++){
                temp[num]=mat[i][j];
                num++;
            }
        }
        num=0;
        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                res[i][j]=temp[num];
                num++;
            }
        }
        return res;
    }

//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：39.4 MB, 在所有 Java 提交中击败了33.45%的用户
    public static int[][] matrixReshape2(int[][] mat, int r, int c){
        int[][] res = new int[r][c];
        int row = mat.length,column = mat[0].length;
        int num = row*column;
        if (row*column!=r*c){
            return mat;
        }
        for (int i=0;i<num;i++){
            res[i/c][i%c] = mat[i/column][i%column];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] test1=new int[][]{{1, 2}, {3, 4}};
        System.out.println(matrixReshape(test1,2,4));
    }
}
