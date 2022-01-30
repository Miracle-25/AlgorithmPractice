package DataStructureMID.No2addTwoNumbers;

//        给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
//        请你将两个数相加，并以相同形式返回一个表示和的链表。
//        你可以假设除了数字 0 之外，这两个数都不会以 0开头。
//
//        示例 1：
//        输入：l1 = [2,4,3], l2 = [5,6,4]
//        输出：[7,0,8]
//        解释：342 + 465 = 807.
//
//        示例 2：
//        输入：l1 = [0], l2 = [0]
//        输出：[0]

//        示例 3：
//        输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//        输出：[8,9,9,9,0,0,0,1]

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class addTwoNumbers {
//    执行用时：2 ms, 在所有 Java 提交中击败了89.57%的用户
//    内存消耗：38.2 MB, 在所有 Java 提交中击败了95.85%的用户
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0) ;
        ListNode resfin = res;
        int temp=0;
        while (l1!=null || l2!=null){
            if (l1!=null && l2!=null){
                int sum = l1.val+ l2.val+temp;
                res.next = new ListNode(sum%10);
                temp=sum/10;
                l1 = l1.next;
                l2 = l2.next;
            }else if (l1==null){
                int sum = l2.val+temp;
                res.next = new ListNode(sum%10);
                temp=sum/10;
                l2 = l2.next;
            }else {
                int sum = l1.val+temp;
                res.next = new ListNode(sum%10);
                temp=sum/10;
                l1 = l1.next;
            }
            res=res.next;
        }
        if (temp!=0){
            res.next = new ListNode(temp);
        }
        return resfin.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l2 = new ListNode(2,new ListNode(4,new ListNode(3)));
        System.out.println(addTwoNumbers(l1,l2));
    }
}
