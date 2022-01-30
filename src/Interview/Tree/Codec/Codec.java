package Interview.Tree.Codec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return ser(root);
    }
    public String ser(TreeNode root){
        if (root==null){
            return "None,";
        }
        return root.val+","+ser(root.left)+ser(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(str));

        return des(list);
    }

    public TreeNode des(List<String> list){
        if (list.get(0).equals("None")){
            list.remove(list.get(0));
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(list.get(0));
        root.left = des(list);
        root.right = des(list);

        return root;

    }
}
