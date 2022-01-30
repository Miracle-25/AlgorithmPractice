package Practice.No437pathSum;

//        给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
//        路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
//
//        示例 1：
//        输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//        输出：3
//        解释：和等于 8 的路径有 3 条，如图所示。
//
//        示例 2：
//        输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//        输出：3

public class pathSum {
    public class TreeNode {
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

//    执行用时：27 ms, 在所有 Java 提交中击败了20.06%的用户
//    内存消耗：38.1 MB, 在所有 Java 提交中击败了82.81%的用户
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        int res = 0;
        res = rootSum(root,targetSum);
        res = res+pathSum(root.left,targetSum);
        res = res+pathSum(root.right,targetSum);

        return res;
    }

    public int rootSum(TreeNode root,int targetSum){
        int res = 0;
        if (root == null){
            return 0;
        }
        if (root.val == targetSum){
            res++;
        }
        res = res+rootSum(root.left,targetSum-root.val);
        res = res+rootSum(root.right,targetSum-root.val);
        return res;
    }
}
