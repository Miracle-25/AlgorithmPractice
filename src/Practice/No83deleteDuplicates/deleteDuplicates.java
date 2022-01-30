package Practice.No83deleteDuplicates;

//        存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
//        返回同样按升序排列的结果链表。
//
//        示例 1：
//        输入：head = [1,1,2]
//        输出：[1,2]
//
//        示例 2：
//        输入：head = [1,1,2,3,3]
//        输出：[1,2,3]

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class deleteDuplicates {
//    执行用时：1 ms, 在所有 Java 提交中击败了8.16%的用户
//    内存消耗：37.6 MB, 在所有 Java 提交中击败了93.43%的用户
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode res = head;
        int temp = head.val;
        while (res.next!=null){
            if (res.next.val==temp){
                res.next = res.next.next;
            }else {
                temp=res.next.val;
                res = res.next;
            }
        }
        return head;
    }
}
