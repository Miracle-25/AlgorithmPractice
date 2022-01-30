package Interview2.No230kthSmallest;

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

public class kthSmallest {
    public static int kthSmallest(TreeNode root, int k){
        int temp;
        try {
            temp = countNode(root.left);
        }catch (Exception e){
            temp = 0;
        }
        if (temp==k-1){
            return root.val;
        }else if (temp>k-1){
            return kthSmallest(root.left,k);
        }else {
            return kthSmallest(root.right,k-temp-1);
        }
    }
    public static int countNode(TreeNode root){
        try{
        if (root.right==null && root.left==null){
            return 1;
        }else if (root.right==null){
            return countNode(root.left)+1;
        }else if (root.left==null){
            return countNode(root.right)+1;
        }else {
            return 1+countNode(root.left)+countNode(root.right);
        }
        }catch (Exception e){
            return 0;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,null,new TreeNode(2));
        System.out.println(kthSmallest(root,2));
    }
}
