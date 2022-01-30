package Practice.No283moveZeroes;

//        给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//        示例:
//        输入: [0,1,0,3,12]
//        输出: [1,3,12,0,0]
//        说明:
//
//        必须在原数组上操作，不能拷贝额外的数组。
//        尽量减少操作次数。

public class moveZeroes {
//    执行用时：74 ms, 在所有 Java 提交中击败了5.04%的用户
//    内存消耗：39.8 MB, 在所有 Java 提交中击败了8.16%的用户
    public static void moveZeroes1(int[] nums) {
        int zero = nums.length-1;
        for (int i=nums.length-1;i>=0;i--){
            if (nums[i]==0){
                for (int j=i;j<zero;j++){
                    int temp = nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
                zero--;
            }
        }
    }

//    执行用时：41 ms, 在所有 Java 提交中击败了5.04%的用户
//    内存消耗：39.7 MB, 在所有 Java 提交中击败了12.99%的用户
    public static void moveZeroes2(int[] nums) {
        int zero = nums.length-1;
        for (int i=nums.length-1;i>=0;i--){
            if (nums[i]==0){
                for (int j=i;j<zero;j++){
                    nums[j]=nums[j+1];
                }
                nums[zero]=0;
                zero--;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,0,0};
        moveZeroes2(test);
        for (int i:test){
            System.out.println(i);
        }
    }
}
