package BEIKEinterview.No4findMedianSortedArrays;

//        给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
//        算法的时间复杂度应该为 O(log (m+n)) 。
//
//        示例 1：
//        输入：nums1 = [1,3], nums2 = [2]
//        输出：2.00000
//        解释：合并数组 = [1,2,3] ，中位数 2
//
//        示例 2：
//        输入：nums1 = [1,2], nums2 = [3,4]
//        输出：2.50000
//        解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//
//        示例 3：
//        输入：nums1 = [0,0], nums2 = [0,0]
//        输出：0.00000
//
//        示例 4：
//        输入：nums1 = [], nums2 = [1]
//        输出：1.00000
//
//        示例 5：
//        输入：nums1 = [2], nums2 = []
//        输出：2.00000


public class findMedianSortedArrays {
    public static void main(String[] args) {
        int[] test1 = new int[]{2,2,2,2};
        int[] test2 = new int[]{2,2,2};
        System.out.println(findMedianSortedArrays(test1,test2));
    }

//    执行用时：19 ms, 在所有 Java 提交中击败了5.35%的用户
//    内存消耗：39.6 MB, 在所有 Java 提交中击败了70.19%的用户
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1==null || nums1.length==0){
            return findMedian(nums2);
        }
        if (nums2==null || nums2.length==0){
            return findMedian(nums1);
        }
        if (nums1.length==1 && nums2.length==1){
            return new Double(nums1[0]+nums2[0])/2;
        }

        if (nums1[0]>=nums2[0]){
            nums2 = changeArray(nums2,0);
        }else {
            nums1 = changeArray(nums1,0);
        }
        if (nums2==null || nums1==null){
            if (nums2==null){
                nums1 = changeArray(nums1, nums1.length-1);
            }else {
                nums2 = changeArray(nums2, nums2.length-1);
            }
        }else {
        if (nums1[nums1.length-1]>=nums2[nums2.length-1]){
            nums1 = changeArray(nums1, nums1.length-1);
        }else {
            nums2 = changeArray(nums2, nums2.length-1);
        }
        }
        return findMedianSortedArrays(nums1,nums2);
    }
    public static Double findMedian(int[] nums){
        int left = 0,right = nums.length-1;
        while(left<right){
            left++;
            right--;
        }
        return left==right?nums[left]:new Double((nums[right]+nums[left]))/2;
    }
    public static int[] changeArray(int[] nums,int n){
        if (nums.length==1){
            return null;
        }
        int[] res = new int[nums.length-1];
        int j=0;
        for (int i=0;i< nums.length;i++){
            if (i==n){
                continue;
            }else {
                res[j]= nums[i];
                j++;
            }
        }
        return res;
    }
}
