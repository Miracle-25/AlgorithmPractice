package Practice.No104;

//        给定一个二叉树，找出其最大深度。
//        二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//        说明:叶子节点是指没有子节点的节点。
//
//        示例：
//        给定二叉树 [3,9,20,null,null,15,7]，
//
//         3
//        / \
//        9  20
//          /  \
//         15   7
//        返回它的最大深度3 。

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
public class maxDepth {
//    执行用时：2 ms, 在所有 Java 提交中击败了19.70%的用户
//    内存消耗：38.4 MB, 在所有 Java 提交中击败了32.07%的用户
//    List<Integer> temp = new ArrayList<>();
    public int maxDepth1(TreeNode root) {
        List<List<TreeNode>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque();
        if (root==null){ return 0;}
        queue.offer(root);
        while (!queue.isEmpty()){
            List<TreeNode> temp = new ArrayList<>();
            int len = queue.size();
            for (int i=0;i<len;i++){
                TreeNode node = queue.poll();
                temp.add(node);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(temp);
        }
        return res.size();
    }
//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：38.5 MB, 在所有 Java 提交中击败了15.80%的用户
    public int maxDepth2(TreeNode root){
        if (root==null){return 0;}
        int leftheight = maxDepth2(root.left);
        int rightheight = maxDepth2(root.right);
        return Math.max(leftheight,rightheight)+1;
    }
}
