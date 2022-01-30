package DataStructureMID.No25reverseKGroup;

//        给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
//        k是一个正整数，它的值小于或等于链表的长度。
//        如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
//
//        进阶：
//        你可以设计一个只使用常数额外空间的算法来解决此问题吗？
//        你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
//
//        示例 1：
//        输入：head = [1,2,3,4,5], k = 2
//        输出：[2,1,4,3,5]
//
//        示例 2：
//        输入：head = [1,2,3,4,5], k = 3
//        输出：[3,2,1,4,5]
//
//        示例 3：
//        输入：head = [1,2,3,4,5], k = 1
//        输出：[1,2,3,4,5]
//
//        示例 4：
//        输入：head = [1], k = 1
//        输出：[1]


import java.util.Stack;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class reverseKGroup {
//    执行用时：2 ms, 在所有 Java 提交中击败了7.51%的用户
//    内存消耗：38.8 MB, 在所有 Java 提交中击败了23.20%的用户
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        ListNode temp = new ListNode(-1,head);
        ListNode res = temp;
        ListNode node = temp.next;

        while (true){
            Stack<ListNode> stack = new Stack<>();
            ListNode saveNode = node;
            int i=0;
            for (;i<k && node!=null;node=node.next,i++){
                    stack.push(node);
            }
            if (node==null ){
                if (i!=k){
                    temp.next=saveNode;
                }else {
                    temp.next = reverse(stack);
                }
                break;
            }else {
                temp.next = reverse(stack);
            }
            for (int j=0;j<k;j++){
                temp = temp.next;
            }
        }
        return res.next;
    }
    public ListNode reverse(Stack<ListNode> stack){
        ListNode temp = new ListNode(-1);
        ListNode res = temp;
        while (!stack.empty()){
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = null;
        return res.next;
    }
}
