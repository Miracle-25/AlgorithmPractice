package Practice.No19removeNthFromEnd;

//        给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
//        进阶：你能尝试使用一趟扫描实现吗？
//
//        示例 1：
//        输入：head = [1,2,3,4,5], n = 2
//        输出：[1,2,3,5]
//
//        示例 2：
//        输入：head = [1], n = 1
//        输出：[]
//
//        示例 3：
//        输入：head = [1,2], n = 1
//        输出：[1]

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class removeNthFromEnd {
//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：36.5 MB, 在所有 Java 提交中击败了30.64%的用户
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next==null){
            return null;
        }
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode fast = res;
        ListNode slow = res;
        for (int i=0;i<n;i++){
            fast = fast.next;
        }
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return res.next;
    }


}
