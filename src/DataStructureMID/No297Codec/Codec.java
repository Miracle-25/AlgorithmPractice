package DataStructureMID.No297Codec;

//        序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
//        请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
//        提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
//
//        示例 1：
//        输入：root = [1,2,3,null,null,4,5]
//        输出：[1,2,3,null,null,4,5]
//
//        示例 2：
//        输入：root = []
//        输出：[]
//
//        示例 3：
//        输入：root = [1]
//        输出：[1]
//
//        示例 4：
//        输入：root = [1,2]
//        输出：[1,2]

import java.util.ArrayDeque;
import java.util.Queue;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Codec {

//    执行用时：101 ms, 在所有 Java 提交中击败了16.95%的用户
//    内存消耗：41.4 MB, 在所有 Java 提交中击败了11.63%的用户
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res = "";
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i=0;i<len;i++){
                TreeNode node = queue.peek();
                res = res+node.val+",";
                System.out.println(res);
                queue.poll();
                if (node.left!=null){
                    queue.add(node.left);
                }else {
                    res = res+"None,";
                }
                if (node.right!=null){
                    queue.add(node.right);
                }else {
                    res = res+"None,";
                }
            }
        }
        return res.substring(0,res.length());
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data=="None"){
            return null;
        }
        String[] temp = data.split(",");
        TreeNode res = new TreeNode(data.charAt(0)-48);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(res);
        int strlen = 1;
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i=0;i<len;i++){
                TreeNode node = queue.peek();
                queue.poll();
                try {
                    if (temp[strlen]!="None"){
                    node.left = new TreeNode(change(temp[strlen])-48);
                    }else {
                        node.left = null;
                    }
                    strlen++;
                    if (temp[strlen]!="None"){
                    node.right = new TreeNode(change(temp[strlen])-48);
                    }else {
                        node.right = null;
                    }
                    strlen++;
                }catch (Exception e){
                    return res;
                }
            }
        }
        return res;
    }

    public Character change(String s){
        return s.charAt(0);
    }
}
