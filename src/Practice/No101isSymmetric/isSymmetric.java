package Practice.No101isSymmetric;

//        给定一个二叉树，检查它是否是镜像对称的。
//        例如，二叉树[1,2,2,3,4,4,3] 是对称的。
//            1
//           / \
//          2   2
//         / \ / \
//        3  4 4  3
//        但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
//          1
//         / \
//        2   2
//         \   \
//         3    3

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
public class isSymmetric {
//    执行用时：8 ms, 在所有 Java 提交中击败了21.17%的用户
//    内存消耗：38.3 MB, 在所有 Java 提交中击败了5.17%的用户
    TreeNode error = new TreeNode(-1);
    public boolean isSymmetric(TreeNode root) {
        List<List<Integer>> left = leftTree(root.left);
        List<List<Integer>> right = rightTree(root.right);
        System.out.println(left);
        System.out.println(right);
        return left.equals(right);
    }
    public List<List<Integer>> leftTree(TreeNode root){
        List<List<Integer>> left = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root==null){return left;}
        queue.add(root);
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
            left.add(temp);
        }
        return left;
    }
    public List<List<Integer>> rightTree(TreeNode root){
        List<List<Integer>> right = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root==null){return right;}
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int len = queue.size();
            for (int i=0;i<len;i++){
                TreeNode node = queue.poll();
                if(node.equals(error)){
                    temp.add(-1);
                    continue;
                }
                temp.add(node.val);
                if (node.right!=null){
                    queue.offer(node.right);
                }else{
                    queue.offer(error);
                }
                if (node.left!=null){
                    queue.offer(node.left);
                }else{
                    queue.offer(error);
                }
            }
            right.add(temp);
        }
        return right;
    }
}
