package Practice.No21mergeTwoLists;

//        将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//        示例 1：
//        输入：l1 = [1,2,4], l2 = [1,3,4]
//        输出：[1,1,2,3,4,4]
//
//        示例 2：
//        输入：l1 = [], l2 = []
//        输出：[]
//
//        示例 3：
//        输入：l1 = [], l2 = [0]
//        输出：[0]

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class mergeTwoLists {
//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：37.8 MB, 在所有 Java 提交中击败了63.19%的用户
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null && l2==null){
            return null;
        }else if (l1 ==null){
            return l2;
        }else if (l2==null){
            return l1;
        }
        if (l1.next==null && l2.next==null){
            if (l1.val<l2.val){
                l1.next = l2;
                return l1;
            }else {
                l2.next = l1;
                return l2;
            }
        }else if (l1.next==null){
            if (l1.val<=l2.val){
                l1.next=l2;
                return l1;
            }
        }else if (l2.next==null){
            if (l2.val<=l1.val){
                l2.next=l1;
                return l2;
            }
        }
        if (l1.val<= l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
