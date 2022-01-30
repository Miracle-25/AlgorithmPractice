package Interview2.No112hasPathSum;

class TreeNode{
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
    public boolean hasPathSum(TreeNode root, int targetSum){
        if (root.left==null && root.right==null){
            return targetSum==root.val;
        }else if (root.left==null){
            return hasPathSum(root.right,targetSum- root.val);
        }else if (root.right==null){
            return hasPathSum(root.left,targetSum- root.val);
        }else {
            return hasPathSum(root.left,targetSum- root.val) ||
                    hasPathSum(root.right,targetSum- root.val);
        }
    }
}
