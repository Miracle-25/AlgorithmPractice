package Practice.No542updateMatrix;

//        给定一个由 0 和 1 组成的矩阵 mat，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
//        两个相邻元素间的距离为 1 。
//
//        示例 1：
//        输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
//        输出：[[0,0,0],[0,1,0],[0,0,0]]
//
//        示例 2：
//        输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
//        输出：[[0,0,0],[0,1,0],[1,2,1]]
//
//        提示：
//        m == mat.length
//        n == mat[i].length
//        1 <= m, n <= 104
//        1 <= m * n <= 104
//        mat[i][j] is either 0 or 1.
//        mat 中至少有一个 0

public class updateMatrix {
    public static int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] res = new int[m][n];

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                boolean[][] judge = new boolean[m][n];
                res[i][j] = compute(mat,0,2,judge);
            }
        }
        return res;
    }
    public static int compute(int[][] mat,int i,int j,boolean[][] judge){
        if (i<mat.length && i>=0 && j>=0 && j<mat[i].length){
            if (mat[i][j]==0){
                return 0;
            }else {
                if (!judge[i][j]){
                    judge[i][j]=true;
                    int res=0;
                    int up = 1+compute(mat,i-1,j,judge);
                    int down = 1+compute(mat,i+1,j,judge);
                    int left = 1+compute(mat,i,j-1,judge);
                    int right = 1+compute(mat,i,j+1,judge);
                    judge[i][j]=false;
                    return min(up,down,left,right);
                }else {
                    return 10;
                }
            }
        }else {
            return 20;
        }
    }
    public static int min(int a,int b,int c,int d){
        return Math.min(Math.min(a,b),Math.min(c,d));
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{0,1,1},{1,1,1},{0,1,1},{0,0,0}};
        System.out.println(updateMatrix(test));
    }

}
