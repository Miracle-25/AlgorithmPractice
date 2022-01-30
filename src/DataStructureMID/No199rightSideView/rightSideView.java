package DataStructureMID.No199rightSideView;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//        给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
//        示例 1:
//        输入:[1,2,3,null,5,null,4]
//        输出:[1,3,4]
//
//        示例 2:
//        输入:[1,null,3]
//        输出:[1,3]
//
//        示例 3:
//        输入:[]
//        输出:[]

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

public class rightSideView {
//    执行用时：1 ms, 在所有 Java 提交中击败了83.15%的用户
//    内存消耗：37.2 MB, 在所有 Java 提交中击败了16.27%的用户
    public List<Integer> rightSideView(TreeNode root) {
        if (root==null){
            return null;
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            int temp = 0;
            for (int i=0;i<len;i++){
                if (queue.peek()!=null){
                    temp = queue.peek().val;
                    TreeNode tempNode = queue.poll();
                    if (tempNode.left!=null){
                    queue.add(tempNode.left);
                    }
                    if (tempNode.right!=null){
                    queue.add(tempNode.right);
                    }
                }
            }
            res.add(temp);
        }
        return res;
    }
}
