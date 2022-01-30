package Interview.Tree.kthSmallest;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){this.val = val;}
    TreeNode(int val, TreeNode left,TreeNode right){this.val=val;this.left=left;this.right=right;}
}

public class kthSmallest {
    public static int kthSmallest(TreeNode root, int k) {
        int leftNode = computeNode(root.left);
        if (leftNode == k-1){
            return root.val;
        }else if (leftNode > k-1){
            return kthSmallest(root.left,k);
        }else {
            return kthSmallest(root.right,k-leftNode-1);
        }
    }
    public static int computeNode(TreeNode root){
        if (root==null){
            return 0;
        }
        return 1+computeNode(root.left)+computeNode(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,null,new TreeNode(2));
        System.out.println(kthSmallest(treeNode,2));
    }
}
