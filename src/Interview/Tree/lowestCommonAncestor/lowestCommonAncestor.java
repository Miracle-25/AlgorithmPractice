package Interview.Tree.lowestCommonAncestor;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val=x;}
}

public class lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==p || root==q){
            return root;
        }else if (isContains(root.right,q) && isContains(root.left,p)){
            return root;
        }else if (isContains(root.left,q) && isContains(root.right,p)){
            return root;
        }else if (isContains(root.left,q) && isContains(root.left,p)){
            return lowestCommonAncestor(root.left,p,q);
        }else {
            return lowestCommonAncestor(root.right,p,q);
        }
    }
    public Boolean isContains(TreeNode root, TreeNode node){
        if (root==null){
            return false;
        }
        if (root==node){
            return true;
        }
        return isContains(root.left,node) || isContains(root.right,node);
    }
}
