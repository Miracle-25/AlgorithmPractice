package Practice.No617mergeTrees;

//        给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
//        你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为NULL 的节点将直接作为新二叉树的节点。
//
//        示例1:
//        输入:
//        Tree 1                     Tree 2
//            1                         2
//           / \                       / \
//          3   2                     1   3
//         /                           \   \
//        5                             4   7
//        输出:
//        合并后的树:
//             3
//            / \
//           4   5
//          / \   \
//         5   4   7
//        注意:合并必须从两个树的根节点开始。

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

public class mergeTrees {
//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：38.5 MB, 在所有 Java 提交中击败了70.00%的用户
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1==null && root2==null){
            return null;
        }else if (root1==null && root2!=null){
            return root2;
        }else if (root1!=null && root2==null){
            return root1;
        }
        TreeNode res = new TreeNode(root1.val+root2.val);
        res.left = mergeTrees(root1.left,root2.left);
        res.right = mergeTrees(root1.right,root2.right);

        return res;
    }
}
