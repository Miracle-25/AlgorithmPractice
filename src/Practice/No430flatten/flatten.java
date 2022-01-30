package Practice.No430flatten;

//        多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
//        给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
//
//        示例 1：
//        输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
//        输出：[1,2,3,7,8,11,12,9,10,4,5,6]
//
//        示例 2：
//        输入：head = [1,2,null,3]
//        输出：[1,3,2]
//        解释：
//        输入的多级列表如下图所示：
//        1---2---NULL
//        |
//        3---NULL
//
//        示例 3：
//        输入：head = []
//        输出：[]

public class flatten {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：36.4 MB, 在所有 Java 提交中击败了64.59%的用户
    public Node flatten1(Node head) {
        tail(head);
        return head;
    }
    public Node tail(Node head){
        Node res = head;
        //记录链表的最后一个节点
        Node last = null;
        while (res!=null){
            Node next = res.next;
            //如果有子节点，先处理子节点
            if (res.child!=null){
                Node child = tail(res.child);
                next = res.next;
                //将node与child相连
                res.next = res.child;
                res.child.prev = res;
                //如果next不为空就将next与childlast相连
                if (next!=null){
                    child.next = next;
                    next.prev = child;
                }
                //将child置为空
                res.child = null;
                last = child;
            }else {
                last = res;
            }
            res = next;
        }
        return last;
    }
    public Node dfs(Node head){
        Node res = head;
        Node last = null;
        while (res !=null){
            Node next = res.next;
            if (res.child!=null){
                Node child = dfs(res.child);
                next = res.next;
                res.next = res.child;
                res.child.prev = res;
                if (next!=null){
                    child.next = next;
                    next.prev = child;
                }
                res.child = null;
                last = child;
            }else {
                last = res;
            }
            res = next;
        }
        return last;
    }


//    public Node flatten(Node head) {
//        dfs(head);
//        return head;
//    }
//    public Node dfs(Node node) {
//        Node cur = node;
//        // 记录链表的最后一个节点
//        Node last = null;
//        while (cur != null) {
//            Node next = cur.next;
//            //  如果有子节点，那么首先处理子节点
//            if (cur.child != null) {
//                Node childLast = dfs(cur.child);
//                next = cur.next;
//                //  将 node 与 child 相连
//                cur.next = cur.child;
//                cur.child.prev = cur;
//                //  如果 next 不为空，就将 last 与 next 相连
//                if (next != null) {
//                    childLast.next = next;
//                    next.prev = childLast;
//                }
//                // 将 child 置为空
//                cur.child = null;
//                last = childLast;
//            } else {
//                last = cur;
//            }
//            cur = next;
//        }
//        return last;
//    }


}

