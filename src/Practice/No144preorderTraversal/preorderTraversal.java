package Practice.No144preorderTraversal;

import java.util.ArrayList;
import java.util.List;

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

public class preorderTraversal {
//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：36.6 MB, 在所有 Java 提交中击败了57.05%的用户
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return res;
    }
    public void preorder(TreeNode root){
        if (root == null){
            return ;
        }
        res.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }

}
