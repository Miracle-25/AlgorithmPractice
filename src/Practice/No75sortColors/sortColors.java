package Practice.No75sortColors;

//        给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//        此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
//
//        示例 1：
//        输入：nums = [2,0,2,1,1,0]
//        输出：[0,0,1,1,2,2]
//
//        示例 2：
//        输入：nums = [2,0,1]
//        输出：[0,1,2]
//
//        示例 3：
//        输入：nums = [0]
//        输出：[0]
//
//        示例 4：
//        输入：nums = [1]
//        输出：[1]

public class sortColors {
//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：37 MB, 在所有 Java 提交中击败了33.82%的用户
    public static void sortColors(int[] nums) {
        if (nums.length==1 || nums.length==0){
            return;
        }
        int r=0,l=0;
        for (int i=0;i<nums.length && r<nums.length;){
//            if (nums[i]==0 && i==0){
//                r++;
//                l++;
//                i++;
//            } else
                if (nums[i]==0){
                int temp = nums[l];
                if (nums[l]!=0){
                    nums[l]=nums[i];
                    nums[i]=temp;
                }else {
                    i++;
                }

                if (temp!=1){
                    r++;
                }
                l++;
            }else if (nums[i]==1){
                int temp = nums[r];
                nums[r]=nums[i];
                nums[i]=temp;
                r++;
                i++;
            }else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{0,0,2};
        sortColors(test);
        System.out.println(test);
    }
}
