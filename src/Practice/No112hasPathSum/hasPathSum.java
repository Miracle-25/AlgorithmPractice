package Practice.No112hasPathSum;

//        给你二叉树的根节点root 和一个表示目标和的整数targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
//        叶子节点 是指没有子节点的节点。
//        示例 1：
//        输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//        输出：true
//
//        示例 2：
//        输入：root = [1,2,3], targetSum = 5
//        输出：false
//
//        示例 3：
//        输入：root = [1,2], targetSum = 0
//        输出：false

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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

public class hasPathSum {
//    执行用时：2 ms, 在所有 Java 提交中击败了10.45%的用户
//    内存消耗：38.1 MB, 在所有 Java 提交中击败了86.40%的用户
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root==null){
            return false;
        }
        List res = new ArrayList();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i=0;i<len;i++){
                TreeNode node = queue.poll();
                if (node.left==null && node.right==null){
                    res.add(node.val);
                }
                if (node.left!=null){
                    node.left.val = node.val+node.left.val;
                    queue.add(node.left);
                }
                if (node.right!=null){
                    node.right.val = node.val+node.right.val;
                    queue.add(node.right);
                }
            }
        }
        return res.contains(targetSum);
    }

//    执行用时：29 ms, 在所有 Java 提交中击败了10.45%的用户
//    内存消耗：38.6 MB, 在所有 Java 提交中击败了5.00%的用户
    public boolean hasPathSum2(TreeNode root, int targetSum){
        try {
            if (root.left==null && root.right==null){
                return root.val==targetSum;
            }
        }catch (Exception e){
            return false;
        }
        int temp = targetSum-root.val;
        return hasPathSum2(root.left,temp) || hasPathSum2(root.right,temp);

    }
}
