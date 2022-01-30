package Practice.No102levelOrder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//        给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//        示例：
//        二叉树：[3,9,20,null,null,15,7],
//
//            3
//           / \
//          9  20
//            /  \
//            15  7
//        返回其层序遍历结果：
//
//        [
//        [3],
//        [9,20],
//        [15,7]
//        ]

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
public class levelOrder {

//    执行用时：1 ms, 在所有 Java 提交中击败了91.13%的用户
//    内存消耗：38.7 MB, 在所有 Java 提交中击败了39.38%的用户
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root==null){return res;}
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int len = queue.size();
            for (int i=0;i<len;i++){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left!=null){
                queue.offer(node.left);
                }
                if (node.right!=null){
                queue.offer(node.right);
                }
            }
            res.add(temp);
        }

        return res;
    }
//    List<List<Integer>> res = new ArrayList<>();
//    List<List<TreeNode>> resNode = new ArrayList<>();
//
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        levelOrderNode(root);
//
//        for (List<TreeNode> treeNode:resNode){
//            List<Integer> temp = new ArrayList<>();
//            for (TreeNode node:treeNode){
//                temp.add(node.val);
//            }
//            res.add(temp);
//        }
//        return res;
//    }
//    public void levelOrderNode(TreeNode root){
//        List<TreeNode> tempRecord = new ArrayList<>();
//        tempRecord.add(root);
//        resNode.add(tempRecord);
//        for (List<TreeNode> temp:resNode){
//            record(temp);
//        }
//    }
//    public void record(List<TreeNode> temp){
//        List<TreeNode> tempRecord = new ArrayList<>();
//        for (TreeNode node:temp){
//            tempRecord.add(node.left);
//            tempRecord.add(node.right);
//        }
//        resNode.add(tempRecord);
//    }

//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> ret = new ArrayList<List<Integer>>();
//        if (root == null) {
//            return ret;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            List<Integer> level = new ArrayList<Integer>();
//            int currentLevelSize = queue.size();
//            for (int i = 1; i <= currentLevelSize; ++i) {
//                TreeNode node = queue.poll();
//                level.add(node.val);
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//            }
//            ret.add(level);
//        }
//
//        return ret;
//    }

}
