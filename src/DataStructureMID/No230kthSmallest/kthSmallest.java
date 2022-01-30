package DataStructureMID.No230kthSmallest;

//        给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第k个最小元素（从 1 开始计数）。
//
//        示例 1：
//        输入：root = [3,1,4,null,2], k = 1
//        输出：1
//
//        示例 2：
//        输入：root = [5,3,6,2,4,null,null,1], k = 3
//        输出：3


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

public class kthSmallest {
//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：38.1 MB, 在所有 Java 提交中击败了80.72%的用户
    public int kthSmallest(TreeNode root, int k) {
        if (countNode(root.left)==k-1){
            return root.val;
        }else if (countNode(root.left)>k-1){
            return kthSmallest(root.left,k);
        }else {
            return kthSmallest(root.right,k-countNode(root.left)-1);
        }
    }

    public int countNode(TreeNode root){
        if (root==null){
            return 0;
        }
        return 1+countNode(root.left)+countNode(root.right);
    }
}
