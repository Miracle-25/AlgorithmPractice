package Practice.No116connect;

//        给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
//        struct Node {
//        int val;
//        Node *left;
//        Node *right;
//        Node *next;
//        }
//        填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
//        初始状态下，所有next 指针都被设置为 NULL。
//
//        进阶：
//        你只能使用常量级额外空间。
//        使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
//
//        示例：
//        输入：root = [1,2,3,4,5,6,7]
//        输出：[1,#,2,3,#,4,5,6,7,#]
//        解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
//
//        提示：
//        树中节点的数量少于4096
//        -1000 <= node.val <= 1000


import java.util.ArrayDeque;
import java.util.Queue;

class Node {
public int val;
public Node left;
public Node right;
public Node next;

public Node() {}

public Node(int _val) {
        val = _val;
        }

public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
        }
        };

public class connect {
//    执行用时：3 ms, 在所有 Java 提交中击败了35.95%的用户
//    内存消耗：38.6 MB, 在所有 Java 提交中击败了59.39%的用户
    public Node connect(Node root) {
        if (root==null){
            return root;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = null;
            int len = queue.size();
            for (int i=0;i< len;i++){
                node = queue.poll();
                if (i<len-1){
                    node.next = queue.peek();
                }
                if (node.left!=null){
                queue.add(node.left);
                }
                if (node.right!=null){
                queue.add(node.right);
                }
            }
            node.next=null;
        }
        return root;

    }
}
