package DataStructureMID.No240searchMatrix;

//        编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
//        每行的元素从左到右升序排列。
//        每列的元素从上到下升序排列。
//
//        示例 1：
//        输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
//        输出：true
//
//        示例 2：
//        输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
//        输出：false

public class searchMatrix {
    public static boolean searchMatrix1(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int i=0,j=0;
        boolean sort = false;
        while (i<r){
//            if (matrix[i][j]<target) {
                sort = !sort;
//            }
                while (sort && j < c) {
                    if (matrix[i][j] == target) {
                        return true;
                    } else if (matrix[i][j] < target) {
                        j++;
                    } else {
                        break;
                    }
                }
                i++;
            if (!(i<r)){
                break;
            }
//            if (matrix[i][j]>target){
                sort=!sort;
//            }
            if (j>0) {
                j--;

                while (!sort && j >= 0) {
                    if (matrix[i][j] == target) {
                        return true;
                    } else if (matrix[i][j] > target) {
                        if (j<=0){
                            return false;
                        }else {
                            j--;
                        }
                    } else {
                        break;
                    }
                }
            }
            i++;
        }
        return false;
    }

//    执行用时：13 ms, 在所有 Java 提交中击败了11.64%的用户
//    内存消耗：44 MB, 在所有 Java 提交中击败了22.93%的用户
    public static boolean searchMatrix2(int[][] matrix, int target){
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                if (matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }


//    执行用时：5 ms, 在所有 Java 提交中击败了98.19%的用户
//    内存消耗：44 MB, 在所有 Java 提交中击败了19.77%的用户
    public static boolean searchMatrix3(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int i=0,j=0;
        boolean sort = false;
        while (i<r){
            if (matrix[i][j]==target){
                return true;
            }
            if (matrix[i][j]<target) {
                while (j < c) {
                    if (matrix[i][j] == target) {
                        return true;
                    } else if (matrix[i][j] < target) {
                        if (j==c-1){
                           break;
                        }else {
                            j++;
                        }
                    } else {
                        break;
                    }
                }
                i++;
            }
//            i++;
            if (!(i<r)){
                break;
            }
            if (matrix[i][j]==target){
                return true;
            }
            if (matrix[i][j]>target){
                if (j>0){
                    j--;
                }

                    while (j >= 0) {
                        if (matrix[i][j] == target) {
                            return true;
                        } else if (matrix[i][j] > target) {
                            if (j<=0){
                                return false;
                            }else {
                                j--;
                            }
                        } else {
                            break;
                        }
                    }
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        [[1,3,5,7,9],[2,4,6,8,10],[11,13,15,17,19],[12,14,16,18,20],[21,22,23,24,25]]
        int[][] test1 = new int[][]{{1,3,5,7,9}, {2,4,6,8,10}, {11,13,15,17,19}, {12,14,16,18,20}, {21,22,23,24,25}};
        int[][] test2 = new int[][]{{1},{3},{5}};
        System.out.println(searchMatrix3(test1,13));
        System.out.println(searchMatrix3(test1,5));
        System.out.println(searchMatrix3(test1,17));
        System.out.println(searchMatrix3(test1,20));

        System.out.println(searchMatrix3(test2,2));

        int[][] test3 = new int[][]{
                { 3, 6, 9, 12, 17, 22 },
            { 5, 11, 11, 16, 22, 26 },
            { 10, 11, 14, 16, 24, 31 },
            { 10, 15, 17, 17, 29, 31 },
            { 14, 17, 20, 23, 34, 37 },
            { 19, 21, 22, 28, 37, 40 },
            { 22, 22, 24, 32, 37, 43 } };
        System.out.println(searchMatrix3(test3,20));
    }
}
