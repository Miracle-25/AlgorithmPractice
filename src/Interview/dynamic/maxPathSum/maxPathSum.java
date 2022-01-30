package Interview.dynamic.maxPathSum;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val){this.val = val;}
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.right = right;
        this.left = left;
    }
}

public class maxPathSum {
    public static int maxPathSum(TreeNode root) {
        return Math.max(comutePathandRoot(root),Math.max(comutePathandRoot(root.right),comutePathandRoot(root.left)));
    }
    public static int comutePathandRoot(TreeNode root){
        int temp = 0;
        if (root==null){
            return Integer.MIN_VALUE;
        }
        if (root.left==null && root.right==null){
            return root.val;
        }else if (root.left==null){
            return Math.max(Math.max(comupteMaxPath(root.right)+root.val, root.val),comutePathandRoot(root.right));
        }else if (root.right==null){
            return Math.max(Math.max(comupteMaxPath(root.left)+root.val, root.val),comutePathandRoot(root.left));
        } else {
        temp = Math.max(
                Math.max(comupteMaxPath(root.right)+root.val,comupteMaxPath(root.left)+root.val),
                    Math.max(comupteMaxPath(root.right)+comupteMaxPath(root.left)+root.val,
                root.val));
        }
        System.out.println(temp);
        return Math.max(Math.max(comutePathandRoot(root.left),comutePathandRoot(root.right)),temp);
    }
    public static int comupteMaxPath(TreeNode root){
        if (root==null){
            return Integer.MIN_VALUE;
        }
        if (root.left==null && root.right==null){
            return root.val;
        }else if (root.left==null){
            return Math.max(comupteMaxPath(root.right)+root.val, root.val);
        }else if (root.right==null){
            return Math.max(comupteMaxPath(root.left)+root.val, root.val);
        }else {
            return Math.max(
                    Math.max(comupteMaxPath(root.right)+root.val,comupteMaxPath(root.left)+root.val),
//                    Math.max(comupteMaxPath(root.right)+comupteMaxPath(root.left)+root.val,
                            root.val
//            )
            );
        }
    }
//    [5,4,8,11,null,13,4,7,2,null,null,null,1]
public static void main(String[] args) {
        TreeNode root = new TreeNode(8,new TreeNode(13),new TreeNode(4,null,new TreeNode(1)));
    System.out.println(comutePathandRoot(root));
}
}
