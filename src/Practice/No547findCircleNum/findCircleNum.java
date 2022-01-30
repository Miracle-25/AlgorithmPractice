package Practice.No547findCircleNum;
//有n个城市，其中一些彼此相连，另一些没有相连。如果城市a与城市b直接相连，且城市b与城市c直接相连，那么城市a与城市c间接相连。
//省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
//给你一个nxn的矩阵isConnected其中isConnected[i][j]=1表示第i个城市和第j个城市直接相连而isConnected[i][j] = 0 表示二者不直接相连。
//返回矩阵中省份的数量。
//
//示例 1：
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
//
//示例 2：
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3

public class findCircleNum {
//    执行用时：1 ms, 在所有 Java 提交中击败了97.25%的用户
//    内存消耗：39.5 MB, 在所有 Java 提交中击败了29.08%的用户
    public static int findCircleNum1(int[][] isConnected) {
        int res = 0;
        boolean[] visit = new boolean[isConnected.length];
        for (int i=0;i<isConnected.length;i++){
            if (!visit[i]) {
                res++;
            for (int j=i+1;j< isConnected.length;j++){
                    if (isConnected[i][j] == 1 && !visit[j]) {
                        visit[j] = true;
                        isConnected[i] = arrayOr(isConnected[i], isConnected[j]);
                        j = i ;
                    }
                }
            }
        }
        return res;
    }
    public static int[] arrayOr(int[] a,int[] b){
        int nums = a.length;
        for (int i = 0;i<nums;i++){
            if(a[i]+b[i]>=1){
                b[i] = 1;
            }
        }
        return b;
    }


//    执行用时：1 ms, 在所有 Java 提交中击败了97.25%的用户
//    内存消耗：39.1 MB, 在所有 Java 提交中击败了84.18%的用户
    public static int findCircleNum2(int[][] isConnected){
        int res = 0;
        boolean[] visit = new boolean[isConnected.length];
        for(int i=0;i<isConnected.length;i++){
            if (!visit[i]){
                dfs(isConnected,i,visit);
                res++;
            }
        }
        return res;
    }
    public static void dfs(int[][] arr,int i,boolean[] visit){
        for(int j=0;j<arr.length;j++){
            if (arr[i][j]==1 && !visit[j]){
                visit[j]=true;
                dfs(arr,j,visit);
            }
        }
    }

//           [[1,1,0,0,0,0,0,1,0,0,0,0,0,0,0],
//            [1,1,0,0,0,0,0,0,0,0,0,0,0,0,0],
//            [0,0,1,0,0,0,0,0,0,0,0,0,0,0,0],
//            [0,0,0,1,0,1,1,0,0,0,0,0,0,0,0],
//            [0,0,0,0,1,0,0,0,0,1,1,0,0,0,0],
//            [0,0,0,1,0,1,0,0,0,0,1,0,0,0,0],
//            [0,0,0,1,0,0,1,0,1,0,0,0,0,1,0],
//            [1,0,0,0,0,0,0,1,1,0,0,0,0,0,0],
//            [0,0,0,0,0,0,1,1,1,0,0,0,0,1,0],
//            [0,0,0,0,1,0,0,0,0,1,0,1,0,0,1],
//            [0,0,0,0,1,1,0,0,0,0,1,1,0,0,0],
//            [0,0,0,0,0,0,0,0,0,1,1,1,0,0,0],
//            [0,0,0,0,0,0,0,0,0,0,0,0,1,0,0],
//            [0,0,0,0,0,0,1,0,1,0,0,0,0,1,0],
//            [0,0,0,0,0,0,0,0,0,1,0,0,0,0,1]]

//       [[1,0,0,1],
//        [0,1,1,0],
//        [0,1,1,1],
//        [1,0,1,1]]

    public static void main(String[] args) {
        int[][] test1 = new int[][] {{1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
                {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},
                {0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},
                {0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},
                {1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},
                {0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},
                {0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}};
        int[][] test2 = new int[][]{
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}
        };
        System.out.println(findCircleNum1(test1));
    }


}
