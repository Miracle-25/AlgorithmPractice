package Interview.BeforeBeginning.searchMatrix;

public class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i=0;i< matrix.length;i++){
            if (matrix[i][0]>target){
                break;
            }
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]==target){
                    return true;
                }else if (matrix[i][j]>target){
                    break;
                }else {
                    continue;
                }
            }
        }
        return false;
    }
}
