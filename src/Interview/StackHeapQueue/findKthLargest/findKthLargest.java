package Interview.StackHeapQueue.findKthLargest;

import java.util.ArrayList;
import java.util.List;

public class findKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        for (int i=nums.length;i>0;i--){
            for (int j=0;j<i-1;j++){
                if (nums[j]<nums[j+1]){
                    int temp = nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        return nums[k-1];
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4,5};
        System.out.println(findKthLargest(test,3));
    }
}
