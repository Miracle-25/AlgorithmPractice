package DataStructureMID.No105buildTree;

//        给定一棵树的前序遍历preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。
//
//        示例 1:
//        Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//        Output: [3,9,20,null,null,15,7]
//
//        示例 2:
//        Input: preorder = [-1], inorder = [-1]
//        Output: [-1]

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

public class buildTree {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==1){
            return new TreeNode(preorder[0]);
        }
        return getNode(preorder,0,preorder.length-1,inorder);
    }
    public static TreeNode getNode(int[] preorder,int begin,int end, int[] inorder){
        if (begin==end){
            return new TreeNode(preorder[begin]);
        }
        TreeNode node = new TreeNode(preorder[begin]);
        for (int i=begin+1;i<end+1;i++){
            if (search(inorder,preorder[i])>search(inorder,preorder[begin])){
                node.right = i==end ? new TreeNode(preorder[i]):getNode(preorder,i,end,inorder);
                end = i-1;
                if (end==begin){
                    return node;
                }
                break;
            }
        }
        node.left = begin+1==end?new TreeNode(preorder[begin+1]):getNode(preorder,begin+1,end,inorder);
        return node;
    }
    public static int search(int[] nums,int num){
        for (int i=0;i<nums.length;i++){
            if (nums[i]==num){
                return i;
            }
        }
        return 0;
    }



    public static void main(String[] args) {
        int[] test1 = new int[]{1,2,3};
        int[] test2 = new int[]{2,3,1};
        System.out.println(buildTree(test1,test2));
    }
}
