package DataStructureMID.No108sortedArrayToBST;

//        给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
//        高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
//
//        示例 1：
//        输入：nums = [-10,-3,0,5,9]
//        输出：[0,-3,9,-10,null,5]
//        解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
//
//        示例 2：
//        输入：nums = [1,3]
//        输出：[3,1]
//        解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class sortedArrayToBST {
//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：38.3 MB, 在所有 Java 提交中击败了24.62%的用户
    public static TreeNode sortedArrayToBST(int[] nums) {
        int mid = nums.length/2;
        TreeNode res = new TreeNode(nums[mid],getNode(nums,0,mid-1),getNode(nums,mid+1,nums.length-1));
        return res;
    }
    public static TreeNode getNode(int[] nums,int begin,int end){
        if(begin>end){
            return null;
        }
        if (begin==end){
            return new TreeNode(nums[end]);
        }
        int mid = (end+begin)/2;
        if (mid==begin){
            return new TreeNode(nums[mid],null,getNode(nums,mid+1,end));
        }
        return new TreeNode(nums[mid],getNode(nums,begin,mid-1),getNode(nums,mid+1,end));
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,3};
        System.out.println(sortedArrayToBST(test));
    }
}
