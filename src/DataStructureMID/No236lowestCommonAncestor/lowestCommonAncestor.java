package DataStructureMID.No236lowestCommonAncestor;

//        给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//        百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
//        示例 1：
//        输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//        输出：3
//        解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
//
//        示例 2：
//        输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//        输出：5
//        解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
//
//        示例 3：
//        输入：root = [1,2], p = 1, q = 2
//        输出：1

import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class lowestCommonAncestor {
//    执行用时：1289 ms, 在所有 Java 提交中击败了5.05%的用户
//    内存消耗：40.5 MB, 在所有 Java 提交中击败了67.84%的用户
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==p || root==q){
            return root;
        }else {
            if ((hasTreeNode(root.left,p) && hasTreeNode(root.right,q))
                    ||(hasTreeNode(root.left,q) && hasTreeNode(root.right,p))){
                return root;
            }else if (hasTreeNode(root.left,p)){
                return lowestCommonAncestor(root.left,p,q);
            }else {
                return lowestCommonAncestor(root.right,p,q);
            }
        }
    }

    public boolean hasTreeNode(TreeNode root, TreeNode node){
        if (root == node){
            return true;
        }
        if (root==null){
            return false;
        }
        return hasTreeNode(root.right,node) || hasTreeNode(root.left,node);
    }
}
