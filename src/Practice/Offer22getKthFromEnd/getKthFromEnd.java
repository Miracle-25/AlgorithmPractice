package Practice.Offer22getKthFromEnd;

//        输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
//        例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
//
//        示例：
//        给定一个链表: 1->2->3->4->5, 和 k = 2.
//        返回链表 4->5.

import java.util.Stack;

public class getKthFromEnd {
    public ListNode getKthFromEnd1(ListNode head, int k) {
        Stack<Integer> all = new Stack<>();
        while (head.next!=null){
            all.push(head.val);
        }
        Stack<Integer> temp = new Stack<>();
        for (int i=0;i<k;i++){
            int tempNode = all.pop();
            temp.push(tempNode);
        }
        ListNode res=null;
        for (int i=0;i<k;i++){
            res.next = new ListNode(temp.pop());
        }
        return res;
    }

//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：36.3 MB, 在所有 Java 提交中击败了28.32%的用户
    public ListNode getKthFromEnd2(ListNode head, int k){
        int num=0;
        ListNode temp = head;
        for (;temp!=null;temp=temp.next){
            num++;
        }
        for (int i=0;i<num-k;i++){
            head=head.next;
        }
        return head;
    }

    //双指针
//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：36.2 MB, 在所有 Java 提交中击败了56.25%的用户
    public ListNode getKthFromEnd3(ListNode head, int k){
        ListNode slow = head;
        ListNode fast = head;

        for (int i=0;i<k;i++){
            fast=fast.next;
        }
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
