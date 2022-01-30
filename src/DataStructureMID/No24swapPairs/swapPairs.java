package DataStructureMID.No24swapPairs;

//        给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//        你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//        示例 1：
//        输入：head = [1,2,3,4]
//        输出：[2,1,4,3]
//
//        示例 2：
//        输入：head = []
//        输出：[]
//
//        示例 3：
//        输入：head = [1]
//        输出：[1]

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class swapPairs {
//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：35.9 MB, 在所有 Java 提交中击败了64.99%的用户
    public ListNode swapPairs(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        ListNode res = new ListNode(-1,head);
        ListNode temp = head.next;
        res.next.next = swapPairs(head.next.next);
        temp.next = res.next;
        res.next = temp;

        return res.next;
    }
}
