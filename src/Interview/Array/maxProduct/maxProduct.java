package Interview.Array.maxProduct;

import java.util.ArrayList;
import java.util.List;

public class maxProduct {
    public static int maxProduct(int[] nums) {
        return computeMax(nums,nums.length-1);
    }

    public static int computeMax(int[] nums,int end){
        if (end==0){
            return nums[end];
        }

        boolean isNegative = false;
        for (int i=0;i<end;i++){
            if (nums[i]<0){
                isNegative=!isNegative;
            }
        }

        if (nums[end]>0){
            if (nums[end-1]>0 || !isNegative){
                return computeMax(nums,end-1)==0?nums[end]:computeMax(nums,end-1)*nums[end];
            }else {
                return Math.max(nums[end],computeMax(nums,end-1));
            }
        }else if (nums[end]<0){
            if (isNegative){
                return Math.max(Product(nums,end),computeMax(nums,end-1));
            }else {
                return computeMax(nums,end-1);
            }
        }else{
            return computeMax(nums,end-1)>0 ? computeMax(nums,end-1):0;
        }
    }

    public static int Product(int[] nums,int end){
        int res = 1;
        for (int i=0;i<=end;i++){
            res = res*nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[]{2,-5,-2,-4,3};
        System.out.println(maxProduct(test));
    }
}
