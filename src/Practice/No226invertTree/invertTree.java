package Practice.No226invertTree;

//        翻转一棵二叉树。
//        示例：
//        输入：
//
//             4
//           /   \
//          2     7
//         / \   / \
//        1   3 6   9
//        输出：
//             4
//           /   \
//          7     2
//         / \   / \
//        9   6 3   1


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
public class invertTree {
//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：35.7 MB, 在所有 Java 提交中击败了85.00%的用户
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }else {
            TreeNode temp ;
            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        return root;
    }

}
