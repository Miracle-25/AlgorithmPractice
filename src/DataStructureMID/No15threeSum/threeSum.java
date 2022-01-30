package DataStructureMID.No15threeSum;

//        给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
//        注意：答案中不可以包含重复的三元组。
//
//        示例 1：
//        输入：nums = [-1,0,1,2,-1,-4]
//        输出：[[-1,-1,2],[-1,0,1]]
//
//        示例 2：
//        输入：nums = []
//        输出：[]
//
//        示例 3：
//        输入：nums = [0]
//        输出：[]


import java.util.*;

public class threeSum {
    static List<Integer> temp = new ArrayList();
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length<3){
        return res;
        }
        sort(nums);
        for (int i=0;i<nums.length-2;i++){
                temp.add(nums[i]);
                compute(nums,0-nums[i],i);
        }
        if (res.size()==1){
            return res;
        }
        for (int i=0;i<res.size()-1;i++){
            for (int j=i+1;j<res.size();){
            if (res.get(i).equals(res.get(j))){
                res.remove(j);
            }else {
                j++;
            }
            }
        }

        return res;
    }
    public static void compute(int[] nums,int target,int i){
        if (temp.size()==3){
            if (target==0){
            List<Integer> save = new ArrayList<>(temp);
            res.add(save);
            }
            temp.remove(temp.size()-1);
            return;
        }
        for (int j=i+1;j<nums.length;j++){
            temp.add(nums[j]);
            compute(nums,target-nums[j],j);
        }
        temp.remove(temp.size()-1);
    }
    public static void sort(int[] sort){
        int len = sort.length;
        for (int i=0;i<len-1;len--){
            for (int j=i;j<len-1;j++){
                if (sort[j]>sort[j+1]){
                    int temp = sort[j];
                    sort[j]=sort[j+1];
                    sort[j+1]=temp;
                }
            }
        }
    }

//    执行用时：21 ms, 在所有 Java 提交中击败了66.87%的用户
//    内存消耗：42.1 MB, 在所有 Java 提交中击败了83.35%的用户
    public List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
//        int[] test = new int[]{-1,0,1,2,-1,-4};
        int[] test2 = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
//        System.out.println(threeSum(test));
        System.out.println(threeSum(test2));

    }
}
