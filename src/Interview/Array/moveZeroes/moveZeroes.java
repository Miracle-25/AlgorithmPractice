package Interview.Array.moveZeroes;

public class moveZeroes {
    public static void moveZeroes(int[] nums) {
        int target = 0;
        for (int i=nums.length;i>0;i--){
            for (int j=target;j<i-1;j++){
                if (nums[j]==0){
                    nums[j]=nums[j+1];
                    nums[j+1]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{0,1,0,3,12};
        moveZeroes(test);
    }
}
